package service;

import dao.UserDAO;
import entity.User;

import java.sql.SQLException;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public User createNewUser(String name, String surname, String login, String password) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setPassword(password);
        try {
            return userDAO.createUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
return null;
    }

        public User getByUserLogin(String username) {
            try {
                return userDAO.findByLogin(username);
            } catch (SQLException e) {
                System.out.println("Failed to find");
                return null;
            }
        }
    public User getById(int id) {
        try {
            return userDAO.findById(id);
        } catch (SQLException e) {
            System.out.println("Failed to find");
            return null;
        }
    }
    }

