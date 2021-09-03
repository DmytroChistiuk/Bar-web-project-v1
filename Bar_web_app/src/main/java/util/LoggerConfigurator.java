package util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.SQLException;


public class LoggerConfigurator {
    private static Logger logger = Logger.getLogger(LoggerConfigurator.class);

    public static void main(String[] args) throws SQLException {
        //PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure("H:\\Course\\hillelCourse\\FinalProject\\src\\main\\webapp\\WEB-INF\\log4j.properties");

    }
}

