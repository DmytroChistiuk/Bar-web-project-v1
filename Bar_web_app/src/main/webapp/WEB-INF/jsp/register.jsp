<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 13.06.2021
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
	<!--connect css file-->
	<link rel="stylesheet" href="css/main.css">
	<style>
        <%@include file='css/main.css' %>
    </style>
	<title>Sign in</title>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/pageIcon.png" type="image/png">
</head>
<body>
	<div class="auth-back">
		<img class="auth-img" src="${pageContext.request.contextPath}/img/logo.jpg" alt="logo">
    	<form method="post">
			<label for="name">First name</label><br>
		  	<input type="text" value="" name="name" id="name"/>
			<br>
			<label for="surname">Surname</label><br>
		  	<input type="text" value="" name="surname" id="surname"/>
			<br>
			<label for="login">Login</label><br>
		  	<input type="text" value="" name="login" id="login"/>
			<br>
			<label for="password">Password</label><br>
			<input type="password" value="" name="password" id="password"/>
			<button class="sbtn" name="Submit" value="Register" type="Submit">Sign in</button>
		</form>
	</div>
</body>
</html>
