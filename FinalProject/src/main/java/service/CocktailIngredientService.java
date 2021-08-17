package service;

import dao.CocktailIngredientsDAO;
import entity.CocktailIngredients;
import org.apache.log4j.Logger;
import util.ConnectionContext;
import util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class CocktailIngredientService {
    private static final Logger loggerService = Logger.getLogger(CocktailIngredientService.class);
    CocktailIngredientsDAO cocktailIngredientsDAO;

    public CocktailIngredientService() {
        cocktailIngredientsDAO = new CocktailIngredientsDAO();
    }

    public List<CocktailIngredients> getAllIngredientsByCocktailName(String name) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            HashMap<String, List<CocktailIngredients>> currentMap = cocktailIngredientsDAO.findAllIngredientsByCocktailName(name, connection);
            return currentMap.get(name);
        } catch (SQLException e) {
            loggerService.error("Failed to find all ingredients by cocktail name", e);
            return null;
        }
    }

    public List<CocktailIngredients> getAllCocktailsByIngredientName(String name) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            HashMap<String, List<CocktailIngredients>> currentMap = cocktailIngredientsDAO.findAllCocktailsByIngredientName(name, connection);
            return currentMap.get(name);
        } catch (SQLException e) {
            loggerService.error("Failed to find all cocktails by ingredient name", e);
            return null;
        }
    }
    public void setChainCocktailIngredient(int cocktailId, int ingredientId) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
           cocktailIngredientsDAO.create(cocktailId,ingredientId,connection);
        } catch (SQLException e) {
            loggerService.error("Failed to find all cocktails by ingredient name", e);
        }
    }
}
