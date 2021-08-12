<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 08.08.2021
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cocktail editor</title>
</head>
<body>
<form method="post">
    Welcome to cocktail editor page! Please enter your cocktail.
    <br>
    <input type="text" name="cocktailName"/>
    <input type="text" name="recipe"/>
    <input type="text" name="cocktailType"/>
    <input type="text" name="cocktailHistory"/>
    <br>
    <button name="Submit" value="addCocktail" type="Submit">Create cocktail</button>

</form>
</body>
</html>
