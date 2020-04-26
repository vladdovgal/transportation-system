package com.dovhal.model;

/**
 * Parcel.java represents entity "parcel"
 *
 * @author vladd
 */
public class Parcel {
    private int id;

    private String senderName;

    private String recipientName;

    private String startCity;

    private String endCity;

    private double weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getStartCity() {
        return startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "id=" + id +
                ", senderName='" + senderName + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", startCity=" + startCity +
                ", endCity=" + endCity +
                ", weight=" + weight +
                '}';
    }

}
