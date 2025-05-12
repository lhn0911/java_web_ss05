<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="Bai2">Bai2</a><br>

<a href="Bai3">Bai3</a><br>
<a href="studentList">Bai4</a><br>
<a href="tasks">Bai8</a><br>
<a href="BlogServlet">Bai9</a><br>
<a href="ContactServlet">Bai10</a><br>
<%response.sendRedirect("CategoriesController?action=findAll");%>
</body>
</html>