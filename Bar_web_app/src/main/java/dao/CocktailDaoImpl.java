package dao;

import entity.Cocktail;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CocktailDaoImpl implements СocktailDao {
    private static final Logger logger = Logger.getLogger(CocktailDaoImpl.class);
    private static final String FILDS = "cocktail_name, cocktail_type, cocktail_history, recipe, icon, photo";
    private static final String QUERY_FIND_ALL = "SELECT cocktail_id,cocktail_name, cocktail_type, cocktail_history, recipe, icon, photo FROM cocktail";
    private static final String QUERY_FIND_BY_ID = "SELECT cocktail_id,cocktail_name, cocktail_type, cocktail_history, recipe, icon, photo FROM cocktail where cocktail_id = ?";
    private static final String QUERY_FIND_BY_NAME = "SELECT cocktail_id,cocktail_name, cocktail_type, cocktail_history, recipe, icon, photo FROM cocktail where cocktail_name = ?";
    private static final String QUERY_INSERT = "INSERT INTO cocktail(" + FILDS + ") VALUES(?, ?, ?, ?, ?, ?)";
    private static final String QUERY_DELETE = "DELETE FROM cocktail WHERE cocktail_id = ?";

    @Override
    public void deleteCocktail(int id, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_DELETE)) {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            logger.error("Failed to delete cocktail", e);
            throw new DaoException("Failed to delete cocktail");
        }
    }

    @Override
    public Cocktail createCocktail(Cocktail cocktail, Connection connection) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT)) {
            preparedStatement.setString(1, cocktail.getCocktailName());
            preparedStatement.setString(2, cocktail.getRecipe());
            preparedStatement.setString(3, cocktail.getCocktailType());
            preparedStatement.setString(4, cocktail.getCocktailHistory());
            preparedStatement.setString(5, cocktail.getCocktailIcon());
            preparedStatement.setString(6, cocktail.getCocktailPhoto());

            preparedStatement.executeUpdate();
            return cocktail;
        } catch (SQLException e) {
            logger.error("Failed to create cocktail", e);
            throw new DaoException("Failed to create cocktail");
        }
    }

    @Override
    public Cocktail findById(int id, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                Cocktail cocktail = new Cocktail();
                cocktail.setCocktailId(resultSet.getInt("cocktail_id"));
                cocktail.setCocktailName(resultSet.getString("cocktail_name"));
                cocktail.setCocktailType(resultSet.getString("cocktail_type"));
                cocktail.setCocktailHistory(resultSet.getString("cocktail_history"));
                cocktail.setRecipe(resultSet.getString("recipe"));
                cocktail.setCocktailIcon(resultSet.getString("icon"));
                cocktail.setCocktailPhoto(resultSet.getString("photo"));
                return cocktail;
            }
            return null;

        } catch (SQLException e) {
            logger.error("Failed to find cocktail by id", e);
            throw new DaoException("Failed to find cocktail by id");
        }
    }

    @Override
    public Cocktail findByName(String name, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_NAME);
        ) {
            prepareStatement.setString(1, name);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                Cocktail cocktail = new Cocktail();
                cocktail.setCocktailId(resultSet.getInt("cocktail_id"));
                cocktail.setCocktailName(resultSet.getString("cocktail_name"));
                cocktail.setCocktailType(resultSet.getString("cocktail_type"));
                cocktail.setCocktailHistory(resultSet.getString("cocktail_history"));
                cocktail.setRecipe(resultSet.getString("recipe"));
                cocktail.setCocktailIcon(resultSet.getString("icon"));
                cocktail.setCocktailPhoto(resultSet.getString("photo"));
                return cocktail;
            }
            return null;

        } catch (SQLException e) {
            logger.error("Failed to find cocktail by name", e);
            throw new DaoException("Failed to find cocktail by name");
        }
    }

    @Override
    public List<Cocktail> findAllCocktails(Connection connection) throws DaoException {

        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
             ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List<Cocktail> cocktails = new ArrayList<>();

            while (resultSet.next()) {
                Cocktail cocktail = new Cocktail();

                int cocktailId = resultSet.getInt("cocktail_id");
                String cocktailName = resultSet.getString("cocktail_name");
                String cocktailType = resultSet.getString("cocktail_type");
                String cocktailHistory = resultSet.getString("cocktail_history");
                String recipe = resultSet.getString("recipe");
                String icon = resultSet.getString("icon");
                String photo = resultSet.getString("photo");

                cocktail.setCocktailId(cocktailId);
                cocktail.setCocktailName(cocktailName);
                cocktail.setCocktailType(cocktailType);
                cocktail.setCocktailHistory(cocktailHistory);
                cocktail.setRecipe(recipe);
                cocktail.setCocktailIcon(icon);
                cocktail.setCocktailPhoto(photo);

                cocktails.add(cocktail);
            }
            return cocktails;
        } catch (SQLException e) {
            logger.error("Failed to find all cocktails", e);
            throw new DaoException("Failed to find all cocktails");
        }
    }
}
