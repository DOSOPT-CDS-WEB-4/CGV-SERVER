package org.sopt.server.cgv.global.response;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access =  AccessLevel.PRIVATE)
public enum SuccessType {

    /**
     * 200 OK
     */
    GET_USER_SUCCESS(HttpStatus.OK, "특정 사용자 조회 성공");

    /**
     * 201 CREATED
     */


    /**
     * 204 NO CONTENT
     */


    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}