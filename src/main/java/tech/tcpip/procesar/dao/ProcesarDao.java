package tech.tcpip.procesar.dao;

import tech.tcpip.procesar.dto.ProcesarRequest;

import java.util.Map;

/**
 * Created by santiago on 11/6/18.
 */
public interface ProcesarDao {


    public Map<String,String> consultaDatos(ProcesarRequest request)throws Exception;
}
