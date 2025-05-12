<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/12/2025
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm liên hệ mới</h2>
<form action="ContactServlet?action=create" method="post">
  Họ: <input type="text" name="firstName" required><br>
  Tên: <input type="text" name="lastName" required><br>
  Email: <input type="email" name="email" required><br>
  SĐT: <input type="text" name="phone" required><br>
  <input type="submit" value="Thêm">
</form>
<a href="ContactServlet">Quay lại danh sách</a>
</body>
</html>
