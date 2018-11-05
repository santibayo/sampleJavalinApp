package tech.tcpip.procesar.handlers;

import com.google.inject.Inject;
import io.javalin.Context;
import io.javalin.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.tcpip.procesar.Server;
import tech.tcpip.procesar.dto.ProcesarRequest;
import tech.tcpip.procesar.dto.ProcesarResponse;
import tech.tcpip.procesar.operations.Command;

public class CustomHandler implements Handler {
    Logger logger = LoggerFactory.getLogger(CustomHandler.class);
    Command service= Server.getInjector().getInstance(Command.class);

    @Override
    public void handle(Context ctx) throws Exception {
        ProcesarRequest request = ctx.bodyAsClass(ProcesarRequest.class);
        logger.info("received mesg: {}",request.toString());
        ProcesarResponse response= new ProcesarResponse();
        //
        logger.info("before procesing");
        service.perform(request,response);
        logger.info("after procesing");
        ctx.json(response);
    }
}
