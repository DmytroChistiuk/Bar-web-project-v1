package dao;

import entity.Cocktail;

import exception.DaoException;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserBarDAO {
    private static final Logger loggerDao = Logger.getLogger(UserBarDAO.class);
    private static final String QUERY_FIND_ALL = "" +
            "select user.name, cocktail.cocktail_name,cocktail.recipe, cocktail.cocktail_type,cocktail.cocktail_history" +
            " from user_bar" +
            " inner join user on user_bar.user_id=user.id" +
            " inner join cocktail on user_bar.cocktail_name=cocktail.cocktail_name";
    private static final String QUERY_FIND_BY_ID = "" +
            "select cocktail.cocktail_id, user.name, cocktail.cocktail_name,cocktail.recipe, cocktail.cocktail_type,cocktail.cocktail_history" +
            " from user_bar " +
            "inner join user on user_bar.user_id=user.id " +
            "inner join cocktail on user_bar.cocktail_name=cocktail.cocktail_name " +
            "where user.id =?";
    private static final String QUERY_FIND_BY_NAME = "" +
            "select user.name, cocktail.cocktail_name,cocktail.recipe, cocktail.cocktail_type,cocktail.cocktail_history"
            + " from user_bar" +
            " inner join user on user_bar.user_id=user.id" +
            " inner join cocktail on user_bar.cocktail_name=cocktail.cocktail_name where user.name =?";
    private static final String INSERT_SQL = "INSERT INTO user_bar VALUES(?, ?)";
    private static final String DELETE = "DELETE FROM user_bar WHERE cocktail_name = ? AND user_id = ?";

    public static void deleteCocktailFromUserBar(String name, int id, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(DELETE)) {
            prepareStatement.setString(1, name);
            prepareStatement.setInt(2, id);
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            loggerDao.error("Failed to delete cocktail from user bar", e);
            throw new DaoException("Failed to delete cocktail from user bar");
        }
    }

    public Cocktail addCocktailToUserBar(int id, Cocktail cocktail, Connection connection) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, cocktail.getCocktailName());
            preparedStatement.executeUpdate();
            return cocktail;
        } catch (SQLException e) {
            loggerDao.error("Failed to add cocktail to user bar", e);
            throw new DaoException("Failed to add cocktail to user bar");
        }
    }

    public List<Cocktail> findAllCocktailByUserBarId(int id, Connection connection) throws DaoException {

        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID)) {
            prepareStatement.setLong(1, id);
            List<Cocktail> cocktails = new ArrayList<>();
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                Cocktail cocktail = new Cocktail();
                String cocktailName = resultSet.getString("cocktail_name");
                String cocktailType = resultSet.getString("cocktail_type");
                String cocktailHistory = resultSet.getString("cocktail_history");
                int cocktail_id = resultSet.getInt("cocktail_id");
                String recipe = resultSet.getString("recipe");
                cocktail.setCocktailName(cocktailName);
                cocktail.setCocktailType(cocktailType);
                cocktail.setCocktailHistory(cocktailHistory);
                cocktail.setRecipe(recipe);
                cocktail.setCocktailId(cocktail_id);
                cocktails.add(cocktail);
            }
            if (cocktails.isEmpty()) {
                return null;
            } else {
                return cocktails;
            }
        } catch (SQLException e) {
            loggerDao.error("Failed to find all cocktail from user bar by id", e);
            throw new DaoException("Failed to find all cocktail from user bar by id");
        }
    }

    private List<Cocktail> findAllCocktailInUserBarByName(String name, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_NAME)) {
            prepareStatement.setString(1, name);
            List<Cocktail> cocktails = new ArrayList<>();
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                Cocktail cocktail = new Cocktail();
                String cocktailName = resultSet.getString("cocktail_name");
                String cocktailType = resultSet.getString("cocktail_type");
                String cocktailHistory = resultSet.getString("cocktail_history");
                String recipe = resultSet.getString("recipe");
                cocktail.setCocktailName(cocktailName);
                cocktail.setCocktailType(cocktailType);
                cocktail.setCocktailHistory(cocktailHistory);
                cocktail.setRecipe(recipe);
                cocktails.add(cocktail);
            }
            return cocktails;
        } catch (SQLException e) {
            loggerDao.error("Failed to find all cocktail from user bar by name", e);
            throw new DaoException("Failed to find all cocktail from user bar by name");
        }
    }

    public static HashMap<String, List<Cocktail>> findAll(Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
             ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {

            HashMap<String, List<Cocktail>> allUsersCocktails = new HashMap<>();

            while (resultSet.next()) {

                String userName = resultSet.getString("name");
                UserBarDAO userBarDAO = new UserBarDAO();
                List<Cocktail> cocktails = userBarDAO.findAllCocktailInUserBarByName(userName, connection);
                allUsersCocktails.put(userName, cocktails);
            }
            return allUsersCocktails;
        } catch (SQLException e) {
            loggerDao.error("Failed to find all cocktail from all user bars", e);
            throw new DaoException("Failed to find all cocktail from all user bars");
        }
    }
}


