package com.example.servlet.web;

import com.example.servlet.model.Task;
import com.example.servlet.repository.TaskRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {

    private final TaskRepository repository = new TaskRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO:
        // 1. Set response content type to text/html.
        // 2. Get all tasks from repository.
        // 3. Create PrintWriter.
        // 4. Build HTML page.
        // 5. Show task form.
        // 6. Show all tasks.
        // 7. Add buttons/forms for done and delete actions.
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        List<Task> tasks = repository.findAll();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Servlet Simple Web</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>Task Manager</h1>");
        writer.println("<form method='post' action='tasks'>");
        writer.println("<input type='text' name='title' placeholder='Task title'>");
        writer.println("<button type='submit' name='action' value='add'>Add Task</button>");
        writer.println("</form>");
        writer.println("<hr>");

        renderTasks(writer, tasks);

        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO:
        // Implement POST request.
        // 1. Read title request parameter.
        // 2. Validate title.
        // 3. Call repository.add(title).
        // 4. Redirect back to /tasks.
        response.sendRedirect("tasks");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO:
        // Implement PUT request.
        // 1. Read id request parameter.
        // 2. Convert id from String to int.
        // 3. Call repository.markDone(id).
        // 4. Return 200 if updated.
        // 5. Return 404 if task does not exist.
        response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO:
        // Implement DELETE request.
        // 1. Read id request parameter.
        // 2. Convert id from String to int.
        // 3. Call repository.deleteById(id).
        // 4. Return 204 if deleted.
        // 5. Return 404 if task does not exist.
        response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
    }

    private void renderTasks(PrintWriter writer, List<Task> tasks) {
        writer.println("<h2>Tasks</h2>");

        if (tasks.isEmpty()) {
            writer.println("<p>No tasks yet.</p>");
            return;
        }

        writer.println("<ul>");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            writer.println("<li>");
            writer.println(task.getId() + ". " + task.getTitle() + " - " + (task.isDone() ? "Done" : "Open"));
            writer.println("<form method='post' action='tasks' style='display:inline'>");
            writer.println("<input type='hidden' name='id' value='" + task.getId() + "'>");
            writer.println("<button type='submit' name='action' value='done'>Done</button>");
            writer.println("<button type='submit' name='action' value='delete'>Delete</button>");
            writer.println("</form>");
            writer.println("</li>");
        }
        writer.println("</ul>");
    }
}
