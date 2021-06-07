package dao;

import entity.AdditiveCocktailIngredient;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdditiveCocktailIngredientDAO {

    private static final String USER_FILDS= "additiveId";
    private static final String QUERY_FIND_ALL="SELECT * FROM additive_cocktail_ingredient";
    private static final String QUERY_FIND_BY_ID="SELECT * FROM additive_cocktail_ingredient where id = ?";
    private static final String INSERT_SQL = "INSERT INTO additive_cocktail_ingredient(" + USER_FILDS + ") VALUES(?)";
    private static final String DELETE = "DELETE FROM additive_cocktail_ingredient WHERE id = ?";

    public static void deleteAdditiveCocktailIngredient(int id) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE))
        {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Integer createAdditiveCocktailIngredient(AdditiveCocktailIngredient additiveCocktailIngredient) throws SQLException {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setInt(1, additiveCocktailIngredient.getAdditiveId());


            return preparedStatement.executeUpdate();
        }
    }

    public static AdditiveCocktailIngredient findById(int id) throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            List <AdditiveCocktailIngredient> additiveCocktailIngredients = new ArrayList<>();
            if (resultSet.next()) {
                AdditiveCocktailIngredient additiveCocktailIngredient = new AdditiveCocktailIngredient();

                additiveCocktailIngredient.setAdditiveId(resultSet.getInt("additiveId"));

                return additiveCocktailIngredient;
            }
            return null;

        }}

    public static List<AdditiveCocktailIngredient> findAll() throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <AdditiveCocktailIngredient> additiveCocktailIngredients = new ArrayList<>();

            while (resultSet.next()) {
                AdditiveCocktailIngredient additiveCocktailIngredient = new AdditiveCocktailIngredient();

                int additiveId = resultSet.getInt("additiveId");



                additiveCocktailIngredient.setAdditiveId(additiveId);
                additiveCocktailIngredients.add(additiveCocktailIngredient);
            }
            return additiveCocktailIngredients;
        }

    }
}
