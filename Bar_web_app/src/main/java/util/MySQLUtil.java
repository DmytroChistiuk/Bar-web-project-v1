package util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * This class is used as properties to connect MySQL Database via using jdbs driver.
 * The class has a constant fields with URL,PASSWORD,USERNAME.
 */
public class MySQLUtil {
    private static final Logger logger = Logger.getLogger(MySQLUtil.class);
    private static final String URL = "jdbc:mysql://localhost:3306/Barproject";
    private static final String PASSWORD = "root";
    private static final String USERNAME = "root";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("Failed to upload jdbc driver");

        }

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
