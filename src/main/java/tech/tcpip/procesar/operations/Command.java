package tech.tcpip.procesar.operations;

import tech.tcpip.procesar.dto.ProcesarRequest;
import tech.tcpip.procesar.dto.ProcesarResponse;

public interface Command {
    public void perform(ProcesarRequest request, ProcesarResponse response);
}
