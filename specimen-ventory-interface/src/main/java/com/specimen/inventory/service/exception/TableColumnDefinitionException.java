package com.specimen.inventory.service.exception;

/**
 * user: ryan.moore@sparcedge.com
 * date: 4/27/13
 */
public class TableColumnDefinitionException extends Exception {

    public TableColumnDefinitionException(String message, Throwable cause) {
        super(message, cause);
    }

    public TableColumnDefinitionException(String message) {
        super(message);
    }

    public TableColumnDefinitionException(Throwable cause) {
        super(cause);
    }
}
