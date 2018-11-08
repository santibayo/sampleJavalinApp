package tech.tcpip.procesar.dao;

import mx.com.procesar.cliente.RecepcionClienteAportaciones;
import mx.com.procesar.recepcionAportaciones.ws.types.RecepcionAhorroVoluntarioPorCurpRespuesta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.tcpip.procesar.dto.ProcesarRequest;
import tech.tcpip.procesar.errors.DaoException;

import javax.xml.datatype.DatatypeConfigurationException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by santiago on 11/6/18.
 */
public class ProcesarDaoImpl implements ProcesarDao {
    RecepcionClienteAportaciones cli = null;
    private final Logger logger = LoggerFactory.getLogger(ProcesarDaoImpl.class);
    public void init ()throws DaoException{
        String urlService = "http://52.41.191.73:80/aportvoluntaria-recaportaciones-ws/RecepcionAportaciones";
        String wsdl = "http://52.41.191.73:80/aportvoluntaria-recaportaciones-ws/RecepcionAportaciones?wsdl";
        try {
            cli = new RecepcionClienteAportaciones(wsdl,urlService);
        } catch (MalformedURLException e) {
            throw new DaoException(e.getMessage());
        }
    }
    @Override
    public Map<String, String> consultaDatos(ProcesarRequest request) throws DaoException {
        HashMap<String,String> mapResponse= new HashMap<>();
        logger.info("peticion recibida ");
        if (cli == null){
            logger.warn("el servicio no se ha podido arrancar");
            return null;
        }
        RecepcionAhorroVoluntarioPorCurpRespuesta respuesta = null;
        try {
            respuesta = cli.recepcionAhorroVoluntarioPorCurp(request.getCurp(), request.getAmount(), request.getContributionType());
        } catch (DatatypeConfigurationException e) {
           throw new DaoException(e.getMessage());
        }

        String folio = respuesta.getObjetoRespuesta().getFolioAck();
        String helpText = respuesta.getObjetoRespuesta().getLeyenda();
        String diagnosticCode = respuesta.getObjetoRespuesta().getDiagnostico();
        String diagnosticDescription = respuesta.getObjetoRespuesta().getDescripcionDiagnostico();
        String resultCode = respuesta.getObjetoRespuesta().getResultado();

        mapResponse.put("folio",folio);
        mapResponse.put("helpText",helpText);
        mapResponse.put("diagnosticCode",diagnosticCode);
        mapResponse.put("diagnosticDescription",diagnosticDescription);
        mapResponse.put("resultCode",resultCode);


        return mapResponse;
    }
}
