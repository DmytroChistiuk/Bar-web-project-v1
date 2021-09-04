package dao;

import entity.User;

import java.sql.Connection;
import java.util.List;
/**
 * Defines all methods that will be used with the entity User in database.
 */
public interface UserDao {
    User createUser(User user, Connection connection) throws DaoException;

    User findById(int id, Connection connection) throws DaoException;

    User findByLogin(String login, Connection connection) throws DaoException;

    List<User> findAll(Connection connection) throws DaoException;

    void setAdminRole(int id, Connection connection) throws DaoException;

    void setUserRole(int id, Connection connection) throws DaoException;
}
