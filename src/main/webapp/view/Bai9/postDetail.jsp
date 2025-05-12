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
<h2>${post.title}</h2>
<p><strong>Tác giả:</strong> ${post.author}</p>
<p><strong>Ngày đăng:</strong> ${post.publishDate}</p>
<hr>
<p>${post.content}</p>
<a href="BlogServlet">← Quay lại danh sách</a>
</body>
</html>
