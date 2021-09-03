package dao;

import entity.User;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
    private static final String QUERY_FIND_ALL = "SELECT name,surname,login,password,id,role FROM user";
    private static final String QUERY_FIND_BY_ID = "SELECT * FROM user where id = ?";
    private static final String QUERY_INSERT = "INSERT INTO user (name,surname,login,password,role) VALUES(?, ?, ?, ?, ?)";
    private static final String QUERY_FIND_BY_LOGIN = "SELECT * FROM user where login = ?";
    private static final String QUERY_UPDATE_ADMIN_ROLE = " UPDATE user SET role = \"admin\" WHERE id=?";
    private static final String QUERY_UPDATE_USER_ROLE = " UPDATE user SET role = \"user\" WHERE id=?";

    @Override
    public User createUser(User user, Connection connection) throws DaoException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.executeUpdate();
            return user;
        } catch (SQLException e) {
            logger.error("Failed to create user", e);
            throw new DaoException("Failed to create user");
        }
    }

    @Override
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
            logger.error("Failed find by id user", e);
            throw new DaoException("Failed find by id user");
        }
    }

    @Override
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
            logger.error("Failed to find by login user", e);
            throw new DaoException("Failed to find by login user");
        }
    }

    @Override
    public List<User> findAll(Connection connection) throws DaoException {
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
            logger.error("Failed to find all users", e);
            throw new DaoException("Failed to find all users");
        }
    }

    @Override
    public void setAdminRole(int id, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_UPDATE_ADMIN_ROLE)) {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            logger.error("Failed to update admin role", e);
            throw new DaoException("Failed to update admin role");
        }
    }

    @Override
    public void setUserRole(int id, Connection connection) throws DaoException {
        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY_UPDATE_USER_ROLE)) {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            logger.error("Failed to update user role", e);
            throw new DaoException("Failed to update user role");
        }
    }
}
