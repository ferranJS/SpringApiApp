# Movie DB API with authentication (Spring + Maven)

## Description

Little program which exposes a REST movie API of few methods with authentication built with Spring Boot Framework (Java) and Maven for dependencies. The program takes data from The Movie Db API and also includes JSON manipulation library and RestTemplate implementations.

## Build and Run

In the main folder: `$ ./mvnw clean install` then `$ java -jar target/pelis-api-0.0.1-SNAPSHOT.jar` 
Response in `http://localhost:4200/..`  
(Example: `http://localhost:4200/films/335984/similar_films?pag=2&lang=fr-FR`)

User: User  
Password: password    
(to make it random everytime you run the program, delete de value from **spring.security.user.password** in application.properties)


## Versions

Java 15.0.2  
SpringBoot 2.4.2    
Dependencies in the `pom.xml`


##

Credits to [The Movie Db](www.themoviedb.org)
