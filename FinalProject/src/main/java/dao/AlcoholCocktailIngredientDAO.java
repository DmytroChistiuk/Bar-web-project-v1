package dao;

import entity.AlcoholCocktailIngredient;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlcoholCocktailIngredientDAO {

    private static final String USER_FILDS= "alcoholId";
    private static final String QUERY_FIND_ALL="SELECT * FROM alcohol_cocktail_ingredient";
    private static final String QUERY_FIND_BY_ID="SELECT * FROM alcohol_cocktail_ingredient where id = ?";
    private static final String INSERT_SQL = "INSERT INTO additive_cocktail_ingredient(" + USER_FILDS + ") VALUES(?)";
    private static final String DELETE = "DELETE FROM alcohol_cocktail_ingredient WHERE id = ?";

    public static void deleteAlcoholCocktailIngredient(int id) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE))
        {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Integer createAlcoholCocktailIngredient(AlcoholCocktailIngredient alcoholCocktailIngredient) throws SQLException {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setInt(1, alcoholCocktailIngredient.getAlcoholId());

            return preparedStatement.executeUpdate();
        }
    }

    public static AlcoholCocktailIngredient findById(int id) throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            List <AlcoholCocktailIngredient> alcoholCocktailIngredients = new ArrayList<>();
            if (resultSet.next()) {
                AlcoholCocktailIngredient alcoholCocktailIngredient = new AlcoholCocktailIngredient();

                alcoholCocktailIngredient.setAlcoholId(resultSet.getInt("alcoholId"));

                return alcoholCocktailIngredient;
            }
            return null;

        }}

    public static List<AlcoholCocktailIngredient> findAll() throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <AlcoholCocktailIngredient> alcoholCocktailIngredients = new ArrayList<>();

            while (resultSet.next()) {
                AlcoholCocktailIngredient alcoholCocktailIngredient = new AlcoholCocktailIngredient();


                int alcoholId = resultSet.getInt("alcoholId");


                alcoholCocktailIngredient.setAlcoholId(alcoholId);
                alcoholCocktailIngredients.add(alcoholCocktailIngredient);
            }
            return alcoholCocktailIngredients;
        }

    }
}

