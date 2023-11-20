package org.sopt.server.cgv.global.exception;

import lombok.Getter;
import org.sopt.server.cgv.global.response.ErrorType;

@Getter
public class CommonException extends RuntimeException {

    private final ErrorType errorType;

    public CommonException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public int getHttpStatus() {
        return errorType.getHttpStatusCode();
    }
}