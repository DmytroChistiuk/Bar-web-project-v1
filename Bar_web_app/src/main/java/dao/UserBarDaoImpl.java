package dao;

import entity.Cocktail;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Implementation of UserBarDao interface.
 * This class implements CRUD with the entity UserBar.
 */
public class UserBarDaoImpl implements UserBarDao {
    private static final Logger logger = Logger.getLogger(UserBarDaoImpl.class);
    /**
     * All queries that will execute to the database.
     */
    private static final String QUERY_FIND_BY_ID = "" +
            "select cocktail.cocktail_id, user.name, cocktail.cocktail_name,cocktail.recipe, cocktail.cocktail_type,cocktail.cocktail_history, cocktail.icon, cocktail.photo" +
            " from user_bar " +
            "inner join user on user_bar.user_id=user.id " +
            "inner join cocktail on user_bar.cocktail_name=cocktail.cocktail_name " +
            "where user.id =?";
    private static final String QUERY_FIND_BY_NAME = "" +
            "select user.name, cocktail.cocktail_name,cocktail.recipe, cocktail.cocktail_type,cocktail.cocktail_history, cocktail.icon, cocktail.photo"
            + " from user_bar" +
            " inner join user on user_bar.user_id=user.id" +
            " inner join cocktail on user_bar.cocktail_name=cocktail.cocktail_name where user.name =?";
    private static final String QUERY_INSERT = "INSERT INTO user_bar VALUES(?, ?)";
    private static final String QUERY_DELETE = "DELETE FROM user_bar WHERE cocktail_name = ? AND user_id = ?";

    @Override
    public void deleteCocktailFromUserBar(String name, int id, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_DELETE)) {
            prepareStatement.setString(1, name);
            prepareStatement.setInt(2, id);
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            logger.error("Failed to delete cocktail from user's bar", e);
            throw new DaoException("Failed to delete cocktail from user's bar");
        }
    }

    @Override
    public Cocktail addCocktailToUserBar(int id, Cocktail cocktail, Connection connection) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, cocktail.getCocktailName());
            preparedStatement.executeUpdate();
            return cocktail;
        } catch (SQLException e) {
            logger.error("Failed to add cocktail to user's bar", e);
            throw new DaoException("Failed to add cocktail to user's bar");
        }
    }

    @Override
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
                String icon = resultSet.getString("icon");
                String photo = resultSet.getString("photo");

                cocktail.setCocktailName(cocktailName);
                cocktail.setCocktailType(cocktailType);
                cocktail.setCocktailHistory(cocktailHistory);
                cocktail.setRecipe(recipe);
                cocktail.setCocktailId(cocktail_id);
                cocktail.setCocktailIcon(icon);
                cocktail.setCocktailPhoto(photo);

                cocktails.add(cocktail);
            }
            if (cocktails.isEmpty()) {
                return null;
            } else {
                return cocktails;
            }
        } catch (SQLException e) {
            logger.error("Failed to find all cocktail from user's bar by id", e);
            throw new DaoException("Failed to find all cocktail from user's bar by id");
        }
    }

    @Override
    public List<Cocktail> findAllCocktailInUserBarByName(String name, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_NAME)) {
            prepareStatement.setString(1, name);
            List<Cocktail> cocktails = new ArrayList<>();
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                Cocktail cocktail = new Cocktail();
                String cocktailName = resultSet.getString("cocktail_name");
                String cocktailType = resultSet.getString("cocktail_type");
                String cocktailHistory = resultSet.getString("cocktail_history");
                int cocktail_id = resultSet.getInt("cocktail_id");
                String recipe = resultSet.getString("recipe");
                String icon = resultSet.getString("icon");
                String photo = resultSet.getString("photo");

                cocktail.setCocktailName(cocktailName);
                cocktail.setCocktailType(cocktailType);
                cocktail.setCocktailHistory(cocktailHistory);
                cocktail.setRecipe(recipe);
                cocktail.setCocktailId(cocktail_id);
                cocktail.setCocktailIcon(icon);
                cocktail.setCocktailPhoto(photo);

                cocktails.add(cocktail);
            }
            return cocktails;
        } catch (SQLException e) {
            logger.error("Failed to find all cocktail from user's bar by name", e);
            throw new DaoException("Failed to find all cocktail from user's bar by name");
        }
    }
}


