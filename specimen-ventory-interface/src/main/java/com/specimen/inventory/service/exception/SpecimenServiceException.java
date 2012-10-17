package com.specimen.inventory.service.exception;

/**
 * user: ryan.moore
 * date: 10/16/12
 */
public class SpecimenServiceException extends Exception {

    public SpecimenServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpecimenServiceException(String message) {
        super(message);
    }

    public SpecimenServiceException(Throwable cause) {
        super(cause);
    }
}
