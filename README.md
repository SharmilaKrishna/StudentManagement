# StudentManagement Microservice

This microservice manages add student and provides RESTful APIs for adding students,  viewing students and relating them with fee structure.

## Project Structure

The project follows the CodeFirst design approach.

- **src/main/java**: Contains Java source code.
- **src/main/resources**: Contains application properties and Swagger documentation.
- **src/test**: Contains unit and integration tests.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 8 or higher installed.
- Maven 3.x installed.
- Git installed.

## Getting Started

To get started, follow these steps:

1. Clone the repository:


git clone https://github.com/SharmilaKrishna/StudentManagement

2.Navigate to the project directory:
cd studentManagement-microservice
3.Build the project:

mvn clean install
4. To run the application, execute the following command:

java -jar target/student-management-microservice.jar
5.Once the application is running, you can access the Swagger documentation by navigating to:

http://localhost:8080/swagger-ui.html

API Endpoints

Add Student
POST /students: Add a student.
View Receipts
GET /students: Get all students.
H2 Database Console
http://localhost:8080/h2-console

Use the following credentials:

JDBC URL: jdbc:h2:mem:studentdb
Username: sa
Password: password
