package service;

import dao.UserDAO;
import entity.User;

import java.sql.SQLException;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public User getByUserName(String username) {
        try {
            return userDAO.findByName(username);
        } catch (SQLException e) {
            System.out.println("Failed to find");
            return null;
        }
    }
}
