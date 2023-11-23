package org.sopt.server.cgv.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegionName {

    HONGDAE("홍대"),
    CHEONGDAM("청담씨네시티"),
    MOKDONG("목동"),
    PIKADILI("피카디리1958"),
    SHINCHON("신촌아트레온");

    private final String name;

}
