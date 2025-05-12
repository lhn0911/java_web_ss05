<%--
  Created by IntelliJ IDEA.
  User: HOANGNAM
  Date: 5/12/2025
  Time: 8:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/LoginServlet" method="post">
    <label>Username:</label>
    <input type="text" name="username" required />
    <br/>
    <label>Password:</label>
    <input type="password" name="password" required />
    <br/>
    <input type="submit" value="Login" />
    <p style="color:red">${error}</p>
</form>
</body>
</html>
