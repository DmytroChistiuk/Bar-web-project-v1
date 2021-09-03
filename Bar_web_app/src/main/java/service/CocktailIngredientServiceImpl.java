package service;

import dao.CocktailIngredientDaoImpl;
import entity.Cocktail;
import org.apache.log4j.Logger;
import util.ConnectionContext;
import util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class CocktailIngredientServiceImpl implements CocktailIngredientService {
    private static final Logger logger = Logger.getLogger(CocktailIngredientServiceImpl.class);
    private CocktailIngredientDaoImpl cocktailIngredientDaoImpl;
    private ConnectionPool connectionPool = null;

    public CocktailIngredientServiceImpl() {
        cocktailIngredientDaoImpl = new CocktailIngredientDaoImpl();
    }

    @Override
    public List<Cocktail> getAllCocktailsByIngredientName(String name) throws ServiceException {

        try {
            connectionPool = ConnectionContext.get();
        } catch (SQLException e) {
            logger.error("Failed to get connection from ConnectionContext", e);
            throw new ServiceException("Failed to get connection from ConnectionContext");
        }
        try (Connection connection = connectionPool.getConnection()) {
            HashMap<String, List<Cocktail>> currentMap = cocktailIngredientDaoImpl.findAllCocktailsByIngredientName(name, connection);
            return currentMap.get(name);
        } catch (SQLException e) {
            logger.error("Failed to get all cocktails by ingredient name", e);
            throw new ServiceException("Failed to get all cocktails by ingredient name");
        }
    }

    @Override
    public void setChainCocktailIngredient(int cocktailId, int ingredientId) throws ServiceException {

        try {
            connectionPool = ConnectionContext.get();
        } catch (SQLException e) {
            logger.error("Failed to get connection from ConnectionContext", e);
            throw new ServiceException("Failed to get connection from ConnectionContext");
        }
        try (Connection connection = connectionPool.getConnection()) {
            cocktailIngredientDaoImpl.create(cocktailId, ingredientId, connection);
        } catch (SQLException e) {
            logger.error("Failed to set chain cocktailID -> ingredientID", e);
            throw new ServiceException("Failed to set chain cocktailID -> ingredientID");
        }
    }

}
