package dao;

import entity.SoftdrinkCocktailIngredient;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SoftdrinkCocktailIngredientDAO {
    private static final String USER_FILDS= "softdrinkId";
    private static final String QUERY_FIND_ALL="SELECT * FROM softdrink_cocktail_ingredient";
    private static final String QUERY_FIND_BY_ID="SELECT * FROM softdrink_cocktail_ingredient where id = ?";
    private static final String INSERT_SQL = "INSERT INTO softdrink_cocktail_ingredient(" + USER_FILDS + ") VALUES(?)";
    private static final String DELETE = "DELETE FROM softdrink_cocktail_ingredient WHERE id = ?";

    public static void deleteSoftdrinkCocktailIngredient(int id) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE))
        {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Integer createSoftdrinkCocktailIngredient(SoftdrinkCocktailIngredient softdrinkCocktailIngredient) throws SQLException {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setInt(1,softdrinkCocktailIngredient.getSoftdrinkId());


            return preparedStatement.executeUpdate();
        }
    }

    public static SoftdrinkCocktailIngredient findById(int id) throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            List <SoftdrinkCocktailIngredient> softdrinkCocktailIngredients = new ArrayList<>();
            if (resultSet.next()) {
                SoftdrinkCocktailIngredient softdrinkCocktailIngredient = new SoftdrinkCocktailIngredient();
                softdrinkCocktailIngredient.setSoftdrinkId(resultSet.getInt("softdrinkId"));

                return softdrinkCocktailIngredient;
            }
            return null;

        }}

    public static List<SoftdrinkCocktailIngredient> findAll() throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <SoftdrinkCocktailIngredient> softdrinkCocktailIngredients = new ArrayList<>();

            while (resultSet.next()) {
                SoftdrinkCocktailIngredient softdrinkCocktailIngredient = new SoftdrinkCocktailIngredient();
                int softdrinkId = resultSet.getInt("softdrinkId");

                softdrinkCocktailIngredient.setSoftdrinkId(softdrinkId);


                softdrinkCocktailIngredients.add(softdrinkCocktailIngredient);
            }
            return softdrinkCocktailIngredients;
        }

    }
}

