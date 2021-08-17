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
    private static final String QUERY_FIND_BY_INGREDIENTNAME ="" +
            "select cocktail.cocktail_name, ingredients.name"+
            " from cocktail_ingredient"+
            " inner join cocktail on cocktail_ingredient.cocktail_id = cocktail.cocktail_id"+
            " inner join ingredients on cocktail_ingredient.ingredient_id = ingredients.ingredient_id WHERE ingredients.name = ?";
    private static final String QUERY_INSERT ="INSERT INTO cocktail_ingredient (cocktail_id, ingredient_id) VALUES(?, ?)";
    public HashMap<String, List<CocktailIngredients>> findAllIngredientsByCocktailName(String name, Connection connection) throws DaoException {
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
            loggerDao.error("Failed to find all ingredients by cocktail name", e);
            throw new DaoException("Failed to find all ingredients by cocktail name");
        }
    }

    public HashMap<String, List<CocktailIngredients>> findAllCocktailsByIngredientName(String name, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_INGREDIENTNAME)) {
            prepareStatement.setString(1, name);
            ResultSet resultSet = prepareStatement.executeQuery();
            List<CocktailIngredients> cocktailIngredients = new ArrayList<>();
            HashMap<String, List<CocktailIngredients>> ingredients = new HashMap<>();
            while (resultSet.next()) {
                CocktailIngredients ingredientsOfCocktail = new CocktailIngredients();
                ingredientsOfCocktail.setCocktailName(resultSet.getString("cocktail_name"));
                cocktailIngredients.add(ingredientsOfCocktail);
            }
            ingredients.put(name, cocktailIngredients);
            return ingredients;

        } catch (SQLException e) {
            loggerDao.error("Failed to find all cocktails by ingredient name", e);
            throw new DaoException("Failed to find all cocktails by ingredient name");
        }
    }


    public  List<CocktailIngredients> findAll(Connection connection) throws DaoException {
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
    public void create(int cocktailId, int ingredientId, Connection connection){
        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT)) {
            preparedStatement.setInt(1, cocktailId);
            preparedStatement.setInt(2, ingredientId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            loggerDao.error("Set chain cocktailID -> ingredientID", e);
        }
    }
}
