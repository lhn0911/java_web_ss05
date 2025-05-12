<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/12/2025
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm công việc mới</h2>
<form action="<%= request.getContextPath() %>/tasks?action=create" method="post">
    Mô tả: <input type="text" name="description" required><br><br>
    Ngày hết hạn: <input type="text" name="dueDate" required><br><br>
    Hoàn thành: <input type="checkbox" name="completed"><br><br>
    <input type="submit" value="Thêm">
</form>
</body>
</html>
