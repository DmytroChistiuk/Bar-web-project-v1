<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%--@elvariable id="user" type="com.company.entity.Cocktail"--%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/main.css">
    <style>
        <%@include file='css/main.css' %>
    </style>
    <title>All ingredients</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/pageIcon.png" type="image/png">
</head>
<body>
<header class="main-header">
    <ul>
        <li><a onClick='window.location.href="UserBar"'>My bar</a></li>
        <li><a onClick='window.location.href="allCocktails"'>All cocktails</a></li>
        <li><a onClick='window.location.href="allIngredients"'>All ingredients</a></li>
    </ul>
    <ul>
        <li><a onClick='window.location.href="profile"'>Profile</a></li>
    </ul>
</header>
<main class="main-content">
    <div class="main-content-wrapper">
        <form method="post">
            <div class="row">
                <div class="col-md-4 col-sm-12">
                </div>
                <div class="col-md-4 col-sm-12">
                </div>
                <div class="col-md-4 col-sm-12">
                    <input type="text" value="Type cocktail name" name="cocktailName"/>
                    <button name="Submit" value="findCocktail" type="Submit">Search</button>
                </div>
            </div>
        </form>
        <c:forEach items="${cocktails}" var="cocktail">
            <br>
            <span><h5 style="text-align:center" class="text-dark sbtn2"> <img
                    src="${pageContext.request.contextPath}${cocktail.cocktailIcon}"/></h5></span>
            <br>
            <span><h5 style="text-align:center" class="text-dark sbtn2"><c:out value="${cocktail.cocktailName}"/> </h5></span>
            <span><h5 style="text-align:center" class="text-dark sbtn2"><a
                    href="addToUserBar?cocktailId=${cocktail.cocktailId}">Save to my bar</a> </h5></span>
            <span><h5 style="text-align:center" class="text-dark sbtn2"><a
                    href="viewCocktailProfile?cocktailId=${cocktail.cocktailId}">View cocktail profile</a> </h5></span>
        </c:forEach>
    </div>
</main>
</body>
</html>