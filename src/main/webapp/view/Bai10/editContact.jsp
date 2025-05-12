<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/12/2025
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ContactServlet?action=update" method="post">
    <input type="hidden" name="id" value="${contact.id}">
    Họ: <input type="text" name="firstName" value="${contact.firstName}" required><br>
    Tên: <input type="text" name="lastName" value="${contact.lastName}" required><br>
    Email: <input type="email" name="email" value="${contact.email}" required><br>
    SĐT: <input type="text" name="phone" value="${contact.phone}" required><br>
    <input type="submit" value="Cập nhật">
</form>
<a href="ContactServlet">Quay lại danh sách</a>
</body>
</html>
