package tech.tcpip.procesar.operations;

import tech.tcpip.procesar.dto.ProcesarRequest;
import tech.tcpip.procesar.dto.ProcesarResponse;
import tech.tcpip.procesar.errors.CommandBoException;
import tech.tcpip.procesar.errors.DaoException;

public interface Command {
    public void perform(ProcesarRequest request, ProcesarResponse response) throws DaoException,CommandBoException;
}
