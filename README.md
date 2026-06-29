# BusApp

A simple web-based Bus Reservation application developed using JSP, Servlets, JDBC, and Oracle Database.
The application allows users to add and view bus schedules and automatically generate a unique schedule ID.

---

# Technologies Used

* Java
* JSP
* Servlets
* JDBC
* Oracle Database
* HTML
* Apache Tomcat
* Eclipse IDE

---

# Features

* Add bus schedule
* View bus schedule
* Generate unique schedule ID
* Store schedule details in Oracle Database
* Simple and user-friendly interface

---

# Project Structure

```text id="4w0bkm"
BusApp/
│
├── src/main/java/com/wipro/bus
│   ├── bean
│   ├── dao
│   ├── service
│   ├── servlets
│   └── util
│
├── src/main/webapp
│   ├── addSchedule.jsp
│   ├── displaySchedule.jsp
│   ├── menu.html
│   ├── success.jsp
│   ├── viewSchedule.jsp
│   └── errorInserting.html
```

---

# Database

## Table: SCHEDULE_TBL

| Column Name | Type         |
| ----------- | ------------ |
| SCHEDULEID  | VARCHAR2(8)  |
| SOURCE      | VARCHAR2(30) |
| DESTINATION | VARCHAR2(30) |
| STARTTIME   | VARCHAR2(5)  |
| ARRIVALTIME | VARCHAR2(5)  |

---

# Functionality

* Create schedule details
* Display available schedules
* Generate unique schedule IDs automatically

Example Schedule ID:

```text id="0f2v9j"
SCH1001
```

---

# How to Run

1. Import project into Eclipse
2. Configure Apache Tomcat Server
3. Configure Oracle Database connection
4. Create table in Oracle Database
5. Run the application
6. Open browser:

```text id="n7e1qf"
http://localhost:8080/BusApp
```

---

# Author

Tharika
