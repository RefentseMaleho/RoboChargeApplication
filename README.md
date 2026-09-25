RoboChargeApplication 🤖🔋

Data Engineering Elective Project

Your verification code:

WTC-9P7L6GF8

RoboChargeApplication is a robotics-focused data processing and backend application built with Java and Spring Boot.

The project demonstrates a simple data engineering workflow for collecting robot telemetry, processing the incoming data, storing it, and making the processed information available through REST APIs.

The goal is to build a small, understandable system that shows how robot-generated data can move through an application and be transformed into useful information for monitoring and decision-making.

🎯 Project Purpose

Robots continuously generate information such as:

Battery level

Robot status

Robot name

Timestamp

RoboChargeApplication receives this telemetry and processes it to determine what action should be taken based on the robot's battery level.

For example:

Robot sends telemetry
↓
Telemetry is received
↓
Battery data is processed
↓
Charging decision is calculated
↓
Telemetry is stored
↓
Processed data can be retrieved

This represents a simplified data pipeline.

🏗️ Data Engineering Component

The project applies several fundamental data engineering concepts.

1. Data Ingestion

Robot telemetry enters the system through a REST API.

POST /telemetry

Example:

{
"robotName": "Robot-1",
"batteryLevel": 35,
"status": "WORKING",
"timestamp": "2026-09-25T20:30:00"
}

The API acts as the entry point for robot-generated data.

2. Data Processing

The TelemetryService processes incoming telemetry.

The battery level is transformed into a meaningful charging decision:

Battery Level

Processed Decision

95% and above

FULLY_CHARGED

41% - 94%

CONTINUE_WORKING

20% - 40%

LOW_BATTERY_WARNING

Below 20%

GO_TO_CHARGING_STATION

This demonstrates how raw telemetry can be transformed into useful information.

3. Data Storage

The application currently uses an in-memory repository backed by a Java HashMap.

Map<String, Telemetry>

The repository stores telemetry associated with each robot and allows the application to retrieve it later.

This provides the storage layer of the current data pipeline.

4. Data Retrieval

Processed and stored robot data can be accessed through REST endpoints.

GET /robots

and:

GET /robots/{name}

This allows other applications or clients to consume the robot data.

🔄 Data Pipeline

The core data flow can be represented as:

                  ROBOT
                    │
                    │
                    ▼
           ┌─────────────────┐
           │  Data Ingestion │
           │   POST /telemetry│
           └────────┬────────┘
                    │
                    ▼
           ┌─────────────────┐
           │ Data Processing │
           │                 │
           │ Battery level   │
           │ → Decision      │
           └────────┬────────┘
                    │
                    ▼
           ┌─────────────────┐
           │  Data Storage   │
           │   Repository    │
           └────────┬────────┘
                    │
                    ▼
           ┌─────────────────┐
           │  Data Access    │
           │ GET /robots     │
           └─────────────────┘

The pipeline demonstrates the movement of data from source → ingestion → processing → storage → consumption.

🛠️ Technologies Used

Java 25

Spring Boot 3.5.16

Spring Web

Maven

REST API

Git & GitHub

Postman

Java Collections / HashMap

🏛️ Application Architecture

The application uses a simple layered architecture:

com.refentse.robochargeapplication
│
├── controller
│   └── TelemetryController
│
├── model
│   ├── Telemetry
│   ├── RobotStatus
│   └── ChargingDecision
│
├── service
│   └── TelemetryService
│
└── repository
└── RobotRepository

Controller Layer

TelemetryController receives HTTP requests and exposes the application's REST endpoints.

Service Layer

TelemetryService contains the data-processing and business logic.

It receives telemetry and determines the appropriate charging decision based on the battery level.

Repository Layer

RobotRepository manages the current telemetry stored by the application.

Model Layer

The model classes represent the data moving through the pipeline.

🌐 REST API

Submit Robot Telemetry

POST /telemetry

Example request:

{
"robotName": "Robot-1",
"batteryLevel": 35,
"status": "WORKING",
"timestamp": "2026-09-25T20:30:00"
}

Retrieve All Robots

GET /robots

Returns the robots currently stored by the application.

Retrieve a Specific Robot

GET /robots/{name}

Example:

GET /robots/Robot-1

Returns the telemetry associated with the specified robot.

🔋 Example Data Processing

Suppose a robot sends:

{
"robotName": "Robot-2",
"batteryLevel": 15,
"status": "WORKING",
"timestamp": "2026-09-25T20:45:00"
}

The application processes:

Raw Data
│
├── Robot: Robot-2
├── Battery: 15%
└── Status: WORKING
│
▼
Data Processing
│
▼
Battery < 20%
│
▼
GO_TO_CHARGING_STATION

The raw battery value is therefore transformed into a meaningful operational decision.

📊 Data Engineering Concepts Demonstrated

Concept

Implementation

Data source

Robot telemetry

Data ingestion

REST API

Data processing

TelemetryService

Data transformation

Battery level → charging decision

Data storage

RobotRepository

Data retrieval

REST GET endpoints

Data pipeline

Ingestion → processing → storage → retrieval

Structured data

Telemetry model

Data timestamps

LocalDateTime

Data access

REST API

💻 Running the Application

1. Clone the repository

git clone <your-repository-url>
cd RoboChargeApplication

2. Run the application

On Windows:

mvnw.cmd spring-boot:run

Or run the Spring Boot application directly from IntelliJ IDEA.

3. Access the application

The application runs locally at:

http://localhost:8080

4. Test with Postman

With the application running, use Postman to send telemetry and retrieve robot data through the REST API.

🧪 Example Workflow

A typical data flow looks like this:

1. Robot generates telemetry
   ↓
2. POST /telemetry
   ↓
3. Spring Boot receives the data
   ↓
4. TelemetryService processes the battery level
   ↓
5. ChargingDecision is generated
   ↓
6. RobotRepository stores the telemetry
   ↓
7. GET /robots retrieves the stored data

📈 Future Data Engineering Improvements

The current application provides the foundation for a larger telemetry data pipeline.

Possible future improvements include:

Persistent Data Storage

Replace the in-memory HashMap with a database such as PostgreSQL or a cloud database.

Historical Telemetry

Instead of only keeping the current robot telemetry, store telemetry records over time.

For example:

Robot-1 | 80% | 10:00
Robot-1 | 65% | 10:15
Robot-1 | 42% | 10:30
Robot-1 | 18% | 10:45

This would create a historical dataset that could be analysed.

Data Validation

Add validation for incoming telemetry, such as:

Battery level must be between 0 and 100

Robot name cannot be empty

Timestamp must be valid

Robot status must be valid

Data Analysis

Historical telemetry could be used to calculate:

Average battery level per robot

Lowest battery level

Number of low-battery events

Number of charging events

Battery trends over time

Cloud Data Pipeline

The application could eventually be extended with AWS services for:

Robot
↓
API
↓
Cloud Storage
↓
Data Processing
↓
Historical Dataset
↓
Analytics

These improvements would allow the project to evolve from a small local data pipeline into a more complete cloud-based data engineering solution.

🎓 Learning Outcomes

This project demonstrates practical experience with:

Data ingestion

Data processing

Data transformation

Data storage

Data retrieval

REST APIs

Backend application architecture

Object-oriented programming

Java and Spring Boot

Git and GitHub

Working with structured telemetry data

It also demonstrates how robotics data can be collected and transformed into information that supports operational decisions.

👤 Author

Refentse Neke

Aspiring AI & Machine Learning / Robotics Engineer with an interest in robotics, software development, cloud technologies and data engineering.

⭐ RoboChargeApplication — turning robot telemetry into useful data.