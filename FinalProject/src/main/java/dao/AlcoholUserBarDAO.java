package dao;

import entity.AlcoholUserBar;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlcoholUserBarDAO {

    private static final String USER_FILDS= "name,surname,login,password";
    private static final String QUERY_FIND_ALL="SELECT * FROM user";
    private static final String QUERY_FIND_BY_ID="SELECT * FROM user where id = ?";
    private static final String INSERT_SQL = "INSERT INTO user(" + USER_FILDS + ") VALUES(?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM user WHERE id = ?";

    public static void deleteAlcoholUserBar(int id) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE))
        {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Integer createAlcoholUserBar(AlcoholUserBar alcoholUserBar) throws SQLException {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setInt(1, alcoholUserBar.getAlcoholUserBarId());
            return preparedStatement.executeUpdate();
        }
    }

    public static AlcoholUserBar findById(int id) throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            List <AlcoholUserBar> alcoholUserBars = new ArrayList<>();
            if (resultSet.next()) {
                AlcoholUserBar alcoholUserBar = new AlcoholUserBar();

                alcoholUserBar.setAlcoholUserBarId(resultSet.getInt("AlcoholUserBarIdr"));
                return alcoholUserBar;
            }
            return null;

        }}

    public static List<AlcoholUserBar> findAll() throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <AlcoholUserBar> alcoholUserBars = new ArrayList<>();

            while (resultSet.next()) {
                AlcoholUserBar alcoholUserBar = new AlcoholUserBar();

                int AlcoholUserBarId = resultSet.getInt("AlcoholUserBarId");

                alcoholUserBar.setAlcoholUserBarId(AlcoholUserBarId);

                alcoholUserBars.add(alcoholUserBar);
            }
            return alcoholUserBars;
        }

    }
}


