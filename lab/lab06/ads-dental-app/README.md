# ADS Dental Appointments Management System

This is a Spring Boot application developed as part of the **CS489** course **Lab 06** for managing operations in the **ADS Dental Surgeries** network. It includes features for handling:

- Patients
- Dentists
- Dental Surgeries
- Appointments
- Users & Roles (for system access)

---

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- MapStruct
- Lombok
- Swagger / OpenAPI
- Gradle (Build Tool)

---

## Features

- Full CRUD operations for all entities
- Clean DTO ↔ Entity mapping using MapStruct
- Optional-based service structure for safer null handling
- Swagger UI for API exploration
- Modular project structure following best practices

---
### PostgreSQL Setup

Create a database named `adsdentaldb`:

```sql
CREATE DATABASE adsdentaldb;
```

#### Update your DB credentials in src/main/resources/application.properties:

properties
```
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
```


### Swagger / OpenAPI Docs
Once the app is running, visit:

Swagger UI: http://localhost:8080/swagger-ui.html

OpenAPI JSON: http://localhost:8080/v3/api-docs

You can also import this into Postman via link/copy-paste the json.


## Screenshots

### 01. List all Patients
![01](./screenshots/01.png)

### 02a. View Patient by ID
![02a](./screenshots/02a.png)

### 02b. View Patient - Not Found Error
![02b](./screenshots/02b.png)

### 03. Add New Patient
![03](./screenshots/03.png)

### 04. Update Patient
![04](./screenshots/04.png)

### 05. Delete Patient
![05](./screenshots/05.png)

### 06. Search Patient by Name
![06](./screenshots/06.png)

### ✅ 07. List All Addresses
![07](./screenshots/07.png)



