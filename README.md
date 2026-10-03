# Web Tasks

This project contains separate Java web practice modules.

The modules will grow from simple to harder topics:

```text
Servlets
JSP
REST API
HTTP methods
request parameters
JSON
validation
web.xml
Tomcat deployment
```

No Spring is used.

## Project Structure

```text
web_tasks/
├── README.md
├── pom.xml
├── html-servlet-pages/
│   ├── README.md
│   ├── pom.xml
│   └── src/
├── servlet-simple-web/
│   ├── README.md
│   ├── pom.xml
│   └── src/
└── rest-api-simple/
    ├── README.md
    ├── pom.xml
    └── src/
```

## Current Modules

```text
html-servlet-pages
servlet-simple-web
rest-api-simple
```

## HTML Servlet Pages

Practice static HTML files for servlet request and response pages:

```text
GET page
POST form
PUT request with fetch
DELETE request with fetch
```

## Servlet Simple Web

Practice a basic Java web app using:

```text
Servlets
HTML forms
request parameters
Maven
Tomcat
```

## REST API Simple

Practice a basic REST API using:

```text
JAX-RS
Jersey
JSON
Maven
Tomcat
```

## IntelliJ IDEA Setup

Open this folder in IntelliJ IDEA:

```text
/Users/tigranho/Projects/test/web_tasks
```

Import it as a Maven project.

## Build

From the root project:

```bash
mvn clean install
```

Build only the servlet module:

```bash
cd /Users/tigranho/Projects/test/web_tasks/servlet-simple-web
mvn clean package
```

Build only the HTML module:

```bash
cd /Users/tigranho/Projects/test/web_tasks/html-servlet-pages
mvn clean package
```

Build only the REST module:

```bash
cd /Users/tigranho/Projects/test/web_tasks/rest-api-simple
mvn clean package
```

## Run

Both modules build `.war` files.

Use Tomcat 10+ because the code uses `jakarta.*` packages.

Deploy:

```text
html-servlet-pages/target/html-servlet-pages.war
servlet-simple-web/target/servlet-simple-web.war
rest-api-simple/target/rest-api-simple.war
```
