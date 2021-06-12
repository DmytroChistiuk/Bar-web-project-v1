package dao;

import entity.CocktailInfo;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CocktailInfoDAO {
    private static final String USER_FILDS= "name,cocktailType,recipe";
    private static final String QUERY_FIND_ALL="SELECT * FROM cocktail_info";
    private static final String QUERY_FIND_BY_ID="SELECT * FROM cocktail_info where id = ?";
    private static final String INSERT_SQL = "INSERT INTO cocktail_info(" + USER_FILDS + ") VALUES(?, ?, ?)";
    private static final String DELETE = "DELETE FROM cocktail_info WHERE id = ?";

    public  void deleteCocktailInfo (int id) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE))
        {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Integer createCocktailInfo (CocktailInfo cocktailInfo) throws SQLException {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1, cocktailInfo.getName());
            preparedStatement.setString(2, cocktailInfo.getCocktailType());
            preparedStatement.setString(3, cocktailInfo.getRecipe());

            return preparedStatement.executeUpdate();
        }
    }

    public  CocktailInfo findById(int id) throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next()) {
                CocktailInfo cocktailInfo = new CocktailInfo();

                cocktailInfo.setName(resultSet.getString("name"));
                cocktailInfo.setCocktailType(resultSet.getString("cocktailType"));
                cocktailInfo.setRecipe(resultSet.getString("recipe"));

                return cocktailInfo;
            }
            return null;

        }}

    public static List<CocktailInfo> findAll() throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <CocktailInfo> cocktailInfos = new ArrayList<>();

            while (resultSet.next()) {
                CocktailInfo cocktailInfo = new CocktailInfo();

                String name = resultSet.getString("name");
                String cocktailType = resultSet.getString("cocktailType");
                String recipe = resultSet.getString("recipe");



                cocktailInfo.setName(name);
                cocktailInfo.setCocktailType(cocktailType);
                cocktailInfo.setRecipe(recipe);

                cocktailInfos.add(cocktailInfo);
            }
            return cocktailInfos;
        }

    }
}

