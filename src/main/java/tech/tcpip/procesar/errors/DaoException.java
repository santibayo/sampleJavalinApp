package tech.tcpip.procesar.errors;

/**
 * Created by santiago on 11/7/18.
 */
public class DaoException extends Exception {

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
