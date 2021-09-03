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
	<!--connect css file-->
	<link rel="stylesheet" href="css/main.css">
    <title>Authorization</title>
	<style>
        <%@include file='css/main.css' %>
    </style>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/pageIcon.png" type="image/png">
</head>
<body>
	<div class="auth-back">
		<img class="auth-img" src="${pageContext.request.contextPath}/img/logo.jpg" alt="logo">
    	<form method="post">
			<label for="login">Enter your login</label><br>
		  	<input type="text" value="" name="login" id="login"/>
			<br>
			<label for="password">Enter your password</label><br>
			<input type="password" value="" name="password" id="password"/>
			<button class="sbtn" name="Submit" value="Login" type="Submit">Log in</button>
		</form>
		<p>
			<form>
		  		<input class="signup-btn" type="button" value="Sign up" onClick='window.location.href="register"'> if you don't have an account
			</form>
		</p>
	</div>
</body>
</html>
