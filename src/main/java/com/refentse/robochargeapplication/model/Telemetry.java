package com.refentse.robochargeapplication.model;

import java.time.LocalDateTime;

public class Telemetry {

    private Long id;
    private String robotName;
    private int batteryLevel;
    private RobotStatus status;

    // New fields
    private double temperature;
    private int xCoordinate;
    private int yCoordinate;

    private LocalDateTime timestamp;

    public Telemetry() {
    }

    public Telemetry(Long id,
                     String robotName,
                     int batteryLevel,
                     RobotStatus status,
                     double temperature,
                     int xCoordinate,
                     int yCoordinate,
                     LocalDateTime timestamp) {

        this.id = id;
        this.robotName = robotName;
        this.batteryLevel = batteryLevel;
        this.status = status;
        this.temperature = temperature;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRobotName() {
        return robotName;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public RobotStatus getStatus() {
        return status;
    }

    public void setStatus(RobotStatus status) {
        this.status = status;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}