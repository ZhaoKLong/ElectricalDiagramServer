package com.electricaldiagram.exception;

/**
 * @author: Zkl
 * @create: 2010-10-09
 * @Description
 * @Version 1.0
 */
public class CustBusinessException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CustBusinessException() {
    }

    public CustBusinessException(String s) {
        super(s);
    }

    public CustBusinessException(String s, Throwable throwable) {
        super(s, throwable);
    }

}
