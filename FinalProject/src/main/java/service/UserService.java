package service;

import dao.UserDAO;
import entity.User;
import org.apache.log4j.Logger;
import util.ConnectionContext;
import util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

import static util.Sha256Encryption.getSha256;

public class UserService {
    private static final Logger loggerService = Logger.getLogger(UserBarService.class);
    private UserDAO userDAO;
    public UserService() {
        userDAO = new UserDAO();
    }

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User createNewUser(String name, String surname, String login, String password) throws SQLException {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setPassword(getSha256(password));
        user.setRole("user");
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return userDAO.createUser(user,connection);
        } catch (SQLException e) {
            loggerService.error("Failed to create new user",e);
        }
        return user;
    }

    public User getByUserLogin(String username) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return userDAO.findByLogin(username,connection);
        } catch (SQLException e) {
            loggerService.error("Failed to get user by login",e);
            return null;
        }
    }

    public User getById(int id) throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        try (Connection connection = connectionPool.getConnection()) {
            return userDAO.findById(id,connection);
        } catch (SQLException e) {
            loggerService.error("Failed to get user by id",e);
            return null;
        }
    }
}

