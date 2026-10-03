# REST API Simple

## Goal

Create a simple Java REST API using JAX-RS and Jersey.

Students should practice:

```text
REST resources
GET
POST
PUT
DELETE
JSON
path parameters
request bodies
ArrayList
validation
Tomcat deployment
```

No Spring is used.

The project structure is already created.

The repository is already implemented. The main student task is to complete and understand the controller/resource layer.

## API

Simple product API.

Expected endpoints:

```text
GET    /api/products
GET    /api/products/{id}
POST   /api/products
PUT    /api/products/{id}
DELETE /api/products/{id}
```

## Student Tasks

The repository is already implemented:

```text
src/main/java/com/example/rest/repository/ProductRepository.java
```

Complete TODO methods in the controller/resource layer:

```text
src/main/java/com/example/rest/resource/ProductResource.java
```

Methods to complete:

```java
public List<Product> findAll()
public Response findById(int id)
public Response create(Product product)
public Response update(int id, Product product)
public Response deleteById(int id)
```

Students should practice:

```text
reading path parameters
reading JSON request body
returning HTTP 200
returning HTTP 201
returning HTTP 204
returning HTTP 400
returning HTTP 404
returning JSON response bodies
```

## Run

Build:

```bash
mvn clean package
```

Deploy this file to Tomcat 10+:

```text
target/rest-api-simple.war
```

Open:

```text
http://localhost:8080/rest-api-simple/api/products
```

## Test With Postman

Base URL:

```text
http://localhost:8080/rest-api-simple/api/products
```

For requests with JSON body, add this header:

```text
Content-Type: application/json
```

### 1. Get All Products

Method:

```text
GET
```

URL:

```text
http://localhost:8080/rest-api-simple/api/products
```

Expected:

```text
HTTP 200
JSON array
```

### 2. Create Product

Method:

```text
POST
```

URL:

```text
http://localhost:8080/rest-api-simple/api/products
```

Body -> raw -> JSON:

```json
{
  "name": "Java Book",
  "price": 19.99
}
```

Expected:

```text
HTTP 201
Created product JSON with generated id
```

### 3. Get Product By ID

Method:

```text
GET
```

URL:

```text
http://localhost:8080/rest-api-simple/api/products/1
```

Expected:

```text
HTTP 200 if product exists
HTTP 404 if product does not exist
```

### 4. Update Product

Method:

```text
PUT
```

URL:

```text
http://localhost:8080/rest-api-simple/api/products/1
```

Body -> raw -> JSON:

```json
{
  "name": "Advanced Java Book",
  "price": 29.99
}
```

Expected:

```text
HTTP 200 if product exists
HTTP 400 if request body is invalid
HTTP 404 if product does not exist
```

### 5. Delete Product

Method:

```text
DELETE
```

URL:

```text
http://localhost:8080/rest-api-simple/api/products/1
```

Expected:

```text
HTTP 204 if product was deleted
HTTP 404 if product does not exist
```

## Test With Curl

```bash
curl -i "http://localhost:8080/rest-api-simple/api/products"

curl -i -X POST "http://localhost:8080/rest-api-simple/api/products" \
  -H "Content-Type: application/json" \
  -d '{"name":"Java Book","price":19.99}'

curl -i "http://localhost:8080/rest-api-simple/api/products/1"

curl -i -X PUT "http://localhost:8080/rest-api-simple/api/products/1" \
  -H "Content-Type: application/json" \
  -d '{"name":"Advanced Java Book","price":29.99}'

curl -i -X DELETE "http://localhost:8080/rest-api-simple/api/products/1"
```
