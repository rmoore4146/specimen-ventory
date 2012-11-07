package com.specimen.inventory.service.exception;

/**
 * user: ryan.moore
 * date: 11/7/12
 */
public class SurgeryServiceException extends Exception {

    public SurgeryServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public SurgeryServiceException(String message) {
        super(message);
    }

    public SurgeryServiceException(Throwable cause) {
        super(cause);
    }
}
