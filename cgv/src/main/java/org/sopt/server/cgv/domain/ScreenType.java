package org.sopt.server.cgv.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ScreenType {

    ALL("전체"),
    NORMAL("일반관"),
    COMFORT("컴포트관"),
    IMAX("IMAX관"),
    GOLDCLASS("GOLD CLASS관");

    private final String name;
    
}

