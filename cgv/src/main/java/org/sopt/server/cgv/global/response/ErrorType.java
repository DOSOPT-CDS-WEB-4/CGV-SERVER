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
    NO_SEAT_SCHEDULE_ERROR(HttpStatus.BAD_REQUEST, "해당 상영 스케줄의 잔여 좌석이 부족합니다."),

    /*
     * 403 FORBIDDEN
     */


    /**
     * 404 NOT FOUND
     */
    NOT_FOUND_MOVIE_ERROR(HttpStatus.NOT_FOUND, "존재하지 않는 영화입니다"),
    NOT_FOUND_REGION_ERROR(HttpStatus.NOT_FOUND, "존재하지 않는 지역입니다"),
    NOT_FOUND_SCREEN_TYPE_ERROR(HttpStatus.NOT_FOUND, "존재하지 않는 상영관입니다"),
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
