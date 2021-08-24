<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="user" type="com.company.entity.User"--%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/main.css">
	<style>
        <%@include file='css/main.css' %>
    </style>
	<title>Profile</title>
</head>
<body>
	<header class="main-header">
		<ul>
			<li><a onClick='window.location.href="UserBar"'>My bar</a></li>
			<li><a onClick='window.location.href="allCocktails"'>All cocktails</a></li>
			<li><a onClick='window.location.href="allIngredients"'>All ingredients</a></li>
		</ul>
  		<ul>
			<li>Profile</li>
		</ul>
	</header>
	<main class="main-content">
		<div class="main-content-wrapper">
			<div class="row">
				<div class="col-md-6 col-sm-12">
					<span>Name:</span>
				</div>
				<div class="col-md-6 col-sm-12">
					<span>${user.name}</span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-sm-12">
					<span>Surname:</span>
				</div>
				<div class="col-md-6 col-sm-12">
					<span>${user.surname}</span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-sm-12">
					<span>Login:</span>
				</div>
				<div class="col-md-6 col-sm-12">
					<span>${user.login}</span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-sm-12">
					<span>Role:</span>
				</div>
				<div class="col-md-6 col-sm-12">
					<span>${user.role}</span>
				</div>
			</div>
		</div>
	</main>  

</body>
</html>