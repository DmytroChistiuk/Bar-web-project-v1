package dao;

import entity.CocktailIngredient;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CocktailIngredientDAO {

    private static final String USER_FILDS= "name,alcoholId,softdrinkId,additiveId,decoration";
    private static final String QUERY_FIND_ALL="SELECT * FROM cocktail_ ingredient";
    private static final String QUERY_FIND_BY_ID="SELECT * FROM cocktail_ ingredient where id = ?";
    private static final String INSERT_SQL = "INSERT INTO cocktail_ ingredient(" + USER_FILDS + ") VALUES(?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM cocktail_ ingredient WHERE id = ?";

    public  void deleteCocktailIngredient(int id) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE))
        {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Integer createCocktailIngredient( CocktailIngredient cocktailIngredient) throws SQLException {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1, cocktailIngredient.getName());
            preparedStatement.setInt(2, cocktailIngredient.getAlcoholId());
            preparedStatement.setInt(3, cocktailIngredient.getSoftdrinkId());
            preparedStatement.setInt(4, cocktailIngredient.getAdditiveId());
            preparedStatement.setString(4, cocktailIngredient.getDecoration());

            return preparedStatement.executeUpdate();
        }
    }

    public  CocktailIngredient findById(int id) throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next()) {
                CocktailIngredient cocktailIngredient = new CocktailIngredient();

                cocktailIngredient.setName(resultSet.getString("name"));
               cocktailIngredient.setAlcoholId(resultSet.getInt("alcoholId"));
                cocktailIngredient.setSoftdrinkId(resultSet.getInt("softdrinkId"));
               cocktailIngredient.setAdditiveId(resultSet.getInt("additiveId"));
               cocktailIngredient.setDecoration(resultSet.getString("decoration"));
                return cocktailIngredient;
            }
            return null;

        }}

    public static List<CocktailIngredient> findAll() throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <CocktailIngredient> cocktailIngredients = new ArrayList<>();

            while (resultSet.next()) {
                CocktailIngredient cocktailIngredient = new CocktailIngredient();

                String name = resultSet.getString("name");
                int alcoholId = resultSet.getInt("alcoholId");
                int softdrinkId = resultSet.getInt("softdrinkId");
                int additiveId = resultSet.getInt("additiveId");
                String decoration = resultSet.getString("decoration");
                cocktailIngredient.setName(name);
                cocktailIngredient.setAlcoholId(alcoholId);
                cocktailIngredient.setSoftdrinkId(softdrinkId);
                cocktailIngredient.setAdditiveId(additiveId);
                cocktailIngredient.setDecoration(decoration);
                cocktailIngredients.add(cocktailIngredient);
            }
            return cocktailIngredients;
        }

    }
}

