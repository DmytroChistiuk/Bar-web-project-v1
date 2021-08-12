<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="user" type="com.company.entity.User"--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    Please enter login and password
    <br>
    <input type="text" value="Your login" name="login"/>
    <input type="password" value="Your password" name="password"/>
    <br>
    <button name="Submit" value="Login" type="Submit">Login</button>
</form>
    <p>Please push the button "Sign up", if you want register now.</p>
<form>
    <input type="button" value="Sign up" onClick='window.location.href="register"'>
</form>
</body>
</html>
