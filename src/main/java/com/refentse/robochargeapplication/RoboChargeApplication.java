package com.refentse.robochargeapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RoboChargeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoboChargeApplication.class, args);
    }
}
