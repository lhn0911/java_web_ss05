<%@ page import="com.rikkei.ss05.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/12/2025
  Time: 12:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh Sách Sinh Viên</h2>
<a href="<%= request.getContextPath() %>/view/Bai4/editStudent.jsp">Thêm Sinh Viên</a>
<table border="1">
    <tr>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Hành động</th>
    </tr>
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
        if (students != null) {
            for (Student student : students) {
    %>
    <tr>
        <td><%= student.getName() %></td>
        <td><%= student.getAge() %></td>
        <td><%= student.getAddress() %></td>
        <td>
            <a href="<%= request.getContextPath() %>/studentList?action=edit&studentId=<%= student.getId() %>">Sửa</a>
            <a href="<%= request.getContextPath() %>/studentList?action=delete&studentId=<%= student.getId() %>">Xóa</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
