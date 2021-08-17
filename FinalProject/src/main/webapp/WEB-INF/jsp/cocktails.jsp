<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%--@elvariable id="user" type="com.company.entity.Cocktail"--%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    <title>Profile</title>
</head>
<body>
<a href="UserBar">View my bar</a>
<br>
<c:forEach items="${cocktails}" var="cocktail">
    <br>
    <c:out value="${cocktail.cocktailName}"/>
    <img src="${pageContext.request.contextPath}${cocktail.cocktailIcon}"/>
    <a href="addToUserBar?cocktailId=${cocktail.cocktailId}">Save to my bar</a>
    <a href="viewCocktailProfile?cocktailId=${cocktail.cocktailId}">View cocktail profile</a>
</c:forEach>

</body>
</html>