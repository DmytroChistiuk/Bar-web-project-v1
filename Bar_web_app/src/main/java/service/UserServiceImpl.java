package service;

import dao.UserDaoImpl;
import entity.User;
import org.apache.log4j.Logger;
import util.ConnectionContext;
import util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static util.Sha256Encryption.getSha256;

public class UserServiceImpl implements UserService {
    private static final Logger logger = Logger.getLogger(UserBarServiceImpl.class);
    private UserDaoImpl userDaoImpl;
    private ConnectionPool connectionPool = null;

    public UserServiceImpl() {
        userDaoImpl = new UserDaoImpl();
    }

    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public User createNewUser(String name, String surname, String login, String password) throws ServiceException {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setPassword(getSha256(password));
        user.setRole("user");
        try {
            connectionPool = ConnectionContext.get();
        } catch (SQLException e) {
            logger.error("Failed to get connection from ConnectionContext", e);
            throw new ServiceException("Failed to get connection from ConnectionContext");
        }
        try (Connection connection = connectionPool.getConnection()) {
            return userDaoImpl.createUser(user, connection);
        } catch (SQLException e) {
            logger.error("Failed to create new user", e);
            throw new ServiceException("Failed to create new user");
        }
    }

    @Override
    public User getByUserLogin(String username) throws ServiceException {
        try {
            connectionPool = ConnectionContext.get();
        } catch (SQLException e) {
            logger.error("Failed to get connection from ConnectionContext", e);
            throw new ServiceException("Failed to get connection from ConnectionContext");
        }
        try (Connection connection = connectionPool.getConnection()) {
            return userDaoImpl.findByLogin(username, connection);
        } catch (SQLException e) {
            logger.error("Failed to get user by login", e);
            throw new ServiceException("Failed to get user by login");
        }
    }

    @Override
    public User getById(int id) throws ServiceException {
        try {
            connectionPool = ConnectionContext.get();
        } catch (SQLException e) {
            logger.error("Failed to get connection from ConnectionContext", e);
            throw new ServiceException("Failed to get connection from ConnectionContext");
        }
        try (Connection connection = connectionPool.getConnection()) {
            return userDaoImpl.findById(id, connection);
        } catch (SQLException e) {
            logger.error("Failed to get user by id", e);
            throw new ServiceException("Failed to get user by id");
        }
    }

    @Override
    public List<User> findAll() throws ServiceException {
        try {
            connectionPool = ConnectionContext.get();
        } catch (SQLException e) {
            logger.error("Failed to get connection from ConnectionContext", e);
            throw new ServiceException("Failed to get connection from ConnectionContext");
        }
        try (Connection connection = connectionPool.getConnection()) {
            return userDaoImpl.findAll(connection);
        } catch (SQLException e) {
            logger.error("Failed to get all users", e);
            throw new ServiceException("Failed to get all users");
        }
    }

    @Override
    public void setAdminRole(int id) throws ServiceException {
        try {
            connectionPool = ConnectionContext.get();
        } catch (SQLException e) {
            logger.error("Failed to get connection from ConnectionContext", e);
            throw new ServiceException("Failed to get connection from ConnectionContext");
        }
        try (Connection connection = connectionPool.getConnection()) {
            userDaoImpl.setAdminRole(id, connection);
        } catch (SQLException e) {
            logger.error("Failed to set admin role", e);
            throw new ServiceException("Failed to set admin role");
        }
    }

    @Override
    public void setUserRole(int id) throws ServiceException {
        try {
            connectionPool = ConnectionContext.get();
        } catch (SQLException e) {
            logger.error("Failed to get connection from ConnectionContext", e);
            throw new ServiceException("Failed to get connection from ConnectionContext");
        }
        try (Connection connection = connectionPool.getConnection()) {
            userDaoImpl.setUserRole(id, connection);
        } catch (SQLException e) {
            logger.error("Failed to set user role", e);
            throw new ServiceException("Failed to set user role");
        }
    }
}

