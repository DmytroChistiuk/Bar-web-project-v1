package com.javafx.exampl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLUtil {

        private static final String URL="jdbc:mysql://localhost:3306/note";
        private static final String PASSWORD="root";
        private static final String USERNAME="root";
        public static Connection getConnection() throws SQLException, ClassNotFoundException {
            try{
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch ( ClassNotFoundException e){
                e.printStackTrace();

            }

            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }
    }

