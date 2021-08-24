<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <img src="${pageContext.request.contextPath}${cocktail.cocktailIcon}"/>
    ${cocktail.cocktailName}
    <a href="addToUserBar?cocktailId=${cocktail.cocktailId}">Save to my bar</a>
    <a href="viewCocktailProfile?cocktailId=${cocktail.cocktailId}">View cocktail profile</a>
</body>
</html>
