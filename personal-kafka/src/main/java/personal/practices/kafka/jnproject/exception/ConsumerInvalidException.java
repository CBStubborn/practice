package personal.practices.kafka.jnproject.exception;

/**
 * Created by CBStubborn on 2017/12/2.
 */
public class ConsumerInvalidException extends Exception {

    static final long serialVersionUID = -4068248827751541027L;

    public ConsumerInvalidException() {
        super();
    }

    public ConsumerInvalidException(String message) {
        super(message);
    }

    public ConsumerInvalidException(Throwable cause) {
        super(cause);
    }

    public ConsumerInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsumerInvalidException(String message, Throwable cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
