package dao;

import entity.Ingredient;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientDaoImpl implements IngredientDao {
    private static final Logger logger = Logger.getLogger(IngredientDaoImpl.class);
    private static final String QUERY_FIND_ALL = "SELECT name,ingredient_id FROM ingredients";
    private static final String QUERY_FIND_BY_ID = "SELECT name,ingredient_id FROM ingredients where ingredient_id = ?";
    private static final String QUERY_INSERT = "INSERT INTO ingredients (name) VALUES(?)";
    private static final String QUERY_FIND_BY_NAME = "SELECT name,ingredient_id FROM ingredients where name = ?";

    @Override
    public Ingredient createIngredient(Ingredient ingredient, Connection connection) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT)) {
            preparedStatement.setString(1, ingredient.getName());
            preparedStatement.executeUpdate();
            return ingredient;
        } catch (SQLException e) {
            logger.error("Failed to create cocktail", e);
            throw new DaoException("Failed to create cocktail");
        }
    }

    @Override
    public Ingredient findById(int id, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                Ingredient ingredient = new Ingredient();
                ingredient.setName(resultSet.getString("name"));
                ingredient.setIngredientId(resultSet.getInt("ingredient_id"));
                return ingredient;
            } else {
                return null;
            }
        } catch (SQLException e) {
            logger.error("Failed to find cocktail by id", e);
            throw new DaoException("Failed to find cocktail by id");
        }
    }

    @Override
    public Ingredient findByName(String name, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_NAME);
        ) {
            prepareStatement.setString(1, name);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                Ingredient cocktail = new Ingredient();
                cocktail.setName(resultSet.getString("name"));
                cocktail.setIngredientId(resultSet.getInt("ingredient_id"));
                return cocktail;
            } else {
                return null;
            }
        } catch (SQLException e) {
            logger.error("Failed to find cocktail by name", e);
            throw new DaoException("Failed to find cocktail by name");
        }
    }

    @Override
    public List<Ingredient> findAllIngredients(Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
             ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List<Ingredient> ingredients = new ArrayList<>();

            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient();
                int id = resultSet.getInt("ingredient_id");
                String name = resultSet.getString("name");
                ingredient.setName(name);
                ingredient.setIngredientId(id);

                ingredients.add(ingredient);
            }
            return ingredients;
        } catch (SQLException e) {
            logger.error("Failed to find all cocktail ingredient", e);
            throw new DaoException("Failed to find all cocktail ingredient");
        }
    }
}
