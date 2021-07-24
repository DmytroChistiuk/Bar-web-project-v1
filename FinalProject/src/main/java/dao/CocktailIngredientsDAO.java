package dao;

import entity.CocktailIngredients;
import util.ConnectionContext;
import util.ConnectionPool;
import util.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CocktailIngredientsDAO {

    private static final String QUERY_FIND_ALL=
            "select cocktail.cocktail_name, ingredients.name from cocktail_ingredient inner join ingredients on cocktail_ingredient.ingredient_id = ingredients.ingredient_id inner join cocktail on cocktail_ingredient.cocktail_id = cocktail.cocktail_id";

    private static final String QUERY_FIND_BY_СOCKTAILNAME=
            "select cocktail.cocktail_name, ingredients.name from cocktail_ingredient inner join ingredients on cocktail_ingredient.ingredient_id = ingredients.ingredient_id inner join cocktail on cocktail_ingredient.cocktail_id = cocktail.cocktail_id where cocktail.cocktail_name = ?";



    public static HashMap<String, List<CocktailIngredients>> findByCocktailName(String name) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_СOCKTAILNAME);
        ) {
            prepareStatement.setString(1, name);
            ResultSet resultSet = prepareStatement.executeQuery();
            List <CocktailIngredients> cocktailIngredients = new ArrayList<>();
            HashMap<String,List <CocktailIngredients>> cocktail = new HashMap<>();
            while (resultSet.next()) {
                CocktailIngredients ingredientsOfCocktail = new CocktailIngredients();
                ingredientsOfCocktail.setIngredientName(resultSet.getString("name"));
                cocktailIngredients.add(ingredientsOfCocktail);
            }
            cocktail.put(name,cocktailIngredients);
            return  cocktail;

        }}


    public static List<CocktailIngredients> findAll() throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <CocktailIngredients> cocktailIngredients = new ArrayList<>();

            while (resultSet.next()) {
                CocktailIngredients cocktailIngredient = new CocktailIngredients();

                String cocktailName = resultSet.getString("cocktail_name");
                String ingredientName = resultSet.getString("name");

                cocktailIngredient.setCocktailName(cocktailName);
                cocktailIngredient.setIngredientName(ingredientName);


                cocktailIngredients.add(cocktailIngredient);
            }

            return cocktailIngredients;
        }

    }
}
