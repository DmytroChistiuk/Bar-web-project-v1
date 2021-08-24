package service;

import dao.IngredientDAO;
import entity.Ingredient;
import org.apache.log4j.Logger;
import util.ConnectionContext;
import util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class IngredientService {
    private IngredientDAO ingredientDAO;
    private static final Logger logger = Logger.getLogger(IngredientService.class);

    public IngredientService() {
        ingredientDAO = new IngredientDAO();
    }

    public Ingredient create(String name) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return ingredientDAO.createIngredient(ingredient, connection);
        } catch (SQLException e) {
            logger.error("Failed to create ingredient", e);
            return null;
        }
    }

    public Ingredient getById(int id) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return ingredientDAO.findById(id, connection);
        } catch (SQLException e) {
            logger.error("Failed to get ingredient by id", e);
            return null;
        }
    }

    public Ingredient getByName(String name) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return ingredientDAO.findByName(name, connection);
        } catch (SQLException e) {
            logger.error("Failed to get ingredient by name", e);
            return null;
        }
    }

    public List<Ingredient> findAll() throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return ingredientDAO.findAllIngredients(connection);
        } catch (SQLException e) {
            logger.error("Failed to find all ingredients", e);
            return null;
        }
    }

    public boolean checkIngredientInDatabase(String name) {
        try {
            List<Ingredient> allIngredient = findAll();
            for (Ingredient ingredient : allIngredient) {
                if (ingredient.getName().equals(name)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            logger.error("Failed to check is ingredient exist in database", e);
            return false;
        }
        return false;
    }

}
