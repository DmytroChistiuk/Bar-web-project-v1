package dao;

import entity.User;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String USER_FILDS= "name,surname,login,password";
    private static final String QUERY_FIND_ALL="SELECT * FROM user";
    private static final String QUERY_FIND_BY_ID="SELECT * FROM user where id = ?";
    private static final String INSERT_SQL = "INSERT INTO user(" + USER_FILDS + ") VALUES(?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM user WHERE id = ?";
    private static final String QUERY_FIND_BY_NAME="SELECT * FROM user where login = ?";
    public static void deleteUser(int id) {
        try (Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(DELETE))
        {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Integer createUser(User user) throws SQLException {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());

            return preparedStatement.executeUpdate();
        }
    }

    public  User findById(int id) throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
           ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            List <User> users = new ArrayList<>();
            if (resultSet.next()) {
                User user = new User();

                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
            return null;

    }}

    public  User findByName(String name) throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_NAME);
        ) {
            prepareStatement.setString(1,name);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();

                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
            return null;

        }}



    public static List<User> findAll() throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <User> users = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User();

                 String name = resultSet.getString("name");
                 String surname = resultSet.getString("surname");
                 String login = resultSet.getString("login");
                 String password = resultSet.getString("password");


                user.setName(name);
                user.setSurname(surname);
                user.setLogin(login);
                user.setPassword(password);

                users.add(user);
            }
            return users;
        }

    }
}
