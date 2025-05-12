package com.rikkei.ss05.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "123456789".equals(password)) {
            request.getSession().setAttribute("user", username);
            response.sendRedirect("StudentListServlet");
        } else {
            request.setAttribute("error", "Thông tin đăng nhập không đúng!");
            request.getRequestDispatcher("view/Bai6/login.jsp").forward(request, response);
        }
    }

}