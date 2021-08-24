package service;

import dao.UserBarDAO;
import entity.Cocktail;
import entity.User;
import org.apache.log4j.Logger;
import util.ConnectionContext;
import util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static dao.UserBarDAO.deleteCocktailFromUserBar;

public class UserBarService {
    private static final Logger logger = Logger.getLogger(UserBarService.class);
    private UserBarDAO userBarDAO = new UserBarDAO();

    public Cocktail addCocktail(int id, Cocktail cocktail) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return userBarDAO.addCocktailToUserBar(id, cocktail, connection);
        } catch (SQLException e) {
            logger.error("Failed to add cocktail to user's bar", e);
            return null;
        }
    }

    public List<Cocktail> getUserBar(int id) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return userBarDAO.findAllCocktailByUserBarId(id, connection);
        } catch (SQLException e) {
            logger.error("Failed to get user's bar", e);
            return null;
        }
    }

    public Cocktail deleteCocktail(Cocktail cocktail, User user) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            deleteCocktailFromUserBar(cocktail.getCocktailName(), user.getId(), connection);
        } catch (SQLException e) {
            logger.error("Failed to delete cocktail from user's bar", e);
        }
        return null;
    }

    public Cocktail deleteDuplicateCocktail(Cocktail cocktail, User user) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        Connection connection = connectionPool.getConnection();
        try {
            connection.setAutoCommit(false);
            deleteCocktailFromUserBar(cocktail.getCocktailName(), user.getId(), connection);
            userBarDAO.addCocktailToUserBar(user.getId(), cocktail, connection);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            logger.error("Failed to delete duplicate cocktail from user's bar", e);
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
        return null;
    }
}
