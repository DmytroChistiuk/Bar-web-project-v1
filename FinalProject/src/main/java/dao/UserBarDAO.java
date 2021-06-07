package dao;

import entity.UserBar;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserBarDAO {
    private static final String USER_FILDS= "UserBarAlcoholId,UserBarSoftdrinkId";
    private static final String QUERY_FIND_ALL="SELECT * FROM user_bar";
    private static final String QUERY_FIND_BY_ID="SELECT * FROM user_bar where id = ?";
    private static final String INSERT_SQL = "INSERT INTO user_bar(" + USER_FILDS + ") VALUES(?, ?)";
    private static final String DELETE = "DELETE FROM user_bar WHERE id = ?";

    public static void deleteUserBar(int id) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE))
        {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Integer createUserBar(UserBar userBar) throws SQLException {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setInt(1, userBar.getUserBarAlcoholId());
            preparedStatement.setInt(2, userBar.getUserBarSoftdrinkId());


            return preparedStatement.executeUpdate();
        }
    }

    public static UserBar findById(int id) throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            List <UserBar> usersBar = new ArrayList<>();
            if (resultSet.next()) {
                UserBar userBar = new UserBar();
                userBar.setId(resultSet.getInt("id"));
                userBar.setUserBarAlcoholId(resultSet.getInt("UserBarAlcoholId"));
                userBar.setUserBarSoftdrinkId(resultSet.getInt("UserBarSoftdrinkId"));

                return userBar;
            }
            return null;

        }}

    public static List<UserBar> findAll() throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <UserBar> usersBar = new ArrayList<>();

            while (resultSet.next()) {
                UserBar userBar = new UserBar();
                int id = resultSet.getInt("id");
                int UserBarAlcoholId = resultSet.getInt("UserBarAlcoholId");
                int UserBarSoftdrinkId = resultSet.getInt("UserBarSoftdrinkId");

                userBar.setId(id);
                userBar.setUserBarAlcoholId(UserBarAlcoholId);
                userBar.setUserBarSoftdrinkId(UserBarSoftdrinkId);

                usersBar.add(userBar);
            }
            return usersBar;
        }

    }
}

