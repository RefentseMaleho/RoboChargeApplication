package com.refentse.robochargeapplication.controller;

import com.refentse.robochargeapplication.dto.ChargingResponse;
import com.refentse.robochargeapplication.model.Telemetry;
import com.refentse.robochargeapplication.service.TelemetryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telemetry")
public class TelemetryController {

    private final TelemetryService telemetryService;

    public TelemetryController(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    @PostMapping
    public ChargingResponse receiveTelemetry(@RequestBody Telemetry telemetry) {
        return telemetryService.processTelemetry(telemetry);
    }
}