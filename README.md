# Prueba

This is a simple application for a petty cash management

## Getting Started

These instructions will get you a copy of the project up and running on your local machine.

### Prerequisites

In order to compile the project you need:

```
- Apache Tomcat 7
- JDK 6
- Maven 4
```

## Installing

If you only want to install you don't need Maven.
```
IMPORTANT: Restore the database backup provided in the db directory of this repository before install the aplication

1. Copy Prueba-1.0.war located in target directory to webapps directory in your apache-tomcat home directory
2. Start the service.
3. Open your favorite web browser
4. Go to http://localhost:8080/Prueba-1.0/ (the port can change if you dont have the default configurations)

For custodio access use:
User: custodio
Password: custodiop
```
### Aditional Libraries

In order to develop the solution required, the next libraries are used: 

```
- hibernate 4.2.15.Final
- jersey-server 1.8
- jersey-json 1.8
- postgresql 9.4-1200-jdbc4
- hibernate-entitymanager 4.2.15.Final
- servlet-api 2.5
```

All of those libraries are described in pom.xml file and will installed by maven.

### Front-End Libraries

In the front-end the next JavaScript libraries are used: 

```
- angular 1.6.4
- angular-cookies 1.6.5
- bootstrap 3.3.7
- jquery 3.2.1
```

## Brief explanation

This is a SOA and MVC based solution:

Data Access -> Business Logic -> Services -> Models -> MVC

The Data Access is provided by the packages:

```
com.jose.prueba.entities
com.jose.prueba.persistenceServices
```

The Business Logic is provided by the packages:

```
com.jose.prueba.controllers
```

The Services are provided by the packages:

```
com.jose.prueba.services
```

In front-end a MVC library is used, Angular JS.

## Notes

*The authentication implemented is front-end level only, this should be improved with Session management in backend or a token based authentication.