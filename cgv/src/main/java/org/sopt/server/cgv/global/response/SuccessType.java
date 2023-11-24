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
    GET_MOVIE_LIST_SUCCESS(HttpStatus.OK, "무비차트 리스트 조회에 성공했습니다."),
    MOVIE_LIKE_SUCCESS(HttpStatus.OK, "영화 좋아요에 성공했습니다."),
    MOVIE_DISLIKE_SUCCESS(HttpStatus.OK, "영화 좋아요 취소에 성공했습니다."),
    GET_MOVIE_AND_SCREEN_TYPE_AND_SCHEDULE_LIST_SUCCESS(HttpStatus.OK, "영화 정보 및 상영관, 상영시간 조회에 성공했습니다."),
    PATCH_RESERVE_SUCCESS(HttpStatus.OK, "영화 에매 결제에 성공했습니다.");


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
