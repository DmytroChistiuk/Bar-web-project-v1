package dao;

import entity.User;

import exception.DaoException;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final Logger loggerDao = Logger.getLogger(UserDAO.class);
    private static final String QUERY_FIND_ALL = "SELECT name,surname,login,password,id,role FROM user";
    private static final String QUERY_FIND_BY_ID = "SELECT * FROM user where id = ?";
    private static final String INSERT_SQL = "INSERT INTO user (name,surname,login,password,role) VALUES(?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM user WHERE id = ?";
    private static final String QUERY_FIND_BY_LOGIN = "SELECT * FROM user where login = ?";

    public static void deleteUser(int id, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(DELETE)) {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            loggerDao.error("Failed to delete user", e);
            throw new DaoException("Failed to delete user");
        }
    }

    public User createUser(User user, Connection connection) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.executeUpdate();
            return user;
        } catch (SQLException e) {
            loggerDao.error("Failed to create user", e);
            throw new DaoException("Failed to create user");
        }
    }

    public User findById(int id, Connection connection) throws DaoException {
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
                user.setRole(resultSet.getString("role"));
                return user;
            }
            return null;

        } catch (SQLException e) {
            loggerDao.error("Failed find by id user", e);
            throw new DaoException("Failed find by id user");
        }
    }

    public User findByLogin(String login, Connection connection) throws DaoException {

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
                user.setRole(resultSet.getString("role"));
                return user;
            }
            return null;

        } catch (SQLException e) {
            loggerDao.error("Failed to find by login user", e);
            throw new DaoException("Failed to find by login user");
        }
    }


    public static List<User> findAll(Connection connection) throws DaoException {
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
                String role = resultSet.getString("role");

                user.setId(id);
                user.setName(name);
                user.setSurname(surname);
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(role);

                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            loggerDao.error("Failed to find all users", e);
            throw new DaoException("Failed to find all users");
        }
    }
}
