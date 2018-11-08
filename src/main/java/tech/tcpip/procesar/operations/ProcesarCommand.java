package tech.tcpip.procesar.operations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.tcpip.procesar.dao.ProcesarDao;
import tech.tcpip.procesar.dto.ProcesarRequest;
import tech.tcpip.procesar.dto.ProcesarResponse;
import tech.tcpip.procesar.errors.CommandBoException;
import tech.tcpip.procesar.errors.DaoException;
import tech.tcpip.procesar.ioc.Configuration;

import java.util.Map;
import java.util.Optional;

public class ProcesarCommand implements Command {
    private ProcesarDao dao = null;
    private final Logger logger = LoggerFactory.getLogger(ProcesarCommand.class);

    public void setDao(ProcesarDao dao) {
        this.dao = dao;
    }

    @Override
    public void perform(ProcesarRequest request, ProcesarResponse response) throws DaoException,CommandBoException {

        Map<String,String> respuestaDao = dao.consultaDatos(request);

        //        mapResponse.put("folio",folio);
        //        mapResponse.put("helpText",helpText);
        //        mapResponse.put("diagnosticCode",diagnosticCode);
        //        mapResponse.put("diagnosticDescription",diagnosticDescription);
        //        mapResponse.put("helpText",helpText);
        //

        Optional <Map<String,String>> optionalMap = Optional.ofNullable(respuestaDao);
        if (optionalMap.isPresent()){
            response.setFolio(respuestaDao.get("folio"));
            response.setDiagnosticCode(respuestaDao.get("diagnosticCode"));
            response.setDiagnosticDescription(respuestaDao.get("diagnosticDescription"));
            response.setHelpText(respuestaDao.get("helpText"));
            response.setResultCode(respuestaDao.get("resultCode"));
        }else{
            throw new DaoException("data response was null");
        }

    }
}
