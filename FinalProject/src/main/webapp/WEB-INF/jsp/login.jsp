<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="user" type="com.company.entity.User"--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    Please login
    <br>
    <input type="text" name="userName"/>
    <input type="password" name="password"/>
    <br>
    <button name="Submit" value="Login" type="Submit">Login</button>
</form>
</body>
</html>
