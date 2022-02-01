# VOUCHER MANAGEMENT Assignment

There are following libraries or framework, which has been used in the project:
- Spring Boot
- Spring JPA
- Swagger 
- H2 Database
- JUnit4
- Dockerization application.


## Prerequisites
Make sure you have installed Java 8 and Maven 3 in your machine, it recommends using Java 8 to run the project
```$xslt
# To check java version, please run the command
java -version
# To check maven version, please run the command
mvn -version
```

## Folder Structure
```$xslt
├── README.md
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── justintu
│   │   │           ├── MainApplication.java
│   │   │           ├── api
│   │   │           │   ├── RestExceptionHandler.java
│   │   │           │   ├── exception
│   │   │           │   └── rest
│   │   │           │       └── impl
│   │   │           ├── constants
│   │   │           ├── domain
│   │   │           │   └── factory
│   │   │           ├── dto
│   │   │           ├── mapper
│   │   │           ├── repositories
│   │   │           ├── rest
│   │   │           ├── services
│   │   │           │   └── impl
│   │   │           └── utils
│   │   └── resources
│   │       ├── application.properties
│   └── test
│       └── java
│           └── com
│               └── justintu
│                   └── services
```

## Installing & Starting

###### Packaging  
```$xslt
mvn clean package

```

###### How to start application
> Start in local after packaging
```
java -jar target/voucher-management-api.jar
```

> Start by docker
```
docker build -t justin-tu:latest .
docker run -d -p 8888:8080 justin-tu:latest
```

> Start in local by mvn
```
mvn spring-boot:run
```

## Test your local:
Visit link: http://localhost:8888/api/voucher/getAllVouchers

View API documentation: http://localhost:8888/swagger-ui.html#/

## Limitation:
Due to limited time, the below aren't included in this version:
> Business
```
- No implementation for promotion, cart amount calculation
```
> Technical:
```
- Ignoring authorization
- Liquibase setup
- Cucumber testing 
```
