package shop.taeheoki.geocoding.exception;

public class AddressTransformException extends RuntimeException {
    public AddressTransformException() {
        super();
    }

    public AddressTransformException(String message) {
        super(message);
    }

    public AddressTransformException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressTransformException(Throwable cause) {
        super(cause);
    }

    protected AddressTransformException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
