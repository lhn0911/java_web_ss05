package com.rikkei.ss05.controller;

import com.rikkei.ss05.model.Student;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentListServlet", value = "/studentList")
public class StudentListServlet extends HttpServlet {
    private static final List<Student> students = new ArrayList<>();
    private static final int STUDENTS_PER_PAGE = 5;
    private static int nextId = 11; // Dùng để tạo ID mới khi thêm

    @Override
    public void init() {
        if (students.isEmpty()) {
            students.add(new Student(1, "Nguyễn Văn A", 20, "Hà Nội"));
            students.add(new Student(2, "Trần Thị B", 22, "Đà Nẵng"));
            students.add(new Student(3, "Lê Văn C", 19, "TP. HCM"));
            students.add(new Student(4, "Phạm Thị D", 21, "Hải Phòng"));
            students.add(new Student(5, "Ngô Quang E", 23, "Cần Thơ"));
            students.add(new Student(6, "Bùi Thiên F", 24, "Bình Dương"));
            students.add(new Student(7, "Hoàng Minh G", 25, "Long An"));
            students.add(new Student(8, "Đặng Thu H", 26, "Quảng Ninh"));
            students.add(new Student(9, "Vũ Hoàng I", 27, "Thái Nguyên"));
            students.add(new Student(10, "Lý Minh J", 28, "Quảng Nam"));
        }
        getServletContext().setAttribute("students", students);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String studentIdParam = request.getParameter("studentId");

        if ("delete".equals(action) && studentIdParam != null) {
            try {
                int studentId = Integer.parseInt(studentIdParam);
                students.removeIf(s -> s.getId() == studentId);
            } catch (NumberFormatException ignored) {}
            response.sendRedirect("studentList");
            return;
        }

        if ("edit".equals(action) && studentIdParam != null) {
            try {
                int studentId = Integer.parseInt(studentIdParam);
                for (Student student : students) {
                    if (student.getId() == studentId) {
                        request.setAttribute("student", student);
                        request.getRequestDispatcher("view/Bai4/editStudent.jsp").forward(request, response);
                        return;
                    }
                }
            } catch (NumberFormatException ignored) {}
        }

        request.setAttribute("students", getStudentsForPage(request));
        request.setAttribute("currentPage", getCurrentPage(request));
        request.setAttribute("totalPages", getTotalPages());
        request.getRequestDispatcher("view/Bai4/studentList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("studentId");
        String name = request.getParameter("name");
        String ageParam = request.getParameter("age");
        String address = request.getParameter("address");

        try {
            int age = Integer.parseInt(ageParam);

            if (idParam == null || idParam.isEmpty()) {
                Student newStudent = new Student(nextId++, name, age, address);
                students.add(newStudent);
            } else {
                int id = Integer.parseInt(idParam);
                for (Student student : students) {
                    if (student.getId() == id) {
                        student.setName(name);
                        student.setAge(age);
                        student.setAddress(address);
                        break;
                    }
                }
            }
        } catch (NumberFormatException ignored) {}

        response.sendRedirect(request.getContextPath() + "/studentList");
    }

    private List<Student> getStudentsForPage(HttpServletRequest request) {
        int page = getCurrentPage(request);
        int start = (page - 1) * STUDENTS_PER_PAGE;
        int end = Math.min(start + STUDENTS_PER_PAGE, students.size());
        return students.subList(start, end);
    }

    private int getCurrentPage(HttpServletRequest request) {
        int page = 1;
        try {
            String pageParam = request.getParameter("page");
            if (pageParam != null) {
                page = Integer.parseInt(pageParam);
            }
        } catch (NumberFormatException ignored) {}
        return Math.max(1, Math.min(page, getTotalPages()));
    }

    private int getTotalPages() {
        return (int) Math.ceil((double) students.size() / STUDENTS_PER_PAGE);
    }
}
