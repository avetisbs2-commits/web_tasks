# Servlet Simple Web

## Goal

Create a simple Java web application using Servlets.

Students should practice:

```text
Servlets
doGet
doPost
HTML forms
request parameters
response writing
ArrayList
validation
Tomcat deployment
```

No Spring is used.

The project structure and UI are already created. The main business logic is intentionally left incomplete.

## App

Simple task manager web app.

The user should be able to:

```text
open task list page
GET all tasks
POST a new task
PUT a task as done
DELETE a task
```

## Student Tasks

The repository is already implemented.

The main student task is to complete HTTP method handling in:

```text
src/main/java/com/example/servlet/web/TaskServlet.java
```

Use the repository from the servlet. Do not move the main exercise back into the repository.

## Task 1: Implement GET

Method:

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response)
```

TODO:

```text
1. Set response content type to text/html.
2. Get all tasks from repository.
3. Create PrintWriter.
4. Build HTML page.
5. Show task form.
6. Show all tasks.
7. Add buttons/forms for done and delete actions.
```

Test in browser:

```text
http://localhost:8080/servlet-simple-web/tasks
```

## Task 2: Implement POST

Method:

```java
protected void doPost(HttpServletRequest request, HttpServletResponse response)
```

TODO:

```text
1. Read title request parameter.
2. Validate title is not empty.
3. Call repository.add(title).
4. Redirect back to /tasks.
```

Test from browser form:

```text
http://localhost:8080/servlet-simple-web/tasks
```

Test with curl:

```bash
curl -i -X POST "http://localhost:8080/servlet-simple-web/tasks" \
  -d "title=Learn Servlets"
```

## Task 3: Implement PUT

Method:

```java
protected void doPut(HttpServletRequest request, HttpServletResponse response)
```

TODO:

```text
1. Read id request parameter.
2. Convert id from String to int.
3. Call repository.markDone(id).
4. Return 200 if updated.
5. Return 404 if task does not exist.
```

Test with curl:

```bash
curl -i -X PUT "http://localhost:8080/servlet-simple-web/tasks?id=1"
```

## Task 4: Implement DELETE

Method:

```java
protected void doDelete(HttpServletRequest request, HttpServletResponse response)
```

TODO:

```text
1. Read id request parameter.
2. Convert id from String to int.
3. Call repository.deleteById(id).
4. Return 204 if deleted.
5. Return 404 if task does not exist.
```

Test with curl:

```bash
curl -i -X DELETE "http://localhost:8080/servlet-simple-web/tasks?id=1"
```

HTML forms support `GET` and `POST` directly. To test `PUT` and `DELETE`, use curl, Postman, IntelliJ HTTP Client, or JavaScript fetch.

## Install Tomcat

This project uses `jakarta.*` packages, so use Tomcat 10 or newer.


### Option 2: Manual Download

1. Open:

```text
https://tomcat.apache.org/download-10.cgi
```

2. Download the `.zip` or `.tar.gz`.
3. Extract it to a folder, for example:

```text
/Users/tigranho/Tools/apache-tomcat-10
```

4. Make scripts executable:

```bash
chmod +x /Users/tigranho/Tools/apache-tomcat-10/bin/*.sh
```

## Build

Build:

```bash
mvn clean package
```

The WAR file will be created here:

```text
target/servlet-simple-web.war
```

## Run With Manual Tomcat Deploy

Copy WAR to Tomcat:

```bash
cp target/servlet-simple-web.war /Users/tigranho/Tools/apache-tomcat-10/webapps/
```

Start Tomcat:

```bash
/Users/tigranho/Tools/apache-tomcat-10/bin/startup.sh
```

Open:

```text
http://localhost:8080/servlet-simple-web/tasks
```

Stop Tomcat:

```bash
/Users/tigranho/Tools/apache-tomcat-10/bin/shutdown.sh
```

## Run With IntelliJ IDEA

Use IntelliJ IDEA Ultimate for Tomcat integration.

1. Open `Run -> Edit Configurations...`.
2. Click `+`.
3. Choose `Tomcat Server -> Local`.
4. Set Tomcat Home:

```text
/Users/tigranho/Tools/apache-tomcat-10
```

5. Open the `Deployment` tab.
6. Click `+`.
7. Choose `Artifact`.
8. Select:

```text
servlet-simple-web:war exploded
```

9. Set Application context:

```text
/servlet-simple-web
```

10. Run the configuration.

## Test URLs

Open in browser:

```text
http://localhost:8080/servlet-simple-web/
http://localhost:8080/servlet-simple-web/tasks
```

Test with curl:

```bash
curl -i "http://localhost:8080/servlet-simple-web/tasks"
curl -i -X POST "http://localhost:8080/servlet-simple-web/tasks" -d "title=Learn Servlets"
curl -i -X PUT "http://localhost:8080/servlet-simple-web/tasks?id=1"
curl -i -X DELETE "http://localhost:8080/servlet-simple-web/tasks?id=1"
```

HTTP methods:

```text
GET    http://localhost:8080/servlet-simple-web/tasks
POST   http://localhost:8080/servlet-simple-web/tasks
PUT    http://localhost:8080/servlet-simple-web/tasks?id=1
DELETE http://localhost:8080/servlet-simple-web/tasks?id=1
```
