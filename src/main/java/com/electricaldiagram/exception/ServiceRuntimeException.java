package com.electricaldiagram.exception;

/**
 * @author: Zkl
 * @create: 2010-10-09
 */
public class ServiceRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 4690007050061675147L;

    public ServiceRuntimeException() {
    }

    public ServiceRuntimeException(String message) {
        super(message);
    }

    public ServiceRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceRuntimeException(Throwable cause) {
        super(cause);
    }

    public ServiceRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
