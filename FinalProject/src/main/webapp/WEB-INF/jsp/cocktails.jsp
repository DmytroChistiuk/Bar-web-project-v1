<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%--@elvariable id="user" type="com.company.entity.Cocktail"--%>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<a href="UserBar">View my bar</a>

<c:forEach items="${cocktails}" var="cocktail">
    <br>
    <c:out value="${cocktail.cocktailName}"/>
    <c:out value="${cocktail.recipe}"/>
    <c:out value="${cocktail.cocktailType}"/>
    <c:out value="${cocktail.cocktailHistory}"/>
    <a href="addToUserBar?cocktailId=${cocktail.cocktailId}">Save to my bar</a>
</c:forEach>

</body>
</html>