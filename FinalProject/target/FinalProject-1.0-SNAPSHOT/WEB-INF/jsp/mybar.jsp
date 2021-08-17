
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%--@elvariable id="cocktail" type="com.company.entity.Cocktail"--%>
<%--@elvariable id="userBar" type="com.company.entity.UserBar"--%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
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
