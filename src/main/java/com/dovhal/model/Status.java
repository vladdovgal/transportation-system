package com.dovhal.model;

public enum Status {
    IN_CITY_SENDER(1),
    IN_THE_WAY(2),
    IN_CITY_RECIPIENT(3),
    TAKEN(4);

    private final int value;

    private Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}