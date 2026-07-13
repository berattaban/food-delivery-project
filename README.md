# 🍔 Food Delivery Project (Spring Cloud Microservices)

This project is a comprehensive Food Delivery backend application developed using **Java, Spring Boot, and Spring Cloud** technologies, designed with a **Microservices Architecture** to ensure high scalability, flexibility, and modularity.

All services within the system boot independently, register themselves dynamically to the service registry, and are exposed to the external world through a centralized entry point.

---

## 🏗️ System and Microservices Architecture

The application is built on the **Separation of Concerns** principle and consists of the following independent components and services:

### 🌐 Infrastructure Components
* **Eureka Server (Service Discovery):** The central service registry where all microservices dynamically register and discover each other.
* **API Gateway:** The single entry point that intercepts all external requests, managing routing, security, and load balancing.

### ⚙️ Business Logic Services
* **Customer / Auth Service:** Manages user registration, login, authentication, and authorization processes.
* **Restaurant / Menu Service:** Manages restaurant details, categories, and menu/food items (full CRUD operations).
* **Order Service:** Handles order creation, real-time status tracking, and order history.
* **Basket / Cart Service:** A dynamic service managing users' active shopping cart processes.

---

## 🚀 Key Technical Features

* **Dynamic Service Discovery & Routing:** Automated IP and port management of services integrated via Eureka Server and Spring Cloud Gateway.
* **Service-to-Service Communication:** Safe, synchronous communication among microservices, adhering to loose coupling principles.
* **Database-per-Service:** Isolated data management where each microservice maintains its own PostgreSQL database instance to prevent tight coupling.
* **Global Exception Handling:** Centralized error handling implemented across all microservices to return unified, meaningful, and structured JSON error responses to the client.
* **Data Transfer Objects (DTOs):** Active use of the DTO pattern to secure database models, abstract business logic, and optimize network payload.

---

## 🛠️ Tech Stack

* **Core Framework:** Java, Spring Boot
* **Microservices Stack:** Spring Cloud Gateway, Netflix Eureka Server
* **Database:** PostgreSQL (Database-per-Service architecture)
* **ORM / Data Access:** Spring Data JPA / Hibernate
