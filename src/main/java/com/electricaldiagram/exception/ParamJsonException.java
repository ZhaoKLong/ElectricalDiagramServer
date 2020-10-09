package com.electricaldiagram.exception;

/**
 * 参数异常
 *
 * @author: Zkl
 * @create: 2010-10-09
 */
public class ParamJsonException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    public ParamJsonException() {
    }

    public ParamJsonException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
