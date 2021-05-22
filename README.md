# Generate primes
Generate primes is a spring boot based project with RESTful API service. When this API is called, it will generate prime numbers from 2 to ***initial*** sent via request URI.
This project uses Java version 8

## How to build and run the project
### On Windows
* gradlew build
* java -jar build/libs/generate-primes.jar
### On Linux
* ./gradlew build
* java -jar build/libs/generate-primes.jar
#### This will start the application on http://localhost:8080/

### Execute the service/How to use the API
This project uses three different algorithms for generating prime numbers as follows
1. Basic algorithm
    * Loops from 2 to ***initial*** and checks each number divisibility from 2 to ***initial***-1
2. Square root algorithm
    * Loops from 2 to ***initial*** and check each numbers divisibility from 2 to square root of ***initial*** at least one of the factors must be less than equal to the square root of the ***initial***
3. Sieve of Eratosthenes(default)
    * It finds all the prime numbers by iteratively marking each number having factors(composite number) starting with 2 and leaving all the prime numbers unmarked

#### Example using browser
Visiting http://localhost:8080/primes/10 should return. This will use the default algorithm 3(sieve of eratosthenes)
```
{"initial":10,"primes":[2,3,5,7]}
```
* Use API with basic algorithm 
  1. Visit http://localhost:8080/primes/10?algorithm=1
    ```
    {"initial":10,"primes":[2,3,5,7]}
    ```
* Use API with square root algorithm
    1. Visit http://localhost:8080/primes/10?algorithm=2
    ```
    {"initial":10,"primes":[2,3,5,7]}
    ```  


#### Example using curl command
* Default algorithm
    1. curl -v http://localhost:8080/primes/10
    ```
    curl -v http://localhost:8080/primes/10
    *   Trying ::1...
    * TCP_NODELAY set
    * Connected to localhost (::1) port 8080 (#0)
    > GET /primes/10 HTTP/1.1
    > Host: localhost:8080
    > User-Agent: curl/7.55.1
    > Accept: */*
    >
    < HTTP/1.1 200
    < Content-Type: application/json
    < Transfer-Encoding: chunked
    <
    {"initial":10,"primes":[2,3,5,7]}* Connection #0 to host localhost left intact
    ```
* Basic algorithm
    1. curl -v http://localhost:8080/primes/10?algorithm=1
    ```*   Trying ::1...
    * TCP_NODELAY set
    * Connected to localhost (::1) port 8080 (#0)
    > GET /primes/10?algorithm=1 HTTP/1.1
    > Host: localhost:8080
    > User-Agent: curl/7.55.1
    > Accept: */*
    >
    < HTTP/1.1 200
    < Content-Type: application/json
    < Transfer-Encoding: chunked
    <
    {"initial":10,"primes":[2,3,5,7]}* Connection #0 to host localhost left intact
    ```
* Square root algorithm
    1. curl -v http://localhost:8080/primes/10?algorithm=2
    ```*   Trying ::1...
    * TCP_NODELAY set
    * Connected to localhost (::1) port 8080 (#0)
    > GET /primes/10?algorithm=1 HTTP/1.1
    > Host: localhost:8080
    > User-Agent: curl/7.55.1
    > Accept: */*
    >
    < HTTP/1.1 200
    < Content-Type: application/json
    < Transfer-Encoding: chunked
    <
    {"initial":10,"primes":[2,3,5,7]}* Connection #0 to host localhost left intact
    ```  
