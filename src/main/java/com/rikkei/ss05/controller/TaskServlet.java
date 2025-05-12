package com.rikkei.ss05.controller;

import com.rikkei.ss05.model.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TaskServlet", value = "/tasks")
public class TaskServlet extends HttpServlet {
    private static final List<Task> tasks = new ArrayList<>();
    private static int idCounter = 1;
    private Task getTaskById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            request.getRequestDispatcher("view/Bai8/addTask.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            String idParam = request.getParameter("id");
            int id = Integer.parseInt(idParam);
            Task task = getTaskById(id);
            request.setAttribute("task", task);
            request.getRequestDispatcher("view/Bai8/editTask.jsp").forward(request, response);
        }else if ("delete".equals(action)) {
            String idParam = request.getParameter("id");
            try {
                int id = Integer.parseInt(idParam);
                tasks.removeIf(task -> task.getId() == id);
            } catch (NumberFormatException ignored) {}
            response.sendRedirect(request.getContextPath() + "/tasks");
            return;
        } else {
            request.setAttribute("tasks", tasks);
            request.getRequestDispatcher("view/Bai8/taskList.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            String description = request.getParameter("description");
            String dueDate = request.getParameter("dueDate");
            boolean completed = "on".equals(request.getParameter("completed"));

            Task task = new Task(idCounter++, description, dueDate, completed);
            tasks.add(task);
            response.sendRedirect(request.getContextPath() + "/tasks");
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String description = request.getParameter("description");
            String dueDate = request.getParameter("dueDate");
            boolean completed = "on".equals(request.getParameter("completed"));

            Task task = getTaskById(id);
            if (task != null) {
                task.setDescription(description);
                task.setDueDate(dueDate);
                task.setCompleted(completed);
            }

            response.sendRedirect(request.getContextPath() + "/tasks");
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            tasks.removeIf(task -> task.getId() == id);
            response.sendRedirect(request.getContextPath() + "/tasks");
        }
    }
}