package com.dovhal.model;

/**
 * <h1> Logging Item </h1>
 * LogItem is class which is used to create
 * entities to store event logs
 * @author vladd
 * @version 1.0
 */
public class LogItem extends Entity{
    private String dated;
    private String logger;
    private String level;
    private String message;

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LogItem{" +
                "dated='" + dated + '\'' +
                ", logger='" + logger + '\'' +
                ", level='" + level + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
