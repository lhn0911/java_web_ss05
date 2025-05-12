package com.rikkei.ss05.controller;

import com.rikkei.ss05.model.Post;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BlogServlet", value = "/BlogServlet")
public class BlogServlet extends HttpServlet {
    private static final List<Post> posts = new ArrayList<>();

    @Override
    public void init() {
        if (posts.isEmpty()) {
            posts.add(new Post(1, "Giới thiệu Java", "Nội dung chi tiết về Java...", "Nguyễn Văn A", "2025-05-01"));
            posts.add(new Post(2, "Học Servlet", "Nội dung về Servlet và cách sử dụng...", "Trần Thị B", "2025-05-05"));
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String idParam = request.getParameter("id");

        if ("post".equals(action) && idParam != null) {
            int id = Integer.parseInt(idParam);
            Post post = posts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
            request.setAttribute("post", post);
            request.getRequestDispatcher("view/Bai9/postDetail.jsp").forward(request, response);
        } else {
            request.setAttribute("posts", posts);
            request.getRequestDispatcher("view/Bai9/postList.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}