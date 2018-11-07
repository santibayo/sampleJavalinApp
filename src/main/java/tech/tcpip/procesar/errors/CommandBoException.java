package tech.tcpip.procesar.errors;

/**
 * Created by santiago on 11/7/18.
 */
public class CommandBoException extends Exception {
    public CommandBoException(String message) {
        super(message);
    }

    public CommandBoException(Throwable cause) {
        super(cause);
    }
}
