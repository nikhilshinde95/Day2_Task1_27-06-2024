# TestManagement Project

## Overview

TestManagement is a Spring Boot project that manages multiple-choice questions (MCQs). 
</br>
It includes features for creating, reading, getting specific, updating, and deleting MCQ questions. 
</br>
The project uses PostgreSQL as the database and follows standard Java and SQL naming conventions.

## GitHub Clone Link : 
Getting Started Clone the repository to your local machine: git clone : 

## Technologies Used

- Java 21
- Spring Boot 3
- PostgreSQL
- JPA (Hibernate)
- SLF4J for logging
- JUnit 5 for testing
- Mockito for mocking

## Project Structure

- *Controller*: Handles HTTP requests and responses.
- *Service*: Contains business logic.
- *Repository*: Manages data access using JPA.
- *Entity*: Represents the MCQ question table in the database.
- *Logging*: Implemented using SLF4J.
- *Exception Handling*: Custom exceptions and global exception handlers.
- *Testing*: Unit tests using JUnit 5 and Mockito.

## Setup Instructions

### Prerequisites

- Java 21
- Gradle
- PostgreSQL 

### Database Setup

1. Install PostgreSQL.
2. Create a database named TestManagementDB.
3. Update the application.properties file with your PostgreSQL credentials.
   
### Swagger and Postman ScreenShots : 

![PostMan_API_Img1](https://github.com/nikhilshinde95/Day2_Task1_27-06-2024/assets/171656624/bec55d21-b3be-40d8-905f-28fdb8f52689)
![PostMan_API_IMG2](https://github.com/nikhilshinde95/Day2_Task1_27-06-2024/assets/171656624/0ce89418-0ff7-4b1a-bf9c-162bccbb09d9)
![Swagger_Img1](https://github.com/nikhilshinde95/Day2_Task1_27-06-2024/assets/171656624/022ffa44-667a-48ba-bbc5-602e6d842cca)
![Swagger_Img2](https://github.com/nikhilshinde95/Day2_Task1_27-06-2024/assets/171656624/81f01280-5133-4108-a348-1ac462b483b4)
![Swagger_Img3](https://github.com/nikhilshinde95/Day2_Task1_27-06-2024/assets/171656624/3c6db1cb-faf0-4c82-8915-dbb1ae1d2bb8)
![Swagger_Img4](https://github.com/nikhilshinde95/Day2_Task1_27-06-2024/assets/171656624/22185fb1-5543-4449-ae3b-7cea851364f8)
