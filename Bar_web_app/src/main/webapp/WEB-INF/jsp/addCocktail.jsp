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
    <title>Cocktail editor</title>
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
        <li>Profile</li>
    </ul>
</header>
<main class="main-content">
    <div class="main-content-wrapper-profile">
        <form method="post">
            <span><h5 style="text-align:center" class="text-dark  sbtt">Welcome to cocktail editor page! Please enter your cocktail.</h5></span>
            <div class="row">
                <div class="col-md-4 col-sm-12">
                    <span><h5>
                    Type cocktail's name:
                    <input type="text" value="Cocktail name" name="cocktailName"/>
                        </h5></span>
                </div>
                <div class="col-md-4 col-sm-12">
                    <span><h5>
                    Type cocktail's recipe:
                    <input type="text" value="Recipe" name="recipe"/>
                        </h5></span>
                </div>
                <div class="col-md-4 col-sm-12">
                    <span><h5>
                    Type cocktail's type:
                    <input type="text" value="Cocktail type" name="cocktailType"/>
                    </h5></span>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-4 col-sm-12">
                    <span><h5>
                    Type cocktail's history:
                    <input type="text" value="Cocktail history" name="cocktailHistory"/>
                    </h5></span>
                </div>
                <div class="col-md-4 col-sm-12">
                    <span><h5>
                    Type cocktail's icon:
                    <input type="text" value="Cocktail icon" name="cocktailIcon"/>
                    </h5></span>
                </div>
                <div class="col-md-4 col-sm-12">
                    <span><h5>
                    Type cocktail's photo:
                    <input type="text" value="Cocktail photo" name="cocktailPhoto"/>
                    </h5></span>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-12 col-sm-12">
                    <span><h5 style="text-align:center" class="text-dark  sbtt">Please enter cocktail ingredients using "," to separate value.</h5></span>
                    <span><input class="container-fluid centerd" type="text" value="Ingredient1,Ingredient2,Ingredient3"
                                 name="ingredientsName"/></span>
                    <br>
                    <br>
                    <span><h5 style="text-align:center" class="text-dark"><button class="btn btn-primary" name="Submit"
                                                                                  value="addCocktail" type="Submit">Create cocktail</button></h5></span>
                </div>
            </div>
        </form>
    </div>
</main>
</body>
</html>
