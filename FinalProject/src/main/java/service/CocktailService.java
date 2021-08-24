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
    private static final Logger logger = Logger.getLogger(CocktailService.class);

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
            logger.error("Failed to delete cocktail", e);
        }
    }

    public Cocktail create(String cocktailName, String recipe, String cocktailType, String cocktailHistory, String icon, String photo) throws SQLException {
        Cocktail cocktail = new Cocktail();
        cocktail.setCocktailName(cocktailName);
        cocktail.setRecipe(recipe);
        cocktail.setCocktailType(cocktailType);
        cocktail.setCocktailHistory(cocktailHistory);
        cocktail.setCocktailIcon(icon);
        cocktail.setCocktailPhoto(photo);

        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return cocktailDAO.createCocktail(cocktail, connection);
        } catch (SQLException e) {
            logger.error("Failed to create cocktail", e);
            return null;
        }
    }

    public Cocktail getById(int id) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return cocktailDAO.findById(id, connection);
        } catch (SQLException e) {
            logger.error("Failed to get cocktail by id", e);
            return null;
        }
    }

    public Cocktail getByName(String name) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return cocktailDAO.findByName(name, connection);
        } catch (SQLException e) {
            logger.error("Failed to get cocktail by name", e);
            return null;
        }
    }

    public List<Cocktail> findAll() throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return cocktailDAO.findAllCocktails(connection);
        } catch (SQLException e) {
            logger.error("Failed to find all cocktails", e);
            return null;
        }
    }

    public boolean checkCocktailInDatabase(String name) {
        try {
            List<Cocktail> allCocktails = findAll();
            for (Cocktail cocktail : allCocktails) {
                if (cocktail.getCocktailName().equals(name)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            logger.error("Failed to check is cocktail exist", e);
            return false;
        }
        return false;
    }
}
