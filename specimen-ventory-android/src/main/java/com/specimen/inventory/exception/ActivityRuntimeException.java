package com.specimen.inventory.exception;

/**
 * user: ryan.moore
 * date: 10/16/12
 */
public class ActivityRuntimeException extends RuntimeException {

    public ActivityRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActivityRuntimeException(String message) {
        super(message);
    }

    public ActivityRuntimeException(Throwable cause) {
        super(cause);
    }

}
