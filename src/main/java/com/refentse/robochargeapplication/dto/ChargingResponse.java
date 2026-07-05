package com.refentse.robochargeapplication.dto;

import com.refentse.robochargeapplication.model.ChargingDecision;

public class ChargingResponse {

    private String robotName;
    private int batteryLevel;
    private ChargingDecision decision;
    private String message;

    public ChargingResponse() {
    }

    public ChargingResponse(String robotName,
                            int batteryLevel,
                            ChargingDecision decision,
                            String message) {
        this.robotName = robotName;
        this.batteryLevel = batteryLevel;
        this.decision = decision;
        this.message = message;
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

    public ChargingDecision getDecision() {
        return decision;
    }

    public void setDecision(ChargingDecision decision) {
        this.decision = decision;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}