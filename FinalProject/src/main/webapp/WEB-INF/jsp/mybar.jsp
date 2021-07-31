
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%--@elvariable id="cocktail" type="com.company.entity.Cocktail"--%>
<%--@elvariable id="userBar" type="com.company.entity.UserBar"--%>
<html>
<head>
    <title>BAR</title>
</head>
<body>
<c:forEach items="${userBar}" var="cocktail">
    <br>
    <c:out value="${cocktail.cocktailName}"/>
    <c:out value="${cocktail.recipe}"/>
    <c:out value="${cocktail.cocktailType}"/>
    <c:out value="${cocktail.cocktailHistory}"/>
    <a href="deleteFromUserBar?cocktailId=${cocktail.cocktailId}">Delete from my bar</a>
    <a href="deleteDublicatesFromUserBar?cocktailId=${cocktail.cocktailId}">Delete dublicates</a>

</c:forEach>
<br>
<a href="cocktails">view all cocktails</a>

</body>
</html>
