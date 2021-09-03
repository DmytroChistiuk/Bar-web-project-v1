<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="user" type="com.company.entity.User"--%>
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
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/pageIcon.png" type="image/png">
    <title>AdminProfile</title>
</head>
<body>
<header class="main-header">
    <ul>
        <li><a onClick='window.location.href="UserBar"'>My bar</a></li>
        <li><a onClick='window.location.href="allCocktails"'>All cocktails</a></li>
        <li><a onClick='window.location.href="allIngredients"'>All ingredients</a></li>
        <li><a onClick='window.location.href="addCocktail"'>Cocktail editor</a></li>
    </ul>
    <ul>
        <li>Profile</li>
    </ul>
</header>
<main class="main-content">
    <div class="main-content-wrapper-profile">
        <div class="row">
            <div class="col-md-12 col-sm-12 centered">
                <img src="${pageContext.request.contextPath}/img/userIcon.png" width="200" height="222"
                     class=" rounded-circle mx-auto d-block border border-dark" alt="...">
                <br>
            </div>
        </div>

        <div class="row">
            <div class="col-md-3 col-sm-12">

            </div>
            <div class="col-md-3 col-sm-12">
                <span>
                    <h5 style="text-align:center" class="text-dark  sbtt">
                    Name:</h5></span>
            </div>
            <div class="col-md-3 col-sm-12">
                <span><h5 style="text-align:center" class="text-dark  sbtt">${user.name}</h5></span>
            </div>
            <div class="col-md-3 col-sm-12">

            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-sm-12">

            </div>
            <div class="col-md-3 col-sm-12">
                <span><h5 style="text-align:center" class="text-dark  sbtt">Surname:</h5></span>
            </div>
            <div class="col-md-3 col-sm-12">
                <span><h5 style="text-align:center" class="text-dark  sbtt">${user.surname}</h5></span>
            </div>
            <div class="col-md-3 col-sm-12">

            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-sm-12">

            </div>
            <div class="col-md-3 col-sm-12">
                <span><h5 style="text-align:center" class="text-dark  sbtt">Login:</h5></span>
            </div>
            <div class="col-md-3 col-sm-12">
                <span><h5 style="text-align:center" class="text-dark  sbtt">${user.login}</h5></span>
            </div>
            <div class="col-md-3 col-sm-12">

            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-sm-12">

            </div>
            <div class="col-md-3 col-sm-12">
                <span><h5 style="text-align:center" class="text-dark sbtt">Role:</h5></span>
            </div>
            <div class="col-md-3 col-sm-12">
                <span><h5 style="text-align:center" class="text-dark sbtt">${user.role}</h5></span>
            </div>
            <div class="col-md-3 col-sm-12">

            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-12">
            </div>
            <div class="col-md-4 col-sm-12">
                <h4> Users setting:</h4>
                <span><h5 style="text-align:center" class="text-dark sbtt">
                <c:forEach items="${users}" var="userFromList">
                    Name: <c:out value="${userFromList.name}"/>
                    Login: <c:out value="${userFromList.login}"/>
                    Role: <c:out value="${userFromList.role}"/>
                    <a href="changeRole?id=${userFromList.id}">Change role</a>
                    <br>
                </c:forEach>
                    </h5></span>
            </div>
            <div class="col-md-4 col-sm-12">
            </div>
        </div>
    </div>
</main>
</body>
</html>
