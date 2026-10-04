# Bookstore REST API

CWEB 2136 Web Tooling – REST API assignment. A Spring Boot API for a bookstore with two models, **Book** and **Customer**, each with full CRUD.

## Run it

Requires Java 17+ and Maven (or open the folder in IntelliJ / VS Code and run `BookstoreApiApplication`).

```
mvn spring-boot:run
```

The API starts at http://localhost:8080 with a few sample books and customers. Data is kept in an in-memory H2 database, so it resets when the app restarts.

## Models

| Book | Customer |
|---|---|
| id | id |
| title | firstName |
| author | lastName |
| isbn | email |
| price | phone |
| quantityInStock | city |

## Endpoints

The same five operations exist for `/books` and `/customers`.

| Method | Path | Success | If ID doesn't exist |
|---|---|---|---|
| GET | `/books` | 200 OK | – |
| GET | `/books/{id}` | 200 OK | 404 Not Found |
| POST | `/books` | 201 Created | – |
| PUT | `/books/{id}` | 200 OK | 404 Not Found |
| DELETE | `/books/{id}` | 204 No Content | 404 Not Found |

## Try it

```
curl -i http://localhost:8080/books
curl -i http://localhost:8080/books/1
curl -i http://localhost:8080/books/999

curl -i -X POST http://localhost:8080/books -H "Content-Type: application/json" \
  -d '{"title":"Kindred","author":"Octavia Butler","isbn":"9780807083697","price":15.99,"quantityInStock":4}'

curl -i -X PUT http://localhost:8080/books/1 -H "Content-Type: application/json" \
  -d '{"title":"The Hobbit","author":"J.R.R. Tolkien","isbn":"9780547928227","price":12.50,"quantityInStock":20}'

curl -i -X DELETE http://localhost:8080/books/2

curl -i -X POST http://localhost:8080/customers -H "Content-Type: application/json" \
  -d '{"firstName":"Sam","lastName":"Rivera","email":"sam.rivera@example.com","phone":"763-555-0103","city":"Bloomington"}'
```
