package com.refentse.robochargeapplication.repository;

import com.refentse.robochargeapplication.model.Telemetry;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RobotRepository {

    private final Map<String, Telemetry> robots = new HashMap<>();

    public void save(Telemetry telemetry) {
        robots.put(telemetry.getRobotName(), telemetry);
    }

    public Collection<Telemetry> findAll() {
        return robots.values();
    }

    public Telemetry findByName(String robotName) {
        return robots.get(robotName);
    }
}