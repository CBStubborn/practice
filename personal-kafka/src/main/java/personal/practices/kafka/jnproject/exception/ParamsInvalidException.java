package personal.practices.kafka.jnproject.exception;

/**
 * Created by CBStubborn on 2017/12/2.
 */
public class ParamsInvalidException extends Exception {

    static final long serialVersionUID = -4068248827751541028L;

    public ParamsInvalidException() {
        super();
    }

    public ParamsInvalidException(String message) {
        super(message);
    }

    public ParamsInvalidException(Throwable cause) {
        super(cause);
    }

    public ParamsInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamsInvalidException(String message, Throwable cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
