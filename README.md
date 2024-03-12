## Projects

### JWT Security Implementation

- **Description**: Demonstrates the implementation of JSON Web Token (JWT) security in a Spring Boot application.
- **Key Features**:
    - JWT Generation and Validation
- **Technologies Used**: Spring Boot, JJWT, Spring Security
### Methods
- Ignore the `UsernamePasswordAuthenticationFilter` and define my own endpoint for login, and call the authentication manager in the controller to perform authentication.
- **Files**:
  - src/main/java/com/example/AntraHW/configs/SecurityConfig.java 
  - src/main/java/com/example/AntraHW/controllers/AuthenticateController.java
  - src/main/java/com/example/AntraHW/entities/AuthRequest.java 
  - src/main/java/com/example/AntraHW/filters/JwtFilter.java 
  - src/main/java/com/example/AntraHW/services/AuthenticateService.java 
  - src/main/java/com/example/AntraHW/services/AuthenticateServiceImpl.java 
  - src/main/java/com/example/AntraHW/services/JwtService.java 
  - src/main/java/com/example/AntraHW/services/JwtServiceImpl.java 
  - src/main/resources/application.properties
