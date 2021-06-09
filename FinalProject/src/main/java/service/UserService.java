package service;

import dao.UserDAO;
import entity.User;

import java.sql.SQLException;

public class UserService {

    private UserDAO userDao = new UserDAO();

    public User getByUserName(String username) {
        try {
            return UserDAO.findByName(username);
        } catch (SQLException e) {
            System.out.println("Failed to find");
            return null;
        }
    }
}
