package service;

import dao.UserDAO;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
UserDAO user = new UserDAO();
System.out.println(user.findByLogin("123"));

    }
}
