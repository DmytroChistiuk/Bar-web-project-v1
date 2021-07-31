package service;

import dao.UserBarDAO;
import entity.Cocktail;
import entity.User;
import util.ConnectionContext;
import util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static dao.UserBarDAO.deleteCocktailFromUserBar;

public class UserBarService {
    private UserBarDAO userBarDAO = new UserBarDAO();

    public Cocktail addCocktail(int id, Cocktail cocktail) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return userBarDAO.addCocktailToUserBar(id, cocktail, connection);
        } catch (SQLException e) {
            System.out.println("Failed to add");
            return null;
        }
    }

    public List<Cocktail> getUserBar(int id) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return userBarDAO.findAllCocktailByUserBarId(id, connection);
        } catch (SQLException e) {
            System.out.println("Failed to find");
            return null;
        }
    }

    public Cocktail deleteCocktail(Cocktail cocktail, User user) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            deleteCocktailFromUserBar(cocktail.getCocktailName(), user.getId(), connection);
        } catch (SQLException e) {
            System.out.println("Failed to delete");
        }
        return null;
    }

    public Cocktail deleteDublicateCocktail(Cocktail cocktail, User user) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        Connection connection = connectionPool.getConnection();
        try {
            connection.setAutoCommit(false);
            deleteCocktailFromUserBar(cocktail.getCocktailName(), user.getId(), connection);
            userBarDAO.addCocktailToUserBar(user.getId(), cocktail, connection);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            System.out.println("Failed to delete");
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
        return null;
    }
}
