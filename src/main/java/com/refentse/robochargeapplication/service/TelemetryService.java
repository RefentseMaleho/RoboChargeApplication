package com.refentse.robochargeapplication.service;

import com.refentse.robochargeapplication.repository.RobotRepository;
import com.refentse.robochargeapplication.dto.ChargingResponse;
import com.refentse.robochargeapplication.model.ChargingDecision;
import com.refentse.robochargeapplication.model.Telemetry;
import org.springframework.stereotype.Service;
import java.util.Collection;
import com.refentse.robochargeapplication.model.Telemetry;

@Service
public class TelemetryService {

    private final RobotRepository robotRepository;

    public TelemetryService(RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }

    public ChargingResponse processTelemetry(Telemetry telemetry) {

        robotRepository.save(telemetry);
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

        public Collection<Telemetry> getAllRobots() {
            return robotRepository.findAll();
        }

        public Telemetry getRobot(String name) {
            return robotRepository.findByName(name);
        }

        return new ChargingResponse(
                telemetry.getRobotName(),
                telemetry.getBatteryLevel(),
                decision,
                message
        );
    }
}