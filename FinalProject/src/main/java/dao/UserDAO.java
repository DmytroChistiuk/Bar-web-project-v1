package dao;

import entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ConnectionContext;
import util.ConnectionPool;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
    private static final String QUERY_FIND_ALL = "SELECT name,surname,login,password,id FROM user";
    private static final String QUERY_FIND_BY_ID = "SELECT * FROM user where id = ?";
    private static final String INSERT_SQL = "INSERT INTO user (name,surname,login,password) VALUES(?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM user WHERE id = ?";
    private static final String QUERY_FIND_BY_LOGIN = "SELECT * FROM user where login = ?";

    public static void deleteUser(int id, Connection connection) throws SQLException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(DELETE)) {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            logger.error("Failed to delete user", e);
        }
    }

    public User createUser(User user, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
            return user;
        } catch (SQLException e) {
            logger.error("Failed to create user", e);
        }
        return null;
    }

    public User findById(int id, Connection connection) {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
            return null;

        } catch (SQLException e) {
            logger.error("Failed find by id user", e);
        }
        return null;
    }

    public User findByLogin(String login, Connection connection) {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_LOGIN);
        ) {
            prepareStatement.setString(1, login);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
            return null;

        } catch (SQLException e) {
            logger.error("Failed to find by login user", e);
        }
        return null;
    }


    public static List<User> findAll(Connection connection) {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
             ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User();

                int id = resultSet.getInt(("id"));
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                user.setId(id);
                user.setName(name);
                user.setSurname(surname);
                user.setLogin(login);
                user.setPassword(password);

                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            logger.error("Failed to find all users", e);
        }
        return null;
    }
}
