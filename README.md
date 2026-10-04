# 🎬 BookMyShow Full-Stack Movie Ticket Booking

A full-stack movie ticket booking application inspired by BookMyShow, built to practice real-world Spring Boot backend development, REST APIs, relational database design, transactions, validation, concurrency control, and frontend-backend integration.

> 🚧 **Status:** Learning project / actively improving

## ✨ Project Outcome

Built an end-to-end movie booking workflow where a user can:

- Browse movies
- Select a city and date
- Find active shows and theatres
- View available seats
- Select multiple seats
- Create a booking
- View booking details and booking history
- Cancel a booking
- Release previously reserved seats

The project also handles important backend concerns such as database relationships, validation, transactions, JPQL, JOIN FETCH, pessimistic locking, and global exception handling.

---

# 🛠️ Tech Stack

### Backend

- Java 21
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- Hibernate
- MySQL
- Jakarta Validation
- Maven
- Lombok

### Frontend

- HTML
- CSS
- JavaScript
- Fetch API
- Browser Local Storage

### Development Tools

- IntelliJ IDEA
- VS Code
- Postman
- MySQL Workbench
- Git & GitHub

---

# 🏗️ High-Level Architecture

~~~~text
┌──────────────────────────────┐
│          Frontend            │
│   HTML + CSS + JavaScript    │
└──────────────┬───────────────┘
               │ HTTP / JSON
               ▼
┌──────────────────────────────┐
│       Spring Boot API        │
│                              │
│       Controllers            │
│            ↓                 │
│         Services             │
│            ↓                 │
│       Repositories           │
└──────────────┬───────────────┘
               │ JPA / Hibernate
               ▼
┌──────────────────────────────┐
│            MySQL             │
│ Movies, Theatres, Shows,     │
│ Profiles, Bookings, Seats    │
└──────────────────────────────┘
~~~~

The backend follows a layered architecture:

~~~~text
Controller
    ↓
Service
    ↓
Repository
    ↓
MySQL
~~~~

---

# 📁 Project Structure

~~~~text
Bookmyshow-Full-Stack/
│
├── SpringBoot/
│   └── BookMyShowBE/
│       ├── src/main/java/com/cfs/BookMyShowBE/
│       │   ├── controller/
│       │   ├── service/
│       │   ├── repository/
│       │   ├── entity/
│       │   ├── dto/
│       │   ├── config/
│       │   └── GlobalException/
│       │
│       ├── src/main/resources/
│       │   └── application.properties
│       │
│       └── pom.xml
│
├── UI/
│   ├── Index.html
│   ├── app.js
│   └── style.css
│
└── README.md
~~~~

---

# 🎯 Main Features

## 🎥 Movie & Show Discovery

- Browse movies
- Search/filter movies in the UI
- Select a city
- Select a date
- Retrieve active shows for that city/date
- Display theatre, show timing and ticket price

The backend uses a custom JPQL query with JOIN FETCH to load the movie and theatre together with each show.

---

## 👤 Profile Management

Users can:

- Create a profile
- Log in using an identifier
- View their booking history

The frontend stores the active profile in browser localStorage.

---

## 💺 Seat Selection

The UI displays available and occupied seats.

Users can:

- Select multiple seats
- See selected seats
- See total booking amount
- Continue to booking confirmation

---

# 🎟️ Booking Flow

A booking request contains:

- Profile ID
- Show ID
- Selected seat labels

Example:

~~~~json
{
  "profileId": 1,
  "seatLabels": ["A1", "A2", "B1"]
}
~~~~

The backend then:

1. Finds the show
2. Finds the customer/profile
3. Normalizes seat labels
4. Rejects duplicate labels
5. Locks the selected seats
6. Verifies that every seat is still available
7. Reserves the seats
8. Updates show availability
9. Calculates the total amount
10. Saves the booking
11. Returns a booking response

---

# 🔒 Concurrency & Double-Booking Protection

One of the most important backend concepts in this project is concurrent seat booking.

Imagine two users try to book the same seats at almost the same time:

~~~~text
User A → A1, A2
User B → A1, A2
~~~~

Without proper concurrency control, both requests could see the seats as available.

The project uses:

~~~~java
@Lock(LockModeType.PESSIMISTIC_WRITE)
~~~~

in ShowSeatRepository.

This locks the selected seat rows while the booking transaction performs its availability check and reservation.

### Booking safety flow

~~~~text
Request
   ↓
@Transactional
   ↓
Find show
   ↓
Find customer
   ↓
Normalize seat labels
   ↓
Reject duplicates
   ↓
PESSIMISTIC_WRITE lock
   ↓
Check seat availability
   ↓
Reserve seats
   ↓
Update available seat count
   ↓
Create booking
   ↓
Commit transaction
~~~~

This is one of the main differences between a basic CRUD project and a booking system that considers concurrent requests.

---

# 🔄 End-to-End Booking Flow

~~~~text
User
 │
 ├── Select City
 │
 ├── Select Date
 │
 ├── View Movies & Shows
 │
 ├── Select Show
 │
 ├── View Available Seats
 │
 ├── Select Seats
 │
 ├── Confirm Booking
 │
 ▼
Spring Boot Backend
 │
 ├── Validate request
 ├── Lock seats
 ├── Check availability
 ├── Reserve seats
 ├── Update show
 ├── Save booking
 │
 ▼
Booking Confirmed
~~~~

---

# ❌ Booking Cancellation Flow

When a confirmed booking is cancelled:

~~~~text
Find booking + profile
        ↓
Check booking status
        ↓
Lock booked seats
        ↓
Release each seat
        ↓
Increase show's available seat count
        ↓
Mark booking CANCELLED
        ↓
Return updated booking
~~~~

This operation is also transactional.

---

# 🗄️ Domain Model

The main domain objects are:

~~~~text
Movie
  │
  └── Show
        │
        ├── Theatre
        │
        └── ShowSeat

Profile / Customer
  │
  └── Booking
        │
        └── Booking Seats
~~~~

Conceptually:

- One movie can have many shows
- A theatre can host many shows
- A show has its own seat inventory
- A customer/profile can have many bookings
- A booking is associated with one show and selected seat labels

---

# 🧩 Backend Layers

## Controller Layer

Controllers handle HTTP requests and delegate business logic.

Main controllers:

- MovieController
- ShowController
- TheatreController
- ProfileController
- BookingController

Examples:

~~~~text
GET  /api/v1/shows
POST /api/v1/bookings/shows/{showId}
GET  /api/v1/bookings/{bookingId}
POST /api/v1/bookings/{bookingId}/cancel
POST /api/v1/profiles
GET  /api/v1/profiles/login
GET  /api/v1/profiles/{profileId}/bookings
~~~~

---

## Service Layer

The service layer contains business rules.

Important services:

- CatalogService
- BookingService
- ProfileService

BookingService is responsible for:

- booking
- cancellation
- seat validation
- concurrency protection
- total amount calculation

---

## Repository Layer

Repositories use Spring Data JPA to communicate with MySQL.

Important repositories include:

- MovieRepository
- ShowRepository
- ShowSeatRepository
- BookingRepository
- CustomerRepository
- TheatreRepository

---

# 🔎 JPQL & JOIN FETCH

The project uses a custom JPQL query in ShowRepository to find active shows for a city and date range while fetching the related movie and theatre.

~~~~java
SELECT s
FROM Show s
JOIN FETCH s.movie m
JOIN FETCH s.theatre t
WHERE s.active = true
  AND m.active = true
  AND t.city = :city
  AND s.startsAt >= :from
  AND s.startsAt < :to
ORDER BY s.startsAt
~~~~

### Why?

The show response needs information from:

- Show
- Movie
- Theatre

JOIN FETCH helps load the required related entities together and avoids unnecessary lazy-loading queries for this use case.

---

# ✅ Validation

Request DTOs use Jakarta Validation with @Valid.

This keeps invalid input from reaching the business logic unnecessarily.

---

# 🚨 Global Exception Handling

The backend contains centralized exception handling through:

- GlobalExceptionHandler
- ExceptionResponse

Custom exceptions cover cases such as:

- BookingException
- BookingNotFound
- CustomerNotFound
- ProfileException
- SeatNotAvailable
- ShowNotFound

This provides more consistent API error responses than exposing raw server exceptions.

---

# 💰 Booking Amount Calculation

The total booking amount is calculated on the backend:

~~~~text
Ticket Price × Number of Seats
~~~~

Example:

~~~~text
Ticket price = ₹250
Seats = 3

Total = ₹250 × 3
      = ₹750
~~~~

The frontend does not decide the final amount.

---

# 🌐 Frontend

The current UI is a lightweight vanilla JavaScript application using:

- Index.html
- style.css
- app.js
- Fetch API
- localStorage

The frontend handles:

- movie rendering
- search/filtering
- city selection
- date selection
- show rendering
- seat selection
- profile creation/login
- booking
- booking history
- cancellation
- modal and toast interactions

The current frontend API base URL is:

~~~~text
http://localhost:8080/api/v1
~~~~

---

# 🔌 Important API Endpoints

## Movies

~~~~http
GET /api/v1/movies
~~~~

## Shows

~~~~http
GET /api/v1/shows?city=Delhi&date=2026-09-18
~~~~

## Create Profile

~~~~http
POST /api/v1/profiles
Content-Type: application/json
~~~~

## Profile Login

~~~~http
GET /api/v1/profiles/login?identifier=...
~~~~

## Create Booking

~~~~http
POST /api/v1/bookings/shows/{showId}
Content-Type: application/json
~~~~

Example:

~~~~json
{
  "profileId": 1,
  "seatLabels": ["A1", "A2"]
}
~~~~

## Get Booking

~~~~http
GET /api/v1/bookings/{bookingId}
~~~~

## Cancel Booking

~~~~http
POST /api/v1/bookings/{bookingId}/cancel?profileId=1
~~~~

## Booking History

~~~~http
GET /api/v1/profiles/{profileId}/bookings
~~~~

---

# 🧪 Postman Testing Flow

A typical API testing sequence:

### 1. Create profile

~~~~http
POST /api/v1/profiles
~~~~

### 2. Find shows

~~~~http
GET /api/v1/shows?city=Delhi&date=2026-09-18
~~~~

### 3. Book seats

~~~~http
POST /api/v1/bookings/shows/2
~~~~

### 4. Check booking

~~~~http
GET /api/v1/bookings/1
~~~~

### 5. View booking history

~~~~http
GET /api/v1/profiles/1/bookings
~~~~

### 6. Cancel booking

~~~~http
POST /api/v1/bookings/1/cancel?profileId=1
~~~~

---

# 🚀 Getting Started

## Prerequisites

Install:

- Java 21
- MySQL
- Maven
- A modern web browser
- Postman (optional)

## 1. Clone the repository

~~~~bash
git clone https://github.com/AdilAli-web/Bookmyshow-Full-Stack.git
cd Bookmyshow-Full-Stack
~~~~

## 2. Configure MySQL

Create a database named:

~~~~text
bookmyshow
~~~~

Update:

~~~~text
SpringBoot/BookMyShowBE/src/main/resources/application.properties
~~~~

Example:

~~~~properties
spring.datasource.url=jdbc:mysql://localhost:3306/bookmyshow?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.open-in-view=false
~~~~

> Never commit real production database credentials to a public repository. Use environment variables or local secret configuration.

## 3. Start the backend

~~~~bash
cd SpringBoot/BookMyShowBE
mvn spring-boot:run
~~~~

Or run BookMyShowBeApplication.java from IntelliJ IDEA.

The backend normally runs at:

~~~~text
http://localhost:8080
~~~~

## 4. Start the frontend

The current repository contains a vanilla HTML/CSS/JavaScript UI and does not require React, Vite, or an npm build step.

You can serve the UI directory using any local static server or open Index.html through your preferred development setup.

Make sure the backend is running because app.js calls:

~~~~text
http://localhost:8080/api/v1
~~~~

---

# ⚙️ Configuration Notes

The backend uses:

~~~~properties
spring.jpa.open-in-view=false
~~~~

This keeps persistence access explicit rather than depending on Open Session in View.

The schema is currently configured with:

~~~~properties
spring.jpa.hibernate.ddl-auto=update
~~~~

For a production application, database migrations with Flyway or Liquibase would be a better approach.

---

# 📚 Key Concepts Learned

This project was built to understand:

- REST API design
- Layered architecture
- Spring Boot
- Spring Data JPA
- Hibernate
- Entity relationships
- DTOs
- Validation
- JPQL
- JOIN FETCH
- Transactions
- Pessimistic locking
- Concurrency problems
- Seat inventory management
- Global exception handling
- Database consistency
- Frontend-backend integration
- Git and GitHub
- Debugging real application issues

---

# 🧠 What Makes This More Than CRUD?

A basic CRUD application mostly performs:

~~~~text
Create
Read
Update
Delete
~~~~

A booking system introduces a more difficult business problem:

> **What happens when two users try to book the same seat at nearly the same time?**

This project addresses that problem with:

- transactional booking operations
- pessimistic locking
- seat availability validation
- duplicate-seat validation
- atomic seat reservation
- seat release during cancellation

That made the project useful for understanding backend consistency and concurrency, not just CRUD APIs.

---

# 🔮 Future Improvements

- 🔐 JWT authentication and authorization
- 👤 Stronger user/profile security
- 💳 Payment gateway integration
- ⭐ Ratings and reviews
- 📱 Better responsive UI
- 🧪 Unit and integration tests
- 🐳 Docker
- ☁️ Cloud deployment
- 📊 Admin dashboard
- 📧 Booking confirmation email
- 🔔 Notifications
- ⚡ Caching and performance optimization
- 🗂️ Database migrations with Flyway/Liquibase
- 📈 Observability and structured logging

---

# 🎯 Interview Summary

> "I built a full-stack movie ticket booking application using a Spring Boot REST backend, MySQL, JPA/Hibernate, and a vanilla JavaScript frontend. The application supports movie and show discovery, seat selection, booking, booking history, and cancellation. The main backend challenge was preventing double-booking during concurrent seat requests, which I handled using transactions and pessimistic database locking. I also implemented DTOs, request validation, custom JPQL with JOIN FETCH, and centralized exception handling."

---

# 📌 Repository

**GitHub:**  
https://github.com/AdilAli-web/Bookmyshow-Full-Stack

---

# 👨‍💻 Author

**Adil Ali**

MCA Student | Java & Spring Boot Developer

GitHub:  
https://github.com/AdilAli-web

---

⭐ If you find this project useful, consider giving the repository a star.
