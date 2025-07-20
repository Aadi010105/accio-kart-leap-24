# 🛒 AccioKart REST API (Spring Boot)

A minimal RESTful backend service for managing orders and users in a shopping platform, built using Spring Boot with clean, modular architecture.

---

## 📍 Overview

This project implements basic REST APIs to handle user and order management in an e-commerce context. It's built using Spring Boot and follows a layered architecture that separates responsibilities across controller, service, and repository layers.

---

## 👾 Features

- RESTful APIs for managing users and orders
- Layered architecture: Controller → Service → Repository
- Spring Data JPA integration for persistence
- Exception handling using `@ControllerAdvice`
- Easily configurable and extensible
- Quick setup with Maven

---

## 📁 Project Structure

```
📦 src
 ┣ 📂 main
 ┃ ┣ 📂 java
 ┃ ┃ ┗ 📂 com.acciokart
 ┃ ┃ ┃ ┣ 📜 AccioKartApplication.java           → Main Spring Boot launcher
 ┃ ┃ ┃ ┣ 📂 controller
 ┃ ┃ ┃ ┃ ┣ 📜 OrderController.java              → API for order operations
 ┃ ┃ ┃ ┃ ┗ 📜 UserController.java               → API for user operations
 ┃ ┃ ┃ ┣ 📂 service
 ┃ ┃ ┃ ┃ ┣ 📜 OrderService.java                 → Business logic for orders
 ┃ ┃ ┃ ┃ ┗ 📜 UserService.java                  → Business logic for users
 ┃ ┃ ┃ ┣ 📂 repository
 ┃ ┃ ┃ ┃ ┣ 📜 OrderRepository.java              → JPA repo for orders
 ┃ ┃ ┃ ┃ ┗ 📜 UserRepository.java               → JPA repo for users
 ┃ ┃ ┃ ┣ 📂 entity
 ┃ ┃ ┃ ┃ ┣ 📜 Order.java                        → Order entity class
 ┃ ┃ ┃ ┃ ┗ 📜 User.java                         → User entity class
 ┃ ┃ ┃ ┗ 📂 exception
 ┃ ┃ ┃ ┃ ┣ 📜 CustomExceptionHandler.java       → Global exception handler
 ┃ ┃ ┃ ┃ ┗ 📜 ResourceNotFoundException.java    → Custom exception class
 ┃ ┣ 📂 resources
 ┃ ┃ ┗ 📜 application.properties                → Configuration file
```

---

## ⚙️ Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- (Optional) MySQL or H2 for database

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 17 or later
- Maven installed

### 🛠️ Installation

```bash
git clone https://github.com/Aadi010105/Rest-API-.git
cd Rest-API-
mvn clean install
```

### ▶️ Run the Application

```bash
mvn spring-boot:run
```

Access API at: `http://localhost:8080`

---

## 📬 API Endpoints

### 👤 User APIs

| Method | Endpoint        | Description            |
|--------|------------------|------------------------|
| POST   | `/users`         | Create new user        |
| GET    | `/users`         | Get all users          |
| GET    | `/users/{id}`    | Get user by ID         |
| PUT    | `/users/{id}`    | Update user by ID      |
| DELETE | `/users/{id}`    | Delete user by ID      |

### 📦 Order APIs

| Method | Endpoint          | Description             |
|--------|--------------------|--------------------------|
| POST   | `/orders`          | Create new order         |
| GET    | `/orders`          | Get all orders           |
| GET    | `/orders/{id}`     | Get order by ID          |
| PUT    | `/orders/{id}`     | Update order by ID       |
| DELETE | `/orders/{id}`     | Delete order by ID       |

---

## 🧪 Testing

Run unit tests (if present):

```bash
mvn test
```


## 🙋‍♂️ Author

- **Aaditiya Jain**
- GitHub: [@Aadi010105](https://github.com/Aadi010105)

---

## 📄 License

This project is licensed under the MIT License.

---

## 🌐 Resources

- [Spring Boot Official Docs](https://spring.io/projects/spring-boot)
- [Baeldung – Spring Boot Tutorials](https://www.baeldung.com/)
- [Spring Data JPA Guide](https://spring.io/projects/spring-data-jpa)

