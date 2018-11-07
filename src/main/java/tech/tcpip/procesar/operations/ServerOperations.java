package tech.tcpip.procesar.operations;

import io.javalin.Context;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * Created by santiago on 11/7/18.
 */
public class ServerOperations {
    public static void cleanMDC(){
        MDC.remove("request-uuid");
        MDC.remove("request-ip");
    }
    public static  void putMDC(Context ctx){
        MDC.put("request-uuid", UUID.randomUUID().toString());
        MDC.put("request-ip",ctx.ip());
    }
}
