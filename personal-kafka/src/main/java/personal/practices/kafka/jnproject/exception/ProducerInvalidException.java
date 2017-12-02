package personal.practices.kafka.jnproject.exception;

/**
 * Created by CBStubborn on 2017/12/2.
 */
public class ProducerInvalidException extends Exception {

    static final long serialVersionUID = -4068248827751541029L;

    public ProducerInvalidException() {
        super();
    }

    public ProducerInvalidException(String message) {
        super(message);
    }

    public ProducerInvalidException(Throwable cause) {
        super(cause);
    }

    public ProducerInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProducerInvalidException(String message, Throwable cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
