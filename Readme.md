# Enterprise Journal API (Spring Boot & MongoDB)

A lightweight, high-performance RESTful microservice built using the Java Spring Boot framework and MongoDB. This project serves as an enterprise-ready blueprint demonstrating modern backend development practices, including the Model-View-Controller (MVC) architectural pattern, automated health monitoring, Dependency Injection, and cloud-native containerization readiness.

---

## 🚀 Key Features

*   **RESTful API Design:** Implements clean, standardized HTTP methods (`GET`, `POST`, `PUT`, `DELETE`) for resource management.
*   **Decoupled Architecture:** Built using an MVC/Service-Repository pattern leveraging Spring's **Dependency Injection** (`@Autowired`) for clean separation of concerns.
*   **Dynamic Data Persistence:** Integrated with **MongoDB** via Spring Data repositories to handle unstructured JSON data, featuring custom object-state merging and unique BSON `ObjectId` lookups.
*   **DevOps & Liveness Monitoring:** Includes a dedicated, low-overhead `/health` check controller endpoint designed to interface seamlessly with container orchestrators for automated uptime tracking.

---

## 🛠️ Tech Stack

*   **Language:** Java 17+
*   **Framework:** Spring Boot (Spring Web, Spring Data MongoDB)
*   **Database:** MongoDB (NoSQL)

---

## 🛣️ API Architecture & Endpoints

### 1. Actuator / System Health
Monitors application availability. Ideal for Kubernetes Liveness and Readiness probes.

*   **URL:** `/health`
*   **Method:** `GET`
*   **Response:** `200 OK` → `"ok"`

### 2. Journal Resource Management
Handles core business data under versioned routing controls.

*   **URL:** `/journalv2`

| Method | Endpoint | Description | Request Body |
| :--- | :--- | :--- | :--- |
| **GET** | `/journalv2` | Retrieve all journal entries | None |
| **POST** | `/journalv2` | Create a new journal entry (auto-stamps system timestamp) | `JSON (Title, Content)` |
| **GET** | `/journalv2/id/{myId}` | Fetch a specific journal entry by its MongoDB ObjectId | None |
| **PUT** | `/journalv2/id/{myId}` | Perform a conditional, partial delta update on an entry | `JSON (Fields to update)` |
| **DELETE** | `/journalv2/id/{myId}` | Securely purge a journal entry by ID | None |

---

## 💻 Local Setup & Installation

### Prerequisites
*   JDK 17 or higher
*   Maven or Gradle
*   Local MongoDB instance running on port `27017` (or MongoDB Atlas connection string)

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/abhishektarun09/javajournalApp.git
   cd journalApp

2. Configure your database settings in `src/main/resources/application.properties`:


3. Compile and launch the application using Maven:
   ```
     mvn clean install
     mvn spring-boot:run

4. Access the API at `localhost:8080/docs`.