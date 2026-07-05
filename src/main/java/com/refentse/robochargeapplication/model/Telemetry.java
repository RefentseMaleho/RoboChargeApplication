package com.refentse.robochargeapplication.model;

import java.time.LocalDateTime;

public class Telemetry {

    private Long id;
    private String robotName;
    private int batteryLevel;
    private RobotStatus status;
    private LocalDateTime timestamp;

    public Telemetry() {
    }

    public Telemetry(Long id, String robotName, int batteryLevel, RobotStatus status, LocalDateTime timestamp) {
        this.id = id;
        this.robotName = robotName;
        this.batteryLevel = batteryLevel;
        this.status = status;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
