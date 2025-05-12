<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/12/2025
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách liên hệ</h2>
<a href="ContactServlet?action=add">Thêm liên hệ mới</a>
<table border="1">
    <tr>
        <th>ID</th><th>Họ</th><th>Tên</th><th>Email</th><th>Điện thoại</th><th>Hành động</th>
    </tr>
    <c:forEach var="c" items="${contacts}">
        <tr>
            <td>${c.id}</td><td>${c.firstName}</td><td>${c.lastName}</td><td>${c.email}</td><td>${c.phone}</td>
            <td>
                <a href="ContactServlet?action=edit&id=${c.id}">Sửa</a>
                <form action="ContactServlet?action=delete" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${c.id}">
                    <input type="submit" value="Xóa">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
