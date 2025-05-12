package com.rikkei.ss05.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.rikkei.ss05.model.Student;
@WebServlet(name = "Bai3", value = "/Bai3")
public class Bai3Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("view/Bai3/register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String address = request.getParameter("address");

        String errorMsg = "";
        int age = 0;
        if (name == null || name.trim().isEmpty()) {
            errorMsg += "Tên không được để trống.<br/>";
        }

        try {
            age = Integer.parseInt(ageStr);
            if (age <= 0) {
                errorMsg += "Tuổi phải lớn hơn 0.<br/>";
            }
        } catch (NumberFormatException e) {
            errorMsg += "Tuổi phải là số.<br/>";
        }

        if (address == null || address.trim().isEmpty()) {
            errorMsg += "Địa chỉ không được để trống.<br/>";
        }
        if (!errorMsg.isEmpty()) {
            request.setAttribute("error", errorMsg);
            request.getRequestDispatcher("view/Bai3/register.jsp").forward(request, response);
            return;
        }

        Student student = new Student(id,name, age, address);
        request.setAttribute("student", student);
        request.getRequestDispatcher("view/Bai3/display.jsp").forward(request, response);
    }
}