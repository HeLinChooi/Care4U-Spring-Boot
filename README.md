# Care4U

JVM version: 17  
Spring Boot version: 3.0.1  
Gradle or Maven: Maven

## Setup
[Setup Spring Boot in VSCode](https://code.visualstudio.com/docs/java/java-spring-boot)  
[Spring Boot, MySQL, JPA, Hibernate Restful CRUD API Example | Java Techie](https://www.youtube.com/watch?v=IucFDX3RO9U)  
These videos are watched to setup project as in first commit.  
### Step 1
Add `resource` folder in "src\main\", make sure it's having the same hierarchy file level with `java`
![image](https://user-images.githubusercontent.com/55231366/210317354-41214a50-a08d-4b9b-bbf8-4040626639dd.png)
Add the `application.properties` within the `resource` folder.
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/care4u
spring.datasource.username = <your database username, can be root>
spring.datasource.password = <password>
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
```

### Step 2
In MySQL Workbench, create a database called `care4u` and use it as in the video above.
```
create database care4u;
use care4u;
```

## Reference
[Should I learn Gradle or Maven for Spring](https://www.reddit.com/r/java/comments/pj5iu0/should_i_learn_gradle_or_maven_for_spring/)  
[Spring Boot Security Autoconfiguration](https://www.baeldung.com/spring-boot-security-autoconfiguration)  
[Java Password Hashing](https://www.baeldung.com/java-password-hashing)

## API
### Sign Up
http://localhost:8080/api/auth/signup

HTTP Method: `POST`  
JSON Payload
```
{
    "name": "name",
    "email": "email@domain.com",
    "password": "password"
}
```
### Sign In
http://localhost:8080/api/auth/signin

HTTP Method: `POST`  
JSON Payload
```
{
    "email": "email@domain.com",
    "password": "password"
}
```

# Official Getting Started Guide

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.1/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

