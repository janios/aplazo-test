# Aplazo code challenge
This project was created as a Coding Exercise for Aplazo
<div id="top"></div>




<br />
<div align="center">
  <a>
    <img src="logo.png" alt="Logo" width="180" height="100">
  </a>
</div>


Simple Interest microservice: 

a microservice with spring-boot that calculate and generates the list of payments of the simple interest of a credit that must be paid in n terms and in weekly form:

<!-- GETTING STARTED -->
## Getting Started

Just clone this repository and then run 

```mvn clean install```

on the root folder

### Prerequisites

In order to compile this project you will need
*java 11
* Not compatible with Java 17
* maven 3.5 or higher  
* Docker

## Technologies
- Spring Boot
- JPA
- H2
- Maven
- Java 11
- Docker

## Execution

To execute the container with the app use the terminal and run the next command, changing the
<LOCAL-PORT> for the desired port.

```bash
docker run -p <LOCAL_PORT>:8080 aplazo-test:1.0.0
```

## REST API
    Creation of payments credit for Aplazo

### Request

`POST /api/v1/calculate`

JSON BODY:

```json
{
    "amount": 10.0,
    "term": 5,
    "rate": 0.01
}
```

### Response

```json
[
  {
    "paymentNumber": 1,
    "amount": 0.202,
    "paymentDate": "2022-05-12"
  },
  {
    "paymentNumber": 2,
    "amount": 0.202,
    "paymentDate": "2022-05-19"
  } ...
]
```

### Request

`GET /api/v1/payments`


### Response

```json
[
  {
    "idCredit": 1,
    "amount": 1.0,
    "term": 5,
    "rate": 0.01,
    "createTS": "2022-05-05T04:43:13.295+00:00",
    "payments": [
      {
        "paymentNumber": 1,
        "amount": 0.202,
        "paymentDate": "2022-05-12",
        "createTS": "2022-05-05T04:43:13.347+00:00"
      }...
  }    
]
```
## HealthCheck EndPoint

### Request

`GET /actuator/health`


### Response

```json
{
  "status": "UP",
  "components": {
    "aplazo": {
      "status": "UP",
      "details": {
        "app": "Aplazo Code Challenge"
      }
    },
    "db": {
      "status": "UP",
      "details": {
        "database": "H2",
        "validationQuery": "isValid()"
      }
    },
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 269490393088,
        "free": 251270905856,
        "threshold": 10485760,
        "exists": true
      }
    },
    "livenessState": {
      "status": "UP"
    },
    "ping": {
      "status": "UP"
    },
    "readinessState": {
      "status": "UP"
    }
  },
  "groups": [
    "liveness",
    "readiness"
  ]
}
```

<!-- CONTACT -->
## Contact

Cristian Escamilla - [Github](https://github.com/janios) - escamilla.cristian@gmail.com


<p align="right">(<a href="#top">back to top</a>)</p>