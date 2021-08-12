package service;

import dao.CocktailDAO;
import entity.Cocktail;
import org.apache.log4j.Logger;
import util.ConnectionContext;
import util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CocktailService {
    private CocktailDAO cocktailDAO;
    private static final Logger loggerService = Logger.getLogger(CocktailService.class);
    public CocktailService(CocktailDAO cocktailDAO) {
        this.cocktailDAO = cocktailDAO;
    }

    public CocktailService() {
        cocktailDAO = new CocktailDAO();
    }

    public void delete(int id) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            cocktailDAO.deleteCocktail(id, connection);
        } catch (SQLException e) {
            loggerService.error("Failed to find",e);
        }
    }

    public Cocktail create(String cocktailName, String recipe, String cocktailType, String cocktailHistory) throws SQLException {
        Cocktail cocktail = new Cocktail();
        cocktail.setCocktailName(cocktailName);
        cocktail.setRecipe(recipe);
        cocktail.setCocktailType(cocktailType);
        cocktail.setCocktailHistory(cocktailHistory);
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return cocktailDAO.createCocktail(cocktail,connection);
        } catch (SQLException e) {
            loggerService.error("Failed to create",e);
            return null;
        }
    }

    public Cocktail getById(int id) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return cocktailDAO.findById(id, connection);
        } catch (SQLException e) {
            loggerService.error("Failed to get by id",e);
            return null;
        }
    }

    public List<Cocktail> findAll() throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return cocktailDAO.findAllCocktails(connection);
        } catch (SQLException e) {
            loggerService.error("Failed to find All",e);
            return null;
        }
    }
}
