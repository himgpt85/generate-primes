# Generate primes
Generate primes is a spring boot based project with RESTful API service.
This project used Java version 8

## How to build and run the project
###On Windows
####gradlew build
####java -jar build/libs/generate-primes.jar
###On Windows
####./gradlew build
####java -jar build/libs/generate-primes.jar

###Execute the service
####Visit http://localhost:8080/primes/{initial}
####Visiting http://localhost:8080/primes/10 should return {"initial":10,"primes":[2,3,5,7]}