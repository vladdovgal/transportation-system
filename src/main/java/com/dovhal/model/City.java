package com.dovhal.model;

public class City extends Entity {
    private String id;

    private String cityName;

    private String cityAlias;

    public City() {

    }

    public City(String id, String cityName, String cityAlias) {
        this.id = id;
        this.cityName = cityName;
        this.cityAlias = cityAlias;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityAlias() {
        return cityAlias;
    }

    public void setCityAlias(String cityAlias) {
        this.cityAlias = cityAlias;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", cityAlias='" + cityAlias + '\'' +
                '}';
    }
}

//public enum City {
//    LVIV("Lviv"),
//    KYIV("Kyiv"),
//    ODESSA("Odessa"),
//    DNIPRO("Dnipro");
//    private String value;
//
//    City(String value) {
//        this.value = value;
//    }
//
//    @Override
//    public String toString() {
//        return value;
//    }
//}