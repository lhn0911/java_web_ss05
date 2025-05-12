<%@ page import="com.rikkei.ss05.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/12/2025
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><%= request.getAttribute("student") != null ? "Chỉnh sửa sinh viên" : "Thêm sinh viên" %></title></head>
<body>
<h2><%= request.getAttribute("student") != null ? "Chỉnh sửa thông tin sinh viên" : "Form Nhập Thông Tin Sinh Viên" %></h2>

<%
    Student student = (Student) request.getAttribute("student");
    boolean isEdit = student != null;
%>

<form action="<%= request.getContextPath() %>/studentList" method="post">
    <% if (isEdit) { %>
    <input type="hidden" name="studentId" value="<%= student.getId() %>">
    <% } %>
    Họ tên: <input type="text" name="name" value="<%= isEdit ? student.getName() : "" %>" required><br><br>
    Tuổi: <input type="number" name="age" value="<%= isEdit ? student.getAge() : "" %>" required><br><br>
    Địa chỉ: <input type="text" name="address" value="<%= isEdit ? student.getAddress() : "" %>" required><br><br>
    <input type="submit" value="<%= isEdit ? "Cập nhật" : "Thêm mới" %>">
</form>

<a href="<%= request.getContextPath() %>/studentList">Quay lại danh sách</a>

</body>
</html>
