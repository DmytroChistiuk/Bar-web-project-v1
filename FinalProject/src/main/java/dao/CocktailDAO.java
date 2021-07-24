package dao;

import entity.Cocktail;
import util.ConnectionContext;
import util.ConnectionPool;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CocktailDAO {
    private static final String FILDS= "cocktail_name, cocktail_type, cocktail_history, recipe";
    private static final String QUERY_FIND_ALL="SELECT cocktail_id,cocktail_name, cocktail_type, cocktail_history, recipe FROM cocktail";
    private static final String QUERY_FIND_BY_ID="SELECT cocktail_id,cocktail_name, cocktail_type, cocktail_history, recipe FROM cocktail where cocktail_id = ?";
    private static final String INSERT_SQL = "INSERT INTO cocktail(" + FILDS + ") VALUES(?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM cocktail WHERE cocktail_id = ?";

    public static void deleteCocktail(int id) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE))
        {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Cocktail createCocktail(Cocktail cocktail) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1, cocktail.getCocktailName());
            preparedStatement.setString(2, cocktail.getRecipe());
            preparedStatement.setString(3, cocktail.getCocktailType());
            preparedStatement.setString(4, cocktail.getCocktailHistory());

            preparedStatement.executeUpdate();
            return cocktail;
        }
    }

    public  Cocktail findById(int id) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
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
                return cocktail;
            }
            return null;

        }}


    public  List<Cocktail> findAllCocktails() throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <Cocktail> cocktails = new ArrayList<>();

            while (resultSet.next()) {
                Cocktail cocktail = new Cocktail();

                int cocktailId = resultSet.getInt("cocktail_id");
                String cocktailName = resultSet.getString("cocktail_name");
                String cocktailType = resultSet.getString("cocktail_type");
                String cocktailHistory = resultSet.getString("cocktail_history");
                String recipe = resultSet.getString("recipe");

                cocktail.setCocktailId(cocktailId);
                cocktail.setCocktailName(cocktailName);
                cocktail.setCocktailType(cocktailType);
                cocktail.setCocktailHistory(cocktailHistory);
                cocktail.setRecipe(recipe);

                cocktails.add(cocktail);
            }
            return cocktails;
        }

    }
}
