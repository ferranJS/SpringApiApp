# Movie DB API with Spring + Maven

## Description

Little program which exposes a REST movie API of few methods built with Spring Boot Framework (Java) and Maven for dependencies. The program takes data from The Movie Db API and also includes JSON manipulation library and RestTemplate implementations.

## Build and Run

In the main folder: `$ ./mvnw clean install` then `$ java -jar target/pelis-api-0.0.1-SNAPSHOT.jar` 
Response in `http://localhost:4202/..`  
(Example: `http://localhost:4202/film/335984/similar_films`)


## Versions

SpringBoot 2.4.2    
Dependencies in the `pom.xml`


##

Credits to [The Movie Db](www.themoviedb.org)
