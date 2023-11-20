package org.sopt.server.cgv.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genre {

    ANIMATION("애니메이션"),
    ACTION("액션"),
    HORROR("공포");

    private final String name;

}
