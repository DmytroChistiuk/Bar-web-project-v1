package service;

import dao.CocktailIngredientsDAO;
import entity.Cocktail;
import org.apache.log4j.Logger;
import util.ConnectionContext;
import util.ConnectionPool;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class CocktailIngredientService {
    private static final Logger logger = Logger.getLogger(CocktailIngredientService.class);
    private CocktailIngredientsDAO cocktailIngredientsDAO;

    public CocktailIngredientService() {
        cocktailIngredientsDAO = new CocktailIngredientsDAO();
    }

    public List<Cocktail> getAllCocktailsByIngredientName(String name) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            HashMap<String, List<Cocktail>> currentMap = cocktailIngredientsDAO.findAllCocktailsByIngredientName(name, connection);
            return currentMap.get(name);
        } catch (SQLException e) {
            logger.error("Failed to get all cocktails by ingredient name", e);
            return null;
        }
    }

    public void setChainCocktailIngredient(int cocktailId, int ingredientId) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            cocktailIngredientsDAO.create(cocktailId, ingredientId, connection);
        } catch (SQLException e) {
            logger.error("Failed to set chain cocktailID -> ingredientID", e);
        }
    }
}
