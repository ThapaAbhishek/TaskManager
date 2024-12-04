# Basic Task Manager

# Initializing the Project

From spring intializer use Java 17, Gradle-groovy and add dependency as follows:

* Spring Web
* Lombok
* Validation
* Spring Data JDBC

As JDBC has been added configure a DB. For DB, we have used docker MySQL image.

Docker command to run after downloading SQL image:
docker run --name task_db -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=<Password> -p 3306:3306 mysql:latest

This command creates a container call task_db with access to everyone and the SQL uses port no. 3306. 

Now, to configure DB in the project following parameters need to set:
* spring.datasource.url=jdbc:mysql://localhost:3306/mysql
* spring.datasource.password=Password
* spring.datasource.username=root

The following property is for connecting above mentioned DB.
**spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver**

Apart from that, gradle properties also need to have implementation _**mysql:mysql-connector-java:8.0.33**_ to include MySQL JDBC in the project.

# CRUD Operations
