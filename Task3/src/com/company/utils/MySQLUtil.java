package com.company.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLUtil {
    private static final String URL="jdbc:mysql://localhost:3306/hw_lesson3";
    private static final String PASSWORD="root";
    private static final String USERNAME="root";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}
