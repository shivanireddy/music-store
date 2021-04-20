# Music-Store

## Description

A Spring application which stores and retrieves album and artist data.

### Setup

- Create local Postgres database called *musicstore*:  
  `postgres=# CREATE DATABASE musicstore;`
  
- Ensure your local Postgres username/database details are correct in resources/application.properties file.

- Start the application with `mvn spring-boot:run` - this will create the tables and insert test data.

- Test the endpoints in a browser, e.g.:

localhost:8080/albums

localhost:8080/albums/2

localhost:8080/artists

localhost:8080/artists/3