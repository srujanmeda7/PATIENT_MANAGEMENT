# Patient Management System

## Overview
The **Patient Management System** is a microservices-based application designed to manage patient records, billing, authentication, analytics, and integrations efficiently. It uses **Spring Boot** for backend services and follows a distributed architecture with **gRPC** and **Kafka** for communication.

## Microservices Architecture
- 🚑 **Patient Service**: Manages patient records (CRUD operations)
- 💰 **Billing Service**: Handles billing account creation via gRPC
- 🌐 **API Gateway**: Entry point for all microservices, routing requests
- 🔑 **Auth Service**: Manages authentication and authorization using JWT
- 📊 **Analytics Service**: Logs patient events for future insights
- 🔗 **Integration Service**: Conducts automated API integration testing

## Technologies Used
- 🖥 **Spring Boot** (Microservices framework)
- 🔒 **Spring Security & JWT** (Authentication & Authorization)
- 🗄 **PostgreSQL** (Database for patient and billing data)
- 🔗 **gRPC** (Efficient service-to-service communication)
- 🚀 **Apache Kafka** (Event-driven communication)
- 🌉 **Spring Cloud Gateway** (API Gateway for routing requests)
- 🧪 **RestAssured** (API testing framework)
- 🐳 **Docker** (Containerization)

## Installation & Setup

### Clone the Repository
```sh
   git clone https://github.com/srujanmeda7/PATIENT_MANAGEMENT.git
   cd PATIENT_MANAGEMENT
```

### Running with Docker
To containerize and run all microservices using Docker, follow these steps:

1. **Build Docker Images** for each microservice:
```sh
   mvn clean package -DskipTests
   docker build -t patient-service ./patient-service
   docker build -t billing-service ./billing-service
   docker build -t auth-service ./auth-service
   docker build -t api-gateway ./api-gateway
   docker build -t analytics-service ./analytics-service
   docker build -t integration-service ./integration-service
```

2. **Start Services with Docker Compose**:
```sh
   docker-compose up -d
```

3. **Stop Services**:
```sh
   docker-compose down
```

### Running Services Manually
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
```
## Docker Setup 🐳

Each microservice has a Dockerfile for containerization, including port bindings, environment variables, and dependencies.
All Docker configurations were set up within IntelliJ IDEA Ultimate.
```
```

## gRPC Integration (Billing Service)
The **Billing Service** exposes a gRPC-based API for creating billing accounts.
It listens for **BillingRequest** messages and responds with **BillingResponse** messages containing the generated account details.



## Contribution
Contributions are welcome! To contribute:
1. 🍴 **Fork** the repository.
2. 🌿 **Create a feature branch** (`git checkout -b feature-name`).
3. 💾 **Commit changes** (`git commit -m 'Add new feature'`).
4. 🚀 **Push to the branch** (`git push origin feature-name`).
5. 🔄 **Create a Pull Request**.

## License
📜 This project is licensed under the MIT License.

---
Let me know if you need any modifications or additional details! 🚀

