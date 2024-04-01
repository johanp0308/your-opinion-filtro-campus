
# Your Opinion API

This API solves the need to manage and rate the audiovisual content of users who have profiles.
An MVC framework and architecture is used for database control, in addition to having a security implementation with JWT.


## Installation

To use our Project you must use git to download the repository:

```bash
  git clone https://github.com/johanp0308/flores-el-machete-project-spring.git
```

To execute it, remember that you must have java on your computer to compile and interpret:

- To install java on windows [here](https://www.java.com/es/download/ie_manual.jsp)
- To install java on Linux maybe [here](https://www.java.com/es/download/help/linux_x64_install.html) remember that it may depend on the distro.


## Tech Stack

**Server:** Spring, Spring Boot

**Libreries:** Spring Security, Lombok, JWT, Hibernate, MysqlConector
## Documentation


For the API documentation, start the project and run the following in a browser
- Api Documentation: http://localhost:8080/doc/swagger-ui/index.html#/

## Config

To correctly configure the project you must create a database in your mysql service.

Recuerda el nombre de esa base de datos, porque es que usaremos en ela configuraciones de ellos:

Nos vamos a src/resources/application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/<database_name>
spring.datasource.username=<user>
spring.datasource.password=<password>
```

