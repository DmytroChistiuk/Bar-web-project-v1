package dao;

import entity.Cocktail;
import entity.User;
import service.UserService;
import util.ConnectionContext;
import util.ConnectionPool;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserBarDAO {

    private static final String QUERY_FIND_ALL="select user.name, cocktail.cocktail_name,cocktail.recipe, cocktail.cocktail_type,cocktail.cocktail_history from user_bar inner join user on user_bar.user_id=user.id inner join cocktail on user_bar.cocktail_name=cocktail.cocktail_name";
    private static final String QUERY_FIND_BY_ID="select user.name, cocktail.cocktail_name,cocktail.recipe, cocktail.cocktail_type,cocktail.cocktail_history from user_bar inner join user on user_bar.user_id=user.id inner join cocktail on user_bar.cocktail_name=cocktail.cocktail_name where user.id =?";
    private static final String QUERY_FIND_BY_NAME="select user.name, cocktail.cocktail_name,cocktail.recipe, cocktail.cocktail_type,cocktail.cocktail_history from user_bar inner join user on user_bar.user_id=user.id inner join cocktail on user_bar.cocktail_name=cocktail.cocktail_name where user.name =?";
    private static final String INSERT_SQL = "INSERT INTO user_bar VALUES(?, ?)";
    private static final String DELETE = "DELETE FROM user_bar WHERE cocktail_name = ?";

    public static void deleteCocktailFromUserBar(String name) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE))
        {
            prepareStatement.setString(1, name);
            prepareStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Cocktail addCocktailToUserBar(int id, Cocktail cocktail) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, cocktail.getCocktailName());
            preparedStatement.executeUpdate();
            return cocktail;
        }
    }

    public  List<Cocktail> findAllCocktailByUserBarId(int id) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
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
        }}

    private  List<Cocktail> findAllCocktailInUserBarByName(String name) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_NAME);
        ) {
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
        }}

    public static HashMap<String,List<Cocktail>> findAll() throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {

            HashMap<String,List<Cocktail>> allUsersCocktails = new HashMap<>();

            while (resultSet.next()) {

                String userName = resultSet.getString("name");
                UserBarDAO userBarDAO = new UserBarDAO();
                List <Cocktail> cocktails = userBarDAO.findAllCocktailInUserBarByName(userName);
                allUsersCocktails.put(userName,cocktails);
            }
            return allUsersCocktails;
        }

    }
}


