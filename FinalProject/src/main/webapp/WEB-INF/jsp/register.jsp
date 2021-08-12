<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 13.06.2021
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form method="post">
    Welcome to register page! Please enter name, surname, login, password.
    <br>
    <input type="text" value="Your name" name="name"/>
    <input type="text" value="Your surname" name="surname"/>
    <input type="text" value="Your login" name="login"/>
    <input type="password" value="Your password" name="password"/>
    <br>
    <button name="Submit" value="register" type="Submit">Register</button>
</form>
</body>
</html>
