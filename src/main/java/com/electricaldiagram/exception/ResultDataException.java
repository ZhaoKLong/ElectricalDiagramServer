package com.electricaldiagram.exception;

import com.electricaldiagram.common.ErrorCode;

/**
 * @author: Zkl
 * @create: 2010-10-09
 * @Description:
 */
public class ResultDataException extends RuntimeException {

    private final ErrorCode code;

    public ResultDataException(ErrorCode code) {
        super(code.getMessage());
        this.code = code;
    }

    public ResultDataException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    public ResultDataException(ErrorCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ResultDataException(ErrorCode code, Throwable cause) {
        super(code.getMessage(), cause);
        this.code = code;
    }

    public final ErrorCode getErrorCode() {
        return code;
    }
}
