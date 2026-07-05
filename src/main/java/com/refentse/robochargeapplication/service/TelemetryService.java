package com.refentse.robochargeapplication.service;

import com.refentse.robochargeapplication.model.ChargingDecision;
import org.springframework.stereotype.Service;

@Service
public class TelemetryService {

    public ChargingDecision determineChargingDecision(int batteryLevel) {

        if (batteryLevel >= 95) {
            return ChargingDecision.FULLY_CHARGED;
        }

        if (batteryLevel >= 41) {
            return ChargingDecision.CONTINUE_WORKING;
        }

        if (batteryLevel >= 20) {
            return ChargingDecision.LOW_BATTERY_WARNING;
        }

        return ChargingDecision.GO_TO_CHARGING_STATION;
    }
}
