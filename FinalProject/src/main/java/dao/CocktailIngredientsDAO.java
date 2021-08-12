package dao;

import entity.CocktailIngredients;

import exception.DaoException;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CocktailIngredientsDAO {
    private static final Logger loggerDao = Logger.getLogger(CocktailIngredientsDAO.class);
    private static final String QUERY_FIND_ALL ="" +
            "select cocktail.cocktail_name, ingredients.name" +
            " from cocktail_ingredient"+
            " inner join ingredients on cocktail_ingredient.ingredient_id = ingredients.ingredient_id"+
            " inner join cocktail on cocktail_ingredient.cocktail_id = cocktail.cocktail_id";

    private static final String QUERY_FIND_BY_СOCKTAILNAME ="" +
            "select cocktail.cocktail_name, ingredients.name"+
            " from cocktail_ingredient"+
            " inner join ingredients on cocktail_ingredient.ingredient_id = ingredients.ingredient_id"+
            " inner join cocktail on cocktail_ingredient.cocktail_id = cocktail.cocktail_id where cocktail.cocktail_name = ?";

    public HashMap<String, List<CocktailIngredients>> findByCocktailName(String name, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_СOCKTAILNAME);
        ) {
            prepareStatement.setString(1, name);
            ResultSet resultSet = prepareStatement.executeQuery();
            List<CocktailIngredients> cocktailIngredients = new ArrayList<>();
            HashMap<String, List<CocktailIngredients>> cocktail = new HashMap<>();
            while (resultSet.next()) {
                CocktailIngredients ingredientsOfCocktail = new CocktailIngredients();
                ingredientsOfCocktail.setIngredientName(resultSet.getString("name"));
                cocktailIngredients.add(ingredientsOfCocktail);
            }
            cocktail.put(name, cocktailIngredients);
            return cocktail;

        } catch (SQLException e) {
            loggerDao.error("Failed to find cocktails ingredient by name", e);
            throw new DaoException("Failed to find cocktails ingredient by name");
        }
    }


    public static List<CocktailIngredients> findAll(Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
             ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List<CocktailIngredients> cocktailIngredients = new ArrayList<>();

            while (resultSet.next()) {
                CocktailIngredients cocktailIngredient = new CocktailIngredients();

                String cocktailName = resultSet.getString("cocktail_name");
                String ingredientName = resultSet.getString("name");

                cocktailIngredient.setCocktailName(cocktailName);
                cocktailIngredient.setIngredientName(ingredientName);


                cocktailIngredients.add(cocktailIngredient);
            }

            return cocktailIngredients;
        } catch (SQLException e) {
            loggerDao.error("Failed to find all cocktails ingredient in all cocktails", e);
            throw new DaoException("Failed to find all cocktails ingredient in all cocktails");
        }
    }
}
