package com.electricaldiagram.exception;

/**
 * @author: Zkl
 * @create: 2010-10-09
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }

}