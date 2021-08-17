
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    <title>Cocktail editor</title>
</head>
<body>
<form method="post">
    Welcome to cocktail editor page! Please enter your cocktail.
    <br>
    <input type="text" value="Cocktail name" name="cocktailName"/>
    <input type="text" value="Recipe" name="recipe"/>
    <input type="text" value="Cocktail type" name="cocktailType"/>
    <input type="text" value="Cocktail history" name="cocktailHistory"/>
    <input type="text" value="Cocktail icon" name="cocktailIcon"/>
    <input type="text" value="Cocktail photo" name="cocktailPhoto"/>
    <br>
    Please enter cocktail ingredients using "," to separate value.
    <input type="text" value="Ingredient1,Ingredient2,Ingredient3" name="ingredientsName"/>
    <br>
    <button name="Submit" value="addCocktail" type="Submit">Create cocktail</button>

</form>
</body>
</html>
