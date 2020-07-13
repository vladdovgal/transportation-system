package com.dovhal.model;

/**
 * <h1> City </h1>
 * Class designed to describe city entity
 *
 * @author vladd
 * @version 1.0
 */

public class City extends Entity {
    private String id;

    private String cityName;

    /*
    cityAlias - short name of the city
     */
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

