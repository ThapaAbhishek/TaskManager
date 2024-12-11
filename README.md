# Basic Task Manager

# Initializing the Project

From spring intializer use Java 17, Gradle-groovy and add dependency as follows:

* Spring Web
* Lombok
* Validation
* Spring Data JDBC

As JDBC has been added, DB must be configured for the application to run. For DB, we have used docker MySQL image.

Docker command to run after downloading SQL image:
docker run --name task_db -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=<Password> -p 3306:3306 mysql:latest

This command creates a container call task_db with access to everyone and the SQL uses port no. 3306. 

Now, to configure DB in the project following parameters need to set:
* spring.datasource.url=jdbc:mysql://localhost:3306/taskManager
* spring.datasource.password=Password
* spring.datasource.username=root

The following property is for connecting above mentioned DB.
**spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver**

Apart from that, gradle properties also need to have implementation _**mysql:mysql-connector-java:8.0.33**_ to include MySQL JDBC in the project.

# CRUD Operations

### Creating Table using schema.sql

To  create table using schema.sql, place the schema.sql having create query in src/main/resources and add the following properties to application.properties:

**spring.sql.init.mode=always**

### Creating Table using Bean

To create table using Bean, we need to use JDBC template. A component class is created which uses jdbcTemplate to execute create table query after initialization of bean. ClassName: com/TaskManager/TaskManager/configuration/TableInitializer.java

### Added  MVC Framework

Added a REST API controller that uses Data Access Object class where actual SQL query is present. The controller maps the respective SQL queries to respective REST APIs.

# Validation Mechanism

To validate input fields we can use spring validation. Now, the model class needs to have several validation logic like @NotBlank,@size etc. To enforce validation @Valid must be passed.
Now the validation might throw error. To know which error is encountered a new class is created which advice controller to display respective help message.

# Custom Validation Annotator

To create custom validator first create and interface like ValidateDateInString. It will need a class where logic should be implemented. The class with logic should implement ConstraintValidator class and override isValid method. The annotation ValidateDateInString can then be used for data validation.
