package com.dovhal.model;

/**
 * <h1> Parcel </h1>
 * The Parcel class represents entity "parcel"
 *
 * @author vladd
 * @version 1.0
 * @since 15.04.2020
 */
public class Parcel extends Entity{
    private String id;

    private String senderName;

    private String recipientName;

    private String startCity;

    private String endCity;

    private double weight;

    private String status;

    private String timeCreated;

    private String timeUpdated;


    public Parcel() {
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(String timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "id='" + id + '\'' +
                ", senderName='" + senderName + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", startCity='" + startCity + '\'' +
                ", endCity='" + endCity + '\'' +
                ", weight=" + weight +
                ", status='" + status + '\'' +
                '}';
    }
}
