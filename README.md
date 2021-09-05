# Banking_Application
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



Sequence of running the project:
Service registry -> details service -> profile service -> api gateway
Registration:
{
    //"account_no":"1222337IOB",
    "firstname":"yash2222",
    "lastname":"saxena222",
    "email":"saxenayash1503@gmail.com",
    "contact":7007223434
    “password”:abc(autogenerate)
}

Response:
{
    "account_no":"1222337IOB", //auto generate
    "firstname":"yash2222",
    "lastname":"saxena222",
    "email":"saxenayash1503@gmail.com",
    "contact":7007223434
}
{
    "account_no": "1222337IOB",
    "pin": "3303"		//auto generate     //not required

}

[to make the custom response : use modal mapper]

To add api gateway:
Create a new springboot application to the existing code(API gateway).
Just modify the pom.xml and properties file.

To check in postman:
Use the urls of APIgateway.

To enable h2 database:
Copy the dependency in pom.xml of user-details.
In properties file, add 3 properties
To make the data get reflected in the database:
#Add “modalmapper” dependency in the pom.xml (used when we want response in a specific format)
Test connection: it will come successful and try running the command

Add support to run: json and xml
Add dependency: Jackson

To enable the security:
Registration:
To encrypt the password: 
Use BCryptPasswordEncoder bCryptPasswordEncoder;
Websecurity

Login:



To understand the UI:
https://www.youtube.com/watch?v=YJ7ZgGnhN5k







C:\Program Files\Google\Chrome\Application>chrome.exe --disable-web-security --user-data-dir="c:/ChromeDevSession"

C:\Program Files\Google\Chrome\Application>

netstat -ano | findstr 9000

 taskkill /F /PID 28636
