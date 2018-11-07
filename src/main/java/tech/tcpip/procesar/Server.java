package tech.tcpip.procesar;

import ch.qos.logback.classic.util.ContextInitializer;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import io.javalin.Handler;
import io.javalin.Javalin;

import tech.tcpip.procesar.dto.ErrorBean;
import tech.tcpip.procesar.errors.CommandBoException;
import tech.tcpip.procesar.errors.DaoException;
import tech.tcpip.procesar.ioc.Configuration;
import tech.tcpip.procesar.operations.ServerOperations;


import java.io.IOException;
import java.util.Properties;


public class Server {
    public static  Injector injector=null;
    static {
        String env = System.getProperty("ENV","develop");
        System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY,env+"/logback.xml");
        injector = Guice.createInjector(new Configuration());
    }

    public static Injector getInjector() {
        return injector;
    }

    public static void main (String ... args) throws IOException {
        Server  s = new Server();
        String env = System.getProperty("ENV","develop");
        Properties globalConfig = new Properties();
        ClassLoader classLoader = s.getClass().getClassLoader();
        globalConfig.load(classLoader.getResourceAsStream(env+"/global.conf"));
        int defaultPort = Integer.valueOf(globalConfig.getProperty("port"));
        // configuramos el puerto
        Javalin app = Javalin.create().start(defaultPort);
        Handler handler = getInjector().getInstance(Key.get(Handler.class, Names.named("ProcesarHandler")));
        // arrancamos el servicio
        app.post("/service", handler);
        app.exception(DaoException.class, (e, ctx) -> {
            String message = e.getMessage();
            ErrorBean errorBean = new ErrorBean();
            errorBean.setErrorMessage(message);
            ServerOperations.cleanMDC();
            ctx.json(errorBean);
            ctx.status(502); // -> Bad Gateway
        });
        app.exception(CommandBoException.class, (e, ctx) -> {
            String message = e.getMessage();
            ErrorBean errorBean = new ErrorBean();
            errorBean.setErrorMessage(message);
            ServerOperations.cleanMDC();
            ctx.json(errorBean);
            ctx.status(500); // -> Internal Server Error
        });
        app.exception(Exception.class, (e, ctx) -> {
            String message = e.getMessage();
            ErrorBean errorBean = new ErrorBean();
            errorBean.setErrorMessage(message);
            ServerOperations.cleanMDC();
            ctx.json(errorBean);
            ctx.status(500); // -> Internal Server Error
        });


    }



}
