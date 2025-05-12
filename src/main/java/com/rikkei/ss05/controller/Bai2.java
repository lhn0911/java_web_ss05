package com.rikkei.ss05.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Bai2", value = "/Bai2")
public class Bai2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.sendRedirect("view/Bai2/student.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        request.setAttribute("name", name);
        request.setAttribute("age", age);
        request.setAttribute("address", address);
        request.getRequestDispatcher("view/Bai2/confirm.jsp").forward(request, response);
    }
}