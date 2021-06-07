
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="user" type="com.hillel.car.shop.entity.User"--%>
<html>
<head>
    <title>Profile </title>
</head>
<body>
  <p>Id : ${user.id}</p>
  <p>Name : ${user.name}</p>
  <p>Password : ${user.password}</p>
</body>
</html>