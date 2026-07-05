package com.refentse.robochargeapplication.controller;

import com.refentse.robochargeapplication.model.ChargingDecision;
import com.refentse.robochargeapplication.service.TelemetryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TelemetryController {

    private final TelemetryService telemetryService;

    public TelemetryController(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    @GetMapping("/battery/{batteryLevel}")
    public ChargingDecision getChargingDecision(@PathVariable int batteryLevel) {
        return telemetryService.determineChargingDecision(batteryLevel);
    }
}