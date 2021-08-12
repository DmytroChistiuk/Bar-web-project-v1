<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="cocktail" type="com.company.entity.Cocktail"--%>
<html>
<head>
    <title>Cocktail profile</title>
</head>
<body>
<p>${cocktail.cocktailName} cocktail page</p>
<p>Name : ${cocktail.cocktailName}</p>
<p>Recipe : ${cocktail.recipe}</p>
<p>Cocktail type : ${cocktail.cocktailType}</p>
<p>Creation history : ${cocktail.cocktailHistory}</p>
</body>
</html>
