package tech.tcpip.procesar.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import io.javalin.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.tcpip.procesar.dao.ProcesarDao;
import tech.tcpip.procesar.dao.ProcesarDaoImpl;
import tech.tcpip.procesar.errors.DaoException;
import tech.tcpip.procesar.handlers.CustomHandler;
import tech.tcpip.procesar.operations.Command;
import tech.tcpip.procesar.operations.ProcesarCommand;

public class Configuration extends AbstractModule {
    private final Logger logger = LoggerFactory.getLogger(Configuration.class);
    @Override
    protected void configure() {

    }


    @Provides
    @Named("ProcesarHandler")
    @Singleton
    public Handler getProcesarHandler(@Named("ProcesarCommand") Command cmd){
        CustomHandler handler = new CustomHandler();
        handler.setService(cmd);
        return handler;
    }

    @Provides
    @Named("ProcesarCommand")
    @Singleton
    public Command getCommand(@Named ("ProcesarDao")ProcesarDao dao){
        ProcesarCommand command = new ProcesarCommand();
        command.setDao(dao);
        return new ProcesarCommand();
    }


    @Provides
    @Named("ProcesarDao")
    @Singleton
    public ProcesarDao getDao() throws DaoException {
        ProcesarDaoImpl dao = new ProcesarDaoImpl();
        dao.init();
        return dao;
    }

}
