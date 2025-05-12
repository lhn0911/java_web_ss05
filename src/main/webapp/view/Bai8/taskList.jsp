<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/12/2025
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách công việc</h2>
<a href="<%= request.getContextPath() %>/tasks?action=add">Thêm công việc mới</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Mô tả</th>
        <th>Ngày hết hạn</th>
        <th>Hoàn thành</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td>${task.id}</td>
            <td>${task.description}</td>
            <td>${task.dueDate}</td>
            <td>${task.completed ? 'Có' : 'Không'}</td>
            <td>
                <a href="<%= request.getContextPath() %>/tasks?action=edit&id=${task.id}">Chỉnh sửa</a> |
                <a href="<%= request.getContextPath() %>/tasks?action=delete&id=${task.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</body>
</html>
