package com.refentse.robochargeapplication.model;

public class Robot {

        private Long id;
        private String name;
        private int batteryLevel;
        private RobotStatus status;
        private String currentTask;

        public Robot() {
        }

        public Robot(Long id, String name, int batteryLevel, RobotStatus status, String currentTask) {
            this.id = id;
            this.name = name;
            this.batteryLevel = batteryLevel;
            this.status = status;
            this.currentTask = currentTask;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public String getCurrentTask() {
            return currentTask;
        }

        public void setCurrentTask(String currentTask) {
            this.currentTask = currentTask;
        }
    }

