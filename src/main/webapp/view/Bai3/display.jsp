<%@ page import="com.rikkei.ss05.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/9/2025
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student student = (Student) request.getAttribute("student");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thông Tin Sinh Viên</h2>
<p><strong>Tên:</strong> <%= student.getName() %></p>
<p><strong>Tuổi:</strong> <%= student.getAge() %></p>
<p><strong>Địa chỉ:</strong> <%= student.getAddress() %></p>
</body>
</html>
