package com.electricaldiagram.exception;

/**
 * @author: Zkl
 * @create: 2010-10-09
 * @Description TODO
 * @Version 1.0
 */
public class ExcelException extends Exception {
    public ExcelException() {
    }

    public ExcelException(String message) {
        super(message);
    }

    public ExcelException(Throwable cause) {
        super(cause);
    }

    public ExcelException(String message, Throwable cause) {
        super(message, cause);
    }
}
