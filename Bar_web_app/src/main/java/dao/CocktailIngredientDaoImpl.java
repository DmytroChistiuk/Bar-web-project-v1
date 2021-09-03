package dao;

import entity.Cocktail;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CocktailIngredientDaoImpl implements CocktailIngredientDao {
    private static final Logger logger = Logger.getLogger(CocktailIngredientDaoImpl.class);
    private static final String QUERY_FIND_BY_INGREDIENT_NAME = "" +
            "select cocktail.cocktail_name,cocktail.recipe,cocktail.cocktail_type,cocktail.cocktail_id,cocktail.cocktail_history,cocktail.icon,cocktail.photo, ingredients.name, ingredients.ingredient_id" +
            " from cocktail_ingredient" +
            " inner join cocktail on cocktail_ingredient.cocktail_id = cocktail.cocktail_id" +
            " inner join ingredients on cocktail_ingredient.ingredient_id = ingredients.ingredient_id WHERE ingredients.name = ?";
    private static final String QUERY_INSERT = "INSERT INTO cocktail_ingredient (cocktail_id, ingredient_id) VALUES(?, ?)";

    public HashMap<String, List<Cocktail>> findAllCocktailsByIngredientName(String name, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_INGREDIENT_NAME)) {
            prepareStatement.setString(1, name);
            ResultSet resultSet = prepareStatement.executeQuery();
            List<Cocktail> cocktails = new ArrayList<>();
            HashMap<String, List<Cocktail>> ingredientCocktails = new HashMap<>();
            while (resultSet.next()) {
                Cocktail cocktail = new Cocktail();
                cocktail.setCocktailName(resultSet.getString("cocktail_name"));
                cocktail.setCocktailType(resultSet.getString("cocktail_type"));
                cocktail.setCocktailHistory(resultSet.getString("cocktail_history"));
                cocktail.setCocktailPhoto(resultSet.getString("photo"));
                cocktail.setCocktailIcon(resultSet.getString("icon"));
                cocktail.setRecipe(resultSet.getString("recipe"));
                cocktail.setCocktailId(resultSet.getInt("cocktail_id"));

                cocktails.add(cocktail);
            }
            ingredientCocktails.put(name, cocktails);
            return ingredientCocktails;

        } catch (SQLException e) {
            logger.error("Failed to find all cocktails by ingredient name", e);
            throw new DaoException("Failed to find all cocktails by ingredient name");
        }
    }

    public void create(int cocktailId, int ingredientId, Connection connection) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT)) {
            preparedStatement.setInt(1, cocktailId);
            preparedStatement.setInt(2, ingredientId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Set chain cocktailID -> ingredientID", e);
            throw new DaoException("Set chain cocktailID -> ingredientID");
        }
    }
}
