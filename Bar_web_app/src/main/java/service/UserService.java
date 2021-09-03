package service;

import entity.User;

import java.util.List;

public interface UserService {
    User createNewUser(String name, String surname, String login, String password) throws ServiceException;

    User getByUserLogin(String username) throws ServiceException;

    User getById(int id) throws ServiceException;

    List<User> findAll() throws ServiceException;

    void setAdminRole(int id) throws ServiceException;

    void setUserRole(int id) throws ServiceException;

}
