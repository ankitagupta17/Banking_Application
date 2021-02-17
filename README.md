# Bankig_Application
Microservices that interact with each other


1. Service Registry
It is acting as a server and tells which service is currently up. Implemented Eureka server. 

Eureka server is used to prevent the usage of URLs that can be dynamic in nature. 
Changes in the application.yml, @EnableEurekaServer added.

Default port of eureka server is 8761 http://localhost:8761/



2. AccountDetails
It is acting as a client. We can check it in Eureka server  http://localhost:8761/
It acts as a Service Discovery Client Service(Discovery Client dependency added)
@EnableEurekaClient, @LoadBalanced is added.
#Logging is used
@lombok is used to reduce the lines of getters and setters and constructors



3. AccountProfile
It is acting as a client. We can check it in Eureka server  http://localhost:8761/
It acts as a Service Discovery Client Service(Discovery Client dependency added)
@EnableEurekaClient, @LoadBalanced is added.
#Logging is used
@lombok is used to reduce the lines of getters and setters and constructors
