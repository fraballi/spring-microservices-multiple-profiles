# SPRINGBOOT MICROSERVICES

## A demo project on SpringBoot microservices using multiple profiles with Docker

### _Profiles_: **dev, prod**

---

## Configuration files

- **application.yml** (base)
- **application-dev.yml**  (dev profile config)
- **application-prod.yml** (prod profile config)

## **Docker Resources**

### _Dockerfile_

_e.g_  _docker build --build-arg PORT_ARG=18080
                        -t spring_micsrv:1.0 .
                        && docker run
                        -p 18080:18080
                        --name spring_micsrv
                        spring_micsrv:1.0_

---

### _docker-compose.yml_

```yaml
 environment_:
    - SPRING_PROFILES_ACTIVE=prod  # (_e.g 'dev'_)
    - SERVER_PORT=18080  # (*set active port from host*)
```

### _Command line_

#### **Can switch profiles from command line**

```sh
    # Available ways to set parameters: 
    1) ... -e SPRING_PROFILES_ACTIVE=prod (ENV variable)
    2) ... -Dspring.profiles.active=prod (JVM property)
    3) ... --spring.profiles.active=prod (JVM argument)
    # Example:
    #    docker run -it --name spring_micsrv -p 18080:18080 -e SPRING_PROFILES_ACTIVE=prod spring_micsrv:1.0
    # Or:
    #    docker run -it --name spring_micsrv -p 18080:18080 --entrypoint="java -Dspring.profiles.active=prod -Djava.security.egd=file:/dev/./urandom -jar app.jar" spring_micsrv:1.0
    # Or:
    #    docker run -it --name spring_micsrv -p 18080:18080 --entrypoint="java --spring.profiles.active=prod --server.port=18080 -Djava.security.egd=file:/dev/./urandom -jar app.jar" spring_micsrv:1.0
```

#### Dependencies

| **Name**                            | **Version**                |
| ----------------------------------- | -------------------------- |
| Docker _Image:Tag_                  | _openjdk:**8-jre-alpine**_ |
| spring-boot-starter-web             | 2.2.6.RELEASE              |
| spring-boot-starter-actuator        | 2.2.6.RELEASE              |
| spring-boot-configuration-processor | 2.2.6.RELEASE              |
| kong-unirest-java                   | 3.7.00                     |
| lombok                              | 1.18.12                    |

#### Endpoints

| **Profile**     | **URL**                                           |
| --------------- | ------------------------------------------------- |
| PROD            | http://localhost:18080/message                    |
| DEV             | http://localhost:18081/message                    |
| ACTUATOR/HEALTH | **(prod)** http://localhost:18080/actuator/health |
|                 | **(dev)** http://localhost:18081/actuator/health  |