package service;

import dao.UserDAO;
import entity.User;
import util.ConnectionContext;
import util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class UserService {

    private UserDAO userDAO = new UserDAO();


    public User createNewUser(String name, String surname, String login, String password) throws SQLException {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setPassword(password);
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return userDAO.createUser(user,connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getByUserLogin(String username) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return userDAO.findByLogin(username,connection);
        } catch (SQLException e) {
            System.out.println("Failed to find");
            return null;
        }
    }

    public User getById(int id) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return userDAO.findById(id,connection);
        } catch (SQLException e) {
            System.out.println("Failed to find");
            return null;
        }
    }
}

