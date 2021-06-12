package dao;

import entity.Additive;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdditiveDAO {
    private static final String USER_FILDS= "name";
    private static final String QUERY_FIND_ALL="SELECT * FROM additive";
    private static final String QUERY_FIND_BY_ID="SELECT * FROM additive where id = ?";
    private static final String INSERT_SQL = "INSERT INTO additive(" + USER_FILDS + ") VALUES(?)";
    private static final String DELETE = "DELETE FROM additive WHERE id = ?";

    public  void deleteAdditive(int id) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE))
        {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Integer createAdditive(Additive additive) throws SQLException {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1, additive.getName());

            return preparedStatement.executeUpdate();
        }
    }

    public  Additive findById(int id) throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next()) {
                Additive additive = new Additive();

                additive.setName(resultSet.getString("name"));

                return additive;
            }
            return null;

        }}

    public static List<Additive> findAll() throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <Additive> additives = new ArrayList<>();

            while (resultSet.next()) {
                Additive additive = new Additive();

                String name = resultSet.getString("name");


                additive.setName(name);

                additives.add(additive);
            }
            return additives;
        }

    }
}
