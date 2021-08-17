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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
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
