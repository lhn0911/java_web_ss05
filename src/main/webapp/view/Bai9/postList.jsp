<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/12/2025
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách Bài viết</h2>
<ul>
    <c:forEach var="post" items="${posts}">
        <li>
            <strong>${post.title}</strong><br>
            Tác giả: ${post.author} - Ngày đăng: ${post.publishDate}<br>
            <a href="BlogServlet?action=post&id=${post.id}">Xem chi tiết</a>
        </li><br>
    </c:forEach>
</ul>
</body>
</html>
