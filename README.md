# Tushughuli Backend
## Table of contents
[Description](#description)


[Local Set-up](#setting-up-locally)

[API reference](#api-reference)

[Licence](#licence)

## Description
Backend of the Todolist project

## Setting up Locally

### Requirements
To get up and running on localhost, make sure you have the following installed;
- JDK,
- PostgreSQL,
- IDE (IntelliJ is highly recomended),
- Postman

### Postgres DB set-up
Download Postgres from [here](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)

Take note of the Postgres localhost port (default 5432), and login credentials to the root user `postgres` (set at installation). You can create a super-user as well and note their credentials.

After installation, create a database named `todolist` using either psql or pgadmin.

### Clone project

Clone the project and checkout into a stable branch, ideally `dev` at the moment.

> **Note** : Do not push or commit any changes to any of the branches, create a new oneand create a PR or suggest through issues!

### Running the project
Modify the `src/main/resources/application.properties` file to have the credentials of the postgres user where the database was created.

```bash
spring.datasource.username=postgres
spring.datasource.password=ian
```
Make sure the port and DB name configured in postgres are matching in the properties file as well as shown;
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/todolist
```

Run the project's `Application.java` file.
The Tomcat Server should be running on port 8080.
> Make sure no process is running on the port.

### Testing on Postman

Use the ToDoList Postman collection to test the API. Make sure the ports on Postman requests match with where the app is being served.

**Contact maintainers for help with issues encountered** 

# API reference

API reference at http://localhost:8080/swagger-ui.html#/ when the server is running on port 8080


# Deployment
Coming Soon!
# Licence
Licenced using the MIT licence.
