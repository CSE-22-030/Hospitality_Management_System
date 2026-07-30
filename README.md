# 🏨 Hospitality Management System

A desktop-based **Hospitality Management System** developed using **Java Swing** and **MySQL** to simplify and organize essential hotel management operations.

The application provides a graphical interface for managing hotels, rooms, guests, and reservations while storing application data in a MySQL database.

---

## 📌 Project Overview

Managing hotel operations manually can become difficult when dealing with multiple guests, rooms, hotels, and reservations.

The **Hospitality Management System** provides a centralized desktop application that helps administrators manage these activities efficiently through a simple graphical user interface.

The system includes:

* 🔐 User authentication
* 📊 Dashboard with management statistics
* 🏨 Hotel management
* 🛏️ Room management
* 👤 Guest management
* 📅 Reservation management
* 🗄️ MySQL database connectivity
* 🖥️ Java Swing-based graphical interface

---

## ✨ Features

### 🔐 Login & Authentication

The application starts with a login screen where users enter their username and password.

Successful authentication redirects the user to the main dashboard, while invalid credentials display an error message.

### 📊 Dashboard

The dashboard provides a quick overview of the system by displaying:

* Total number of hotels
* Total number of rooms
* Total number of guests
* Total number of reservations

This gives administrators a simple summary of the current hotel management data.

### 🏨 Hotel Management

The hotel management module allows administrators to:

* Add new hotels
* Update existing hotel information
* Delete hotels
* Search hotel records
* View hotel details in a table

Hotel information includes:

* Hotel ID
* Hotel name
* Location
* Amenities

### 🛏️ Room Management

The room management module allows administrators to:

* Add rooms
* Delete rooms
* View available room records
* Associate rooms with hotels
* Store room type, price, and status

Room information includes:

* Room ID
* Hotel ID
* Room type
* Price
* Room status

### 👤 Guest Management

The guest management module provides functionality to:

* Add guests
* Delete guests
* View registered guests

Guest information includes:

* Guest ID
* Name
* Email
* Phone number

### 📅 Reservation Management

The reservation module allows administrators to create and manage hotel reservations.

Reservation details include:

* Reservation ID
* Guest ID
* Room ID
* Check-in date
* Check-out date
* Total amount

The application also provides options to add and delete reservations.

---

## 🛠️ Tech Stack

| Technology     | Purpose                          |
| -------------- | -------------------------------- |
| **Java**       | Core application development     |
| **Java Swing** | Graphical User Interface         |
| **MySQL**      | Database management              |
| **JDBC**       | Java–MySQL database connectivity |
| **NetBeans**   | Development environment          |
| **JCalendar**  | Date selection for reservations  |

---

## 🏗️ Project Architecture

The project follows a modular structure that separates the user interface, application models, and database connectivity.

```text
Hospitality_Management_System/
│
├── gui/
│   ├── Dashboard.java
│   ├── GuestManagement.java
│   ├── HotelManagement.java
│   ├── LoginPage.java
│   ├── ReservationManagement.java
│   └── RoomManagement.java
│
├── model/
│   ├── Guest.java
│   ├── Hotel.java
│   ├── Reservation.java
│   └── Room.java
│
├── db/
│   └── DBConnection.java
│
├── dao/
│   ├── GuestDAO.java
│   ├── HotelDAO.java
│   ├── ReservationDAO.java
│   ├── RoomDAO.java
│   ├── userDAO.java
│   └── statsDAO.java
│
└── Main.java
```

### Folder Description

**`gui/`**
Contains all Swing-based user interface screens.

**`model/`**
Contains Java model classes representing hotels, rooms, guests, and reservations.

**`dao/`**
Contains Data Access Object classes responsible for communicating with the database and performing CRUD operations.

**`db/`**
Contains the MySQL database connection logic.

**`Main.java`**
Acts as the application entry point.

---

## 🔄 Application Workflow

```text
            ┌──────────────────┐
            │   Login Page     │
            └────────┬─────────┘
                     │
               Authentication
                     │
                     ▼
            ┌──────────────────┐
            │    Dashboard     │
            └────────┬─────────┘
                     │
        ┌────────────┼─────────────┐
        │            │             │
        ▼            ▼             ▼
   Hotel         Room          Guest
 Management    Management    Management
        │            │             │
        └────────────┼─────────────┘
                     │
                     ▼
            Reservation Management
                     │
                     ▼
              MySQL Database
```

---

## 🗄️ Database Configuration

The application uses MySQL for persistent data storage.

The current database connection configuration in the project is:

```java
jdbc:mysql://localhost:3306/hospitality_db
```

Default connection values currently present in the source code are:

```text
Database: hospitality_db
Username: root
Password: root
Host: localhost
Port: 3306
```

> ⚠️ For production use, change the default database credentials and avoid committing passwords directly into source code.

---

## 🚀 Getting Started

Follow these steps to run the project locally.

### 1. Clone the Repository

```bash
git clone https://github.com/Saubhagya-M/Hospitality_Management_System.git
```

Navigate into the project:

```bash
cd Hospitality_Management_System
```

### 2. Install Requirements

Make sure the following are installed:

* Java JDK
* MySQL Server
* MySQL Workbench (recommended)
* NetBeans IDE or another Java IDE

### 3. Create the Database

Open MySQL and create the database:

```sql
CREATE DATABASE hospitality_db;
```

Create the required tables according to the DAO/model structure used by the application.

### 4. Configure Database Connection

Open:

```text
db/DBConnection.java
```

Update the connection settings according to your local MySQL installation.

Example:

```java
private static final String URL =
    "jdbc:mysql://localhost:3306/hospitality_db?useSSL=false&serverTimezone=UTC";

private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

### 5. Add Required Libraries

Make sure the project has the required dependencies for:

* MySQL JDBC Driver
* JCalendar

If you are using NetBeans, add the required `.jar` files through:

```text
Project → Properties → Libraries → Add JAR/Folder
```

### 6. Open the Project

Open the project in **NetBeans IDE**.

Make sure the package structure is preserved:

```text
gui
model
dao
db
```

### 7. Run the Application

Run:

```text
Main.java
```

The application will open the login screen.

---

## 🖥️ Application Modules

### Login

Provides user authentication before entering the management dashboard.

### Dashboard

Displays high-level statistics for hotels, rooms, guests, and reservations.

### Hotel Management

Used for maintaining hotel records and their details.

### Room Management

Used for managing rooms, room types, prices, and status.

### Guest Management

Used for storing and maintaining guest information.

### Reservation Management

Used to create and remove reservations while maintaining check-in, check-out, and payment information.

---

## 🎯 Objectives

The primary objectives of this project are to:

* Digitize basic hotel management activities
* Reduce dependency on manual record keeping
* Provide centralized data management
* Demonstrate Java Swing GUI development
* Implement database connectivity using JDBC
* Apply object-oriented programming concepts
* Practice CRUD operations using MySQL
* Build a modular desktop management application

---

## 💡 Key Concepts Demonstrated

This project demonstrates practical implementation of:

* Object-Oriented Programming
* Java Swing GUI development
* Event-driven programming
* JDBC database connectivity
* CRUD operations
* Data Access Object (DAO) pattern
* Model-based application structure
* MySQL relational database management
* Form-based data entry and validation

---

## 🔮 Future Enhancements

Possible improvements for future versions include:

* Role-based user access
* Improved password security
* Room availability checking
* Automatic reservation conflict detection
* Billing and invoice generation
* Check-in and check-out workflow
* Advanced dashboard analytics
* Improved UI/UX design
* Database initialization scripts
* Environment-based database configuration
* Export reports to PDF or Excel
* Search and filtering across all management modules

---


---

## 📚 Use Case

This project can be used as:

* A Java desktop application project
* A DBMS project
* A Java Swing academic project
* A JDBC and MySQL learning project
* A portfolio project demonstrating CRUD and database integration

---

## 🤝 Contributing

Contributions are welcome.

To contribute:

```bash
git fork
```

Create a feature branch:

```bash
git checkout -b feature/your-feature
```

Commit your changes:

```bash
git commit -m "Add new feature"
```

Push the branch:

```bash
git push origin feature/your-feature
```

Then create a Pull Request.

---

## 👨‍💻 Author

**Saubhagya Munsi**

GitHub:
https://github.com/Saubhagya-M

---

## 📄 License

This project is available for educational and learning purposes.

---

⭐ If you find this project useful, consider giving the repository a star.
