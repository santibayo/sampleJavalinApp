package tech.tcpip.procesar.dao;

import tech.tcpip.procesar.dto.ProcesarRequest;
import tech.tcpip.procesar.errors.DaoException;

import java.util.Map;

/**
 * Created by santiago on 11/6/18.
 */
public class ProcesarDaoImpl implements ProcesarDao {

    public void init (){

    }
    @Override
    public Map<String, String> consultaDatos(ProcesarRequest request) throws DaoException {
        return null;
    }
}
