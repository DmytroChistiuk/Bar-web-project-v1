
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="user" type="com.company.entity.User"--%>
<html>
<head>
    <title>Profile</title>
</head>
<body>
  <p>Welcome dear!</p>
  <p>Name : ${user.name}</p>
  <p>Surname : ${user.surname}</p>
  <form>
      <input type="button" value="View my bar" onClick='window.location.href="UserBar"'>
      <input type="button" value="View all cocktails" onClick='window.location.href="cocktails"'>
  </form>
</body>
</html>