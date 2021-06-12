package dao;

import entity.Alcohol;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlcoholDAO {
    private static final String USER_FILDS= "name";
    private static final String QUERY_FIND_ALL="SELECT * FROM alcohol";
    private static final String QUERY_FIND_BY_ID="SELECT * FROM alcohol where id = ?";
    private static final String INSERT_SQL = "INSERT INTO alcohol(" + USER_FILDS + ") VALUES(?)";
    private static final String DELETE = "DELETE FROM alcohol WHERE id = ?";

    public  void deleteAlcohol(int id) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE))
        {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Integer createAlcohol(Alcohol alcohol) throws SQLException {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1, alcohol.getName());

            return preparedStatement.executeUpdate();
        }
    }

    public Alcohol findById(int id) throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next()) {
                Alcohol alcohol = new Alcohol();

                alcohol.setName(resultSet.getString("name"));

                return alcohol;
            }
            return null;

        }}

    public static List<Alcohol> findAll() throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <Alcohol> alcohols = new ArrayList<>();

            while (resultSet.next()) {
                Alcohol alcohol = new Alcohol();

                String name = resultSet.getString("name");


                alcohol.setName(name);


                alcohols.add(alcohol);
            }
            return alcohols;
        }

    }
}


