package org.sopt.server.cgv.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Country {

    KOREA("한국"),
    USA("미국"),
    JAPAN("일본");

    private final String name;

}