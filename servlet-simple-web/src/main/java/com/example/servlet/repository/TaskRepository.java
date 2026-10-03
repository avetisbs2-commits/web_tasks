package com.example.servlet.repository;

import com.example.servlet.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private final ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    public Task add(String title) {
        if (title == null || title.isBlank()) {
            return null;
        }

        Task task = new Task(nextId, title.trim(), false);
        tasks.add(task);
        nextId++;
        return task;
    }

    public boolean markDone(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getId() == id) {
                task.setDone(true);
                return true;
            }
        }

        return false;
    }

    public boolean deleteById(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getId() == id) {
                tasks.remove(i);
                return true;
            }
        }

        return false;
    }
}
