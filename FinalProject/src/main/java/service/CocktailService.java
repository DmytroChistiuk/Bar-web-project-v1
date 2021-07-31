package service;

import dao.CocktailDAO;
import entity.Cocktail;
import util.ConnectionContext;
import util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CocktailService {
    private CocktailDAO cocktailDAO = new CocktailDAO();

    public Cocktail getById(int id) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return cocktailDAO.findById(id,connection);
        } catch (SQLException e) {
            System.out.println("Failed to find");
            return null;
        }
    }

    public List<Cocktail> findAll() throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()){
           return cocktailDAO.findAllCocktails(connection);
        } catch (SQLException e) {
            System.out.println("Failed to find");
            return null;
        }
    }
}
