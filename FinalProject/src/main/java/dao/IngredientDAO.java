package dao;

import entity.Ingredient;
import util.ConnectionContext;
import util.ConnectionPool;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO {
    private static final String FILDS= "name";
    private static final String QUERY_FIND_ALL="SELECT ("+FILDS+")FROM ingredients";
    private static final String QUERY_FIND_BY_ID="SELECT("+FILDS+") FROM ingredients where ingredient_id = ?";
    private static final String INSERT_SQL = "INSERT INTO ingredients(" + FILDS + ") VALUES(?)";
    private static final String DELETE = "DELETE FROM ingredients WHERE ingredient_id = ?";

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


    public Ingredient createIngredient(Ingredient ingredient) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1, ingredient.getName());
            preparedStatement.executeUpdate();
            return ingredient;
        }
    }

    public  Ingredient findById(int id) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                Ingredient cocktail = new Ingredient();
                cocktail.setName(resultSet.getString("name"));

                return cocktail;
            }
            return null;

        }}


    public static List<Ingredient> findAll() throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <Ingredient> ingredients = new ArrayList<>();

            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient();

                String name = resultSet.getString("name");
                ingredient.setName(name);

                ingredients.add(ingredient);
            }
            return ingredients;
        }

    }
}
