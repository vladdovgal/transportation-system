package com.dovhal.model;

public enum City {
    LVIV("Lviv"),
    KYIV("Kyiv"),
    ODESSA("Odessa"),
    DNIPRO("Dnipro");
    private String value;

    City(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
