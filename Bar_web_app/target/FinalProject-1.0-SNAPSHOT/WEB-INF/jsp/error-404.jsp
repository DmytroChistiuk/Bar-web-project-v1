
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <title>404</title>
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
    <div class="main-content-wrapper-profile">
        <span><h5 style="text-align:center" class="text-dark">Page not found 404</h5></span>
    </div>
</main>
</body>
</html>