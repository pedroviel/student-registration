# Student Registration

A Rest API developed as a simple CRUD application, allowing you to create students, assigning their course, 
and each one has an ID, generated when created.

## Technologies

- Java
- Spring / Spring Boot
- H2 Database
- Lombok
- Maven

## How to execute

This project uses an in-memory H2 Database, which means no external database is needed.

1. Clone this repository
2. Open the project in your IDE
3. Reload the Maven dependencies
4. Run `StudentRegistrationApplication.java`

Once started, the API will be available at http://localhost:8080.

## Endpoints

You can test all the endpoints with tools like Postman.

* `POST /students` Create a new student.
* `GET /students?course={course}` List students by course.
* `GET /students/{uuid}` Find a student by ID.
* `PUT /students?name={name}&course={course}` Update student details.
* `DELETE /students?id={uuid}`  Delete a student by ID.

## Payload example for POST

````
{"name": "Pedro", "course": "Engenharia"}
````