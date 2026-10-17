# spring-boot-blog-azure

[![AzureSpringCloud](https://github.com/hendisantika/spring-boot-blog-azure/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-blog-azure/actions/workflows/maven.yml)

A simple blog REST API built with Spring Boot and Spring Data JDBC on PostgreSQL, deployable to Azure Spring Apps.

## Tech Stack

- Java 25
- Spring Boot 4.1 (Web, Data JDBC, Actuator, Docker Compose support)
- Jackson 3
- PostgreSQL 17
- Lombok
- Testcontainers 2 + JUnit 5
- Maven (wrapper included)

## Prerequisites

- JDK 25
- Docker (used by Docker Compose support for local dev and by Testcontainers for tests)

## Running Locally

```shell
./mvnw spring-boot:run
```

The `dev` profile is active by default. Spring Boot's Docker Compose support starts PostgreSQL from `compose.yaml`, the schema is created from `schema.sql`, and a sample author/post is seeded on startup.

Then open http://localhost:8080/api/posts.

## API Endpoints

| Method | Path                       | Description                      |
|--------|----------------------------|----------------------------------|
| GET    | `/api/posts`               | List all posts                   |
| GET    | `/api/posts/{id}`          | Get a single post                |
| GET    | `/api/posts/{id}/details`  | Get a post with its author details |
| GET    | `/actuator`                | Actuator endpoints (all exposed) |

## Running Tests

```shell
./mvnw clean verify
```

Tests use Testcontainers (`jdbc:tc:postgresql:17-alpine3.21`), so Docker must be running.

## Profiles

| Profile | Database                                                                 |
|---------|--------------------------------------------------------------------------|
| `dev`   | `localhost:5432/blog` via Docker Compose                                 |
| `test`  | Throwaway Testcontainers PostgreSQL                                      |
| `prod`  | `PROD_DB_HOST`, `PROD_DB_PORT`, `PROD_DB_NAME`, `PROD_DB_USERNAME`, `PROD_DB_PASSWORD` env vars |

## CI/CD

The GitHub Actions workflow (`.github/workflows/maven.yml`) runs on every push and on pull requests to `main`:

1. **build and test** – sets up Temurin JDK 25, runs `./mvnw -B clean verify`, and uploads the JAR as an artifact.
2. **deploy to production** – on pushes to `main` only, deploys the JAR to the `spring-blog` app in Azure Spring Apps.
   Deployment needs an `AZURE_CREDENTIALS` repository secret (service principal JSON for `azure/login`); without it, the job skips deployment and still passes.
