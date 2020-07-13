package com.dovhal.model;

/**
 * <h1> Status (enum) </h1>
 Represents information about status of parcel.
 @author vladd
 */
public enum Status {
    IN_CITY_SENDER(1),
    IN_THE_WAY(2),
    IN_CITY_RECIPIENT(3),
    TAKEN(4);


    private final int value;

    /**
     * @param value - id of status
     */
    private Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}