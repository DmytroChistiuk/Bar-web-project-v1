package util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.SQLException;

/**
 * LoggerConfigurator is used to configure logger from properties file.
 * PropertyConfigurator.configure("here your configure path");
 */
public class LoggerConfigurator {
    private static Logger logger = Logger.getLogger(LoggerConfigurator.class);

    public static void main(String[] args) throws SQLException {

        PropertyConfigurator.configure("H:\\Course\\Bar-web-project\\Bar_web_app\\src\\main\\webapp\\WEB-INF\\log4j.properties");

    }
}
