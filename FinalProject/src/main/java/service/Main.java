package service;

import dao.UserDAO;
import entity.User;

import java.sql.SQLException;

import static dao.UserDAO.*;

public class Main {

    public static void main(String[] args) throws SQLException {
UserDAO user = new UserDAO();
System.out.println(user.findByName("123"));

    }
}
