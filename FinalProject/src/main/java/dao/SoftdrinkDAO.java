package dao;

import entity.Softdrink;
import entity.User;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SoftdrinkDAO {
    private static final String USER_FILDS= "name";
    private static final String QUERY_FIND_ALL="SELECT * FROM softdrink";
    private static final String QUERY_FIND_BY_ID="SELECT * FROM softdrink where id = ?";
    private static final String INSERT_SQL = "INSERT INTO softdrink(" + USER_FILDS + ") VALUE(?)";
    private static final String DELETE = "DELETE FROM softdrink WHERE id = ?";

    public  void deleteSoftdrink(int id) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE))
        {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Integer createSoftdrink(Softdrink softdrink) throws SQLException {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1, softdrink.getName());
            return preparedStatement.executeUpdate();
        }
    }

    public  Softdrink findById(int id) throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next()) {
                Softdrink softdrink = new Softdrink();
                softdrink.setName(resultSet.getString("name"));

                return softdrink;
            }
            return null;

        }}

    public static List<Softdrink> findAll() throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <Softdrink> softdrinks = new ArrayList<>();

            while (resultSet.next()) {
                Softdrink softdrink = new Softdrink();
                String name = resultSet.getString("name");
                softdrink.setName(name);


                softdrinks.add(softdrink);
            }
            return softdrinks;
        }
}}
