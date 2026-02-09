# spring-queryhub

Udemy-style course catalog backend built with Spring Boot.

## Features
- Course catalog with filtering, sorting and pagination
- Specification-based dynamic search
- N+1 problem resolved using projections and Spring Data Fluent API
- DTO-based API responses (entities are not exposed)

## Tech Stack
- Java 21
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Docker

## Search Example
POST /api/courses/search

```json
{
  "filter": {
    "keyword": "spring",
    "categoryName": "Backend",
    "minPrice": 100
  },
  "paging": {
    "pageNumber": 1,
    "pageSize": 10,
    "sortBy": "price",
    "sortDirection": "DESC"
  }
}
