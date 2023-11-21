package org.sopt.server.cgv.global.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorType {

    /*
    400 BAD REQUEST
     */


    /**
     * 403 FORBIDDEN
     */


    /**
     * 404 NOT FOUND
     */
    NOT_FOUND_SCHEDULE_ERROR(HttpStatus.NOT_FOUND, "존재하지 않는 상영 스케줄입니다"),

    /**
     * 500 INTERNAL SERVER ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 에러가 발생했습니다");

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}