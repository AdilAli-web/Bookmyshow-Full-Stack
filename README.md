# 🎬 BookMyShow — Full-Stack Movie Ticket Booking Application

A full-stack movie ticket booking application inspired by platforms like BookMyShow. This project is built to practice and demonstrate real-world **backend development, REST APIs, database relationships, transactions, concurrency handling, and frontend integration**.

> 🚧 **Project Status:** Work in Progress
> I’m continuously improving the application by adding new features, improving the UI, refining the backend architecture, and making the application more robust and scalable.

---

## 📌 Features

### 🎥 Movie & Show Management

* Browse available movies
* Search shows based on **city and date**
* Display theatres and show timings
* Show movie information and ticket prices
* Display available seats

### 🎟️ Booking System

* Select available seats
* Book multiple seats
* View booking details
* Cancel bookings
* Automatically update seat availability after booking/cancellation

### 🔐 Backend Features

* RESTful APIs using Spring Boot
* DTO-based request and response handling
* Request validation
* Global exception handling
* Transaction management
* Database relationships using JPA/Hibernate
* Custom JPQL queries
* `JOIN FETCH` for efficient data retrieval
* Pessimistic locking for concurrent seat booking
* Entity relationships such as:

  * Movie → Shows
  * Theatre → Shows
  * Customer → Bookings
  * Booking → Seats

---

## 🛠️ Tech Stack

### Backend

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **Hibernate**
* **REST APIs**
* **MySQL**
* **Maven**

### Frontend

* **React**
* HTML
* CSS
* JavaScript

### Tools

* IntelliJ IDEA
* VS Code
* Postman
* MySQL Workbench
* Git & GitHub

---

## 🏗️ Project Structure

```text
Bookmyshow-Full-Stack/
│
├── SpringBoot/
│   └── BookMyShowBE/
│       ├── src/
│       ├── pom.xml
│       └── ...
│
├── UI/
│   ├── src/
│   ├── public/
│   └── ...
│
└── README.md
```

---

## 🔄 Booking Flow

```text
User
  │
  ▼
Select City
  │
  ▼
Select Date
  │
  ▼
View Movies & Shows
  │
  ▼
Select Show
  │
  ▼
View Available Seats
  │
  ▼
Select Seats
  │
  ▼
Create Booking
  │
  ▼
Update Seat Availability
  │
  ▼
Booking Confirmed
```

---

## 🧩 Backend Architecture

The backend follows a layered architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

### Controller

Handles HTTP requests and responses.

### Service

Contains the application's business logic.

### Repository

Uses Spring Data JPA to communicate with the database.

### Database

MySQL stores movies, theatres, shows, customers, bookings and seat-related information.

---

## 🔗 Important Backend Concepts Implemented

### DTOs

DTOs are used to control the data exchanged between the frontend and backend.

Examples include:

* Booking Request DTO
* Booking Response DTO
* Show Response DTO

### Validation

Request validation is implemented to ensure that invalid data does not enter the application.

### Global Exception Handling

The application uses centralized exception handling to return consistent error responses instead of exposing raw server errors.

### Transactions

Booking and cancellation operations are handled using transactions so that related database operations are executed consistently.

### Pessimistic Locking

Seat updates use database locking to help prevent multiple users from successfully booking the same seat at the same time.

### JPQL & JOIN FETCH

Custom JPQL queries are used to retrieve related entities efficiently and reduce unnecessary database queries.

---

## 🗄️ Database

The application uses **MySQL** as the relational database.

Main entities include:

```text
Movie
   │
   └── Show
          │
          └── Theatre

Customer
   │
   └── Booking
          │
          └── Booking Seats
```

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/AdilAli-web/Bookmyshow-Full-Stack.git
```

```bash
cd Bookmyshow-Full-Stack
```

---

## ⚙️ Backend Setup

Navigate to the Spring Boot project:

```bash
cd SpringBoot/BookMyShowBE
```

Make sure you have:

* Java 17+ installed
* Maven installed
* MySQL running

Configure your database connection in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bookmyshow?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Run the application:

```bash
mvn spring-boot:run
```

The backend will start on the configured Spring Boot port.

---

## 💻 Frontend Setup

Navigate to the UI directory:

```bash
cd UI
```

Install dependencies:

```bash
npm install
```

Start the development server:

```bash
npm run dev
```

The frontend will then be available at the URL shown in your terminal.

---

## 🧪 API Testing

The backend APIs can be tested using **Postman**.

Example operations include:

```text
GET     /shows
POST    /bookings
GET     /bookings/{id}
DELETE  /bookings/{id}
```

> Endpoint paths may change as the project continues to evolve.

---

## 📸 Screenshots

Screenshots of the application will be added here as the UI continues to improve.

```text
Coming Soon 🚧
```

---

## 🔮 Future Improvements

This project is actively being improved.

Planned improvements include:

* 🔐 User authentication & authorization
* 👤 User profile management
* 💳 Online payment integration
* ⭐ Movie ratings and reviews
* 🔎 Improved movie search and filtering
* 📱 Better responsive design
* 🎨 Further UI/UX improvements
* ⚡ Backend performance optimization
* 🧪 More unit and integration tests
* 🐳 Docker support
* ☁️ Cloud deployment
* 📊 Admin dashboard
* 🎫 Improved booking history
* 🔔 Booking confirmation notifications

---

## 🎯 What I Learned

Through this project, I have gained practical experience with:

* Building REST APIs using Spring Boot
* Spring Data JPA & Hibernate
* Entity relationships
* MySQL database design
* DTOs and validation
* Exception handling
* Transactions
* Concurrent booking scenarios
* Database locking
* JPQL queries
* Frontend-backend integration
* Git and GitHub
* Debugging real-world application issues

---

## 🚧 Current Status

This is an **ongoing learning project**.

The core movie browsing, show selection, seat selection, booking and cancellation functionality has been implemented.

I will continue improving the project by adding new features, improving the UI/UX, optimizing the backend, and exploring better approaches to building scalable applications.

---

## 👨‍💻 Author

**Adil Ali**

MCA Student | Java & Spring Boot Developer

GitHub:
https://github.com/AdilAli-web

---

## ⭐ Support

If you find this project useful or interesting, consider giving it a ⭐ on GitHub!

More improvements coming soon 🚀
