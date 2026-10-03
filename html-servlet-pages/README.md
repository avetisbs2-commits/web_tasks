# HTML Servlet Pages

## Goal

Create simple HTML pages that can later be used by `servlet-simple-web`.

This module is only for HTML practice.

Students should practice:

```text
HTML structure
forms
input fields
buttons
GET requests
POST requests
PUT requests with fetch
DELETE requests with fetch
links between pages
```

No Java code is used in this module.

## Project Structure

```text
html-servlet-pages/
├── README.md
├── pom.xml
└── src/
    └── main/
        └── webapp/
            ├── index.html
            ├── tasks.html
            ├── add-task.html
            ├── update-task.html
            └── delete-task.html
```

## Student Tasks

Complete the TODO comments in the HTML files.

The pages should match the servlet endpoints from `servlet-simple-web`:

```text
GET    /tasks
POST   /tasks
PUT    /tasks?id=1
DELETE /tasks?id=1
```

## Files To Complete

### `index.html`

Create a simple home page with links to all HTML practice pages.

### `tasks.html`

Create a page that represents the response of:

```text
GET /tasks
```

It should show:

```text
Task Manager title
Add task link
Task list layout
Done button
Delete button
```

### `add-task.html`

Create an HTML form for:

```text
POST /tasks
```

The form should use:

```html
method="post"
action="tasks"
```

### `update-task.html`

Create a page that sends:

```text
PUT /tasks?id=1
```

HTML forms do not support PUT directly, so use JavaScript `fetch`.

### `delete-task.html`

Create a page that sends:

```text
DELETE /tasks?id=1
```

HTML forms do not support DELETE directly, so use JavaScript `fetch`.

## Build

```bash
mvn clean package
```

The WAR file will be created here:

```text
target/html-servlet-pages.war
```

## Run

Deploy to Tomcat 10+ and open:

```text
http://localhost:8080/html-servlet-pages/
```

## Connection To Servlet Module

After students complete these HTML files, they can copy the useful HTML parts into:

```text
servlet-simple-web/src/main/java/com/example/servlet/web/TaskServlet.java
```

The servlet can then generate similar HTML with `PrintWriter`.

