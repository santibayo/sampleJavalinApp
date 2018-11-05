package tech.tcpip.procesar.operations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.tcpip.procesar.dto.ProcesarRequest;
import tech.tcpip.procesar.dto.ProcesarResponse;
import tech.tcpip.procesar.ioc.Configuration;

public class ProcesarCommand implements Command {
    private final Logger logger = LoggerFactory.getLogger(Configuration.class);
    @Override
    public void perform(ProcesarRequest request, ProcesarResponse response) {
        response.setFolio("00000000000000000000");
        response.setDiagnosticCode("00");
        response.setDiagnosticDescription("una descripcion muy larga");
        response.setHelpText("mucha ayuda");
        response.setResultCode("00");
    }
}