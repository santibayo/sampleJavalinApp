package tech.tcpip.procesar.handlers;

import io.javalin.Context;
import io.javalin.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.tcpip.procesar.dto.ProcesarRequest;
import tech.tcpip.procesar.dto.ProcesarResponse;
import tech.tcpip.procesar.operations.Command;
import tech.tcpip.procesar.operations.ServerOperations;

import java.util.UUID;

public class CustomHandler implements Handler {
    private static final Logger logger = LoggerFactory.getLogger(CustomHandler.class);
    private Command service;

    public static Logger getLogger() {
        return logger;
    }

    public Command getService() {
        return service;
    }

    public void setService(Command service) {
        this.service = service;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        ServerOperations.putMDC(ctx);
        ProcesarRequest request = ctx.bodyAsClass(ProcesarRequest.class);
        logger.info("received mesg: {}",request.toString());
        ProcesarResponse response= new ProcesarResponse();
        //
        logger.info("before procesing");
        service.perform(request,response);
        logger.info("after procesing");
        ServerOperations.cleanMDC();
        ctx.json(response);
    }
}
