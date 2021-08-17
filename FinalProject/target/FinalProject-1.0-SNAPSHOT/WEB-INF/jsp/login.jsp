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
    <title>Title</title>
    <style type="text/css">
    body{
        margin: 0;
        background-image: url(background/2.jpg);
        background-repeat: no-repeat;
    }
</style>

</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
        <form method="post">
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
        Please enter login and password
        <br>
        <input type="text" value="Your login" name="login"/>
        <input type="password" value="Your password" name="password"/>
        <br>
        <button name="Submit" value="Login" type="Submit">Login</button>
        </form>
        </div>
        <div class="col-md-4">
        </div>
        <div class="col-md-4">
        </div>
        <div class="col-md-4">
        <p>Please push the button "Sign up", if you want register now.</p>
        <form>
            <input type="button" value="Sign up" onClick='window.location.href="register"'>
        </form>
            <div class="col-md-4">
            </div>
        </div>
    </div>
</div>
</body>
</html>
