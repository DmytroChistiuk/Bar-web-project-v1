package dao;

import entity.Ingredient;
import exception.DaoException;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO {
    private static final Logger loggerDao = Logger.getLogger(IngredientDAO.class);
    private static final String QUERY_FIND_ALL = "SELECT name FROM ingredients";
    private static final String QUERY_FIND_BY_ID = "SELECT name FROM ingredients where ingredient_id = ?";
    private static final String INSERT_SQL = "INSERT INTO ingredients name VALUES(?)";
    private static final String DELETE = "DELETE FROM ingredients WHERE ingredient_id = ?";

    public static void deleteIngredient(int id, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(DELETE)) {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            loggerDao.error("Failed to delete ingredient", e);
            throw new DaoException("Failed to delete ingredient");
        }
    }


    public Ingredient createIngredient(Ingredient ingredient, Connection connection) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, ingredient.getName());
            preparedStatement.executeUpdate();
            return ingredient;
        } catch (SQLException e) {
            loggerDao.error("Failed to create cocktail", e);
            throw new DaoException("Failed to create cocktail");
        }
    }

    public Ingredient findById(int id, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                Ingredient cocktail = new Ingredient();
                cocktail.setName(resultSet.getString("name"));

                return cocktail;
            } else {
                return null;
            }
        } catch (SQLException e) {
            loggerDao.error("Failed to find cocktail by id", e);
            throw new DaoException("Failed to find cocktail by id");
        }
    }


    public static List<Ingredient> findAll(Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
             ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List<Ingredient> ingredients = new ArrayList<>();

            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient();

                String name = resultSet.getString("name");
                ingredient.setName(name);

                ingredients.add(ingredient);
            }
            return ingredients;
        } catch (SQLException e) {
            loggerDao.error("Failed to find all cocktail ingredient", e);
            throw new DaoException("Failed to find all cocktail ingredient");
        }
    }
}
