package com.jeju.main.domain.guesthouse.domain;

import java.util.Arrays;

public enum Region {
    NORTH("북쪽"),
    WEST("서쪽"),
    EAST("동쪽"),
    SOUTH("남쪽");

    private final String description;

    Region(String description) {
        this.description = description;
    }

    public static Region getEnumRegionFromStringRegion(String stringRegion) {
        return Arrays.stream(values())
                .filter(Reigon -> Reigon.description.equals(stringRegion))
                .findFirst()
                .orElseThrow(null);
    }
}
