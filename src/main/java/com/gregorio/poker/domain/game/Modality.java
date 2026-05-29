package com.gregorio.poker.domain.game;

public enum Modality {
    TEXAS(2),
    OMAHA(4),
    SEVEN(7),
    FIVE(5);

    private final int value;

    Modality(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
