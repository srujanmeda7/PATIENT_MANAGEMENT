# Patient Management System

## Overview
The **Patient Management System** is a microservices-based application designed to manage patient records, billing, authentication, analytics, and integrations efficiently.
It uses **Spring Boot** for backend services and follows a distributed architecture with **gRPC** and **Kafka** for communication.

## Microservices Architecture
- 🏥 **Patient Service**: Manages patient records (CRUD operations)
- 💳 **Billing Service**: Handles billing account creation via gRPC
- 🌐 **API Gateway**: Entry point for all microservices, routing requests
- 🔑 **Auth Service**: Manages authentication and authorization using JWT
- 📊 **Analytics Service**: Logs patient events for future insights
- 🔄 **Integration Service**: Conducts automated API integration testing

## Technologies Used
- ☕ **Spring Boot** (Microservices framework)
- 🔐 **Spring Security & JWT** (Authentication & Authorization)
- 🛢️ **PostgreSQL** (Database for patient and billing data)
- 🔄 **gRPC** (Efficient service-to-service communication)
- 🚀 **Apache Kafka** (Event-driven communication)
- 📡 **Spring Cloud Gateway** (API Gateway for routing requests)
- 🧪 **RestAssured** (API testing framework)

## Installation & Setup

### Clone the Repository
```sh
   git clone https://github.com/srujanmeda7/PATIENT_MANAGEMENT.git
   cd PATIENT_MANAGEMENT
```

### Run Services Individually
Each service has its own module inside the repository. Navigate to the respective module and start the service.

#### Example: Running the Patient Service
```sh
   cd patient-service
   mvn spring-boot:run
```

Repeat the process for other services:
```sh
   cd billing-service && mvn spring-boot:run
   cd auth-service && mvn spring-boot:run
   cd api-gateway && mvn spring-boot:run
   cd analytics-service && mvn spring-boot:run
   cd integration-service && mvn spring-boot:run
```

### Kafka Setup
Ensure Kafka is running before starting the microservices.
```sh
   docker-compose up -d kafka zookeeper
```

## gRPC Integration (Billing Service)
The **Billing Service** exposes a gRPC-based API for creating billing accounts. It listens for **BillingRequest** messages and responds with **BillingResponse** messages containing the generated account details.



