package com.refentse.robochargeapplication.service;

import com.refentse.robochargeapplication.dto.ChargingResponse;
import com.refentse.robochargeapplication.model.ChargingDecision;
import com.refentse.robochargeapplication.model.Telemetry;
import org.springframework.stereotype.Service;

@Service
public class TelemetryService {

    public ChargingResponse processTelemetry(Telemetry telemetry) {

        ChargingDecision decision;

        if (telemetry.getBatteryLevel() >= 95) {
            decision = ChargingDecision.FULLY_CHARGED;
        } else if (telemetry.getBatteryLevel() >= 41) {
            decision = ChargingDecision.CONTINUE_WORKING;
        } else if (telemetry.getBatteryLevel() >= 20) {
            decision = ChargingDecision.LOW_BATTERY_WARNING;
        } else {
            decision = ChargingDecision.GO_TO_CHARGING_STATION;
        }

        String message;

        switch (decision) {
            case FULLY_CHARGED ->
                    message = "Robot is fully charged.";

            case CONTINUE_WORKING ->
                    message = "Robot can continue working.";

            case LOW_BATTERY_WARNING ->
                    message = "Battery is getting low.";

            default ->
                    message = "Robot should proceed to the nearest charging station.";
        }

        return new ChargingResponse(
                telemetry.getRobotName(),
                telemetry.getBatteryLevel(),
                decision,
                message
        );
    }
}