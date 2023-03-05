# Student Management System

This project is a Student Management System built using Java, Spring Boot, and MySQL. It allows users to create, read, update, and delete student information.

## Frameworks and Language Used:

*Java

*Maven

*Spring Boot

*MySQL

*Swagger

## Data Flow:

### Controller-

The controller layer receives incoming HTTP requests and delegates to the appropriate service layer methods. It is responsible for handling requests and sending responses.

### Services-

The service layer contains the business logic of the application. It interacts with the repository layer to perform database operations.

### Repository-

The repository layer is responsible for interacting with the database. It contains methods for performing CRUD operations on the student entity.

## Database Design:

The database schema consists of a single table called student. It contains the following fields:

-id (primary key)

-first_name

-last_name

-age

-active

-admission_date

## Data Structure Used in the Project
 
 Java List

## Project Summary

This project allows users to perform basic CRUD operations on student data. The MySQL Workbench was used to design the database schema, and Swagger was used to generate API documentation. The project also includes custom queries using method names and query annotations for all MySQL keywords specified in the JPA documentation.
