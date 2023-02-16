# Care4U Spring Boot

The Spring Boot backend that handles API requests from https://github.com/HeLinChooi/Care4U.
## Implementation Details

Model-View-Controller (MVC) pattern is used in this project.
| Requests | Descriptions |
| -------- | ------------ |
| @PostMapping("/signin") | It handle POST requests to the '/api/auth/signin' endpoint. The method takes in one parameter @RequestBody SignInDto signInDto which is passed in the request body and passed to the userService.signIn(signInDto) method, which is responsible for handling the signin logic. |
| @PostMapping("/signup") | It takes in one parameter @RequestBody SignUpDto signupDto which is passed in the request body and passed to the userService.signUp(signupDto) method, which is responsible for handling the signup logic. |
| @PostMapping("/patient")| It handles a POST request to the "/patient" endpoint, which is used to add a new patient. It takes a patient object as a request body, and calls the savePatient() method from the service layer. |
| @GetMapping("/patients")  | It handles a GET request to the "/patients" endpoint, which is used to retrieve all patients. It calls the getPatients() method from the service layer and returns the list of patients. |
| @GetMapping("/patient-by-id/{id}") | It handles a GET request to the "/patient-by-id/{id}" endpoint, which is used to retrieve a patient by id. It takes an id as a path variable, calls the getPatientById() method from the service layer, and returns the patient object. |
| @GetMapping("/patient/{email}") | It handles a GET request to the "/patient/{email}" endpoint, which is used to retrieve a patient by email. It takes an email as a path variable, calls the getPatientByEmail() method from the service layer, and returns the patient object. |
| @GetMapping("/patients/{name}") | It handles a GET request to the "/patients/{name}" endpoint, which is used to retrieve patients by name. It takes a name as a path variable, calls the getPatientByName() method from the service layer, and returns a list of patients. |
| @PutMapping("/patient") | It handles a PUT request to the "/patient" endpoint, which is used to update a patient. It takes a patient object as a request body, calls the updatePatient() method from the service layer, and returns the updated patient object. |
| @DeleteMapping("/delete-patient-by-id/{id}") | It handles a DELETE request to the "/delete-patient-by-id/{id}" endpoint, which is used to delete a patient by id. It takes an id as a path variable, calls the deletePatientById() method from the service layer, and returns a string message indicating that the delete was successful. |
| @DeleteMapping("/delete-patient-by-email/{email}") | It handles a DELETE request to the "/delete-patient-by-email/{email}" endpoint, which is used to delete a patient by email. It takes an email as a path variable, calls the deletePatientByEmail() method from the service layer, and returns a string message indicating that the delete was successful. |

The controller class also includes some custom exception handling (e.g. Not Found 404 when there is a no path matches the API request path), it throws a CustomException with a message.

## Setup Guide
### Version
JVM version: 17  
Spring Boot version: 3.0.1  
Gradle or Maven: Maven

### Step 1
Add `resources` folder in "src\main\", make sure it's having the same hierarchy file level with `java`.

![image](https://user-images.githubusercontent.com/55231366/210317354-41214a50-a08d-4b9b-bbf8-4040626639dd.png)

Add the `application.properties` within the `resources` folder.
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
[Build E-Commerce Backend with java and Springboot](https://www.youtube.com/playlist?list=PLzXSm2gSfuPJc2sSAmmud6TLpx0H7otyd)
[Setup Spring Boot in VSCode](https://code.visualstudio.com/docs/java/java-spring-boot)  
[Spring Boot, MySQL, JPA, Hibernate Restful CRUD API Example | Java Techie](https://www.youtube.com/watch?v=IucFDX3RO9U)   
