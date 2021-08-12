package util;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class Main {
        static Logger logger = Logger.getLogger(Main.class);
        public static void main(String[] args)
        {
            //PropertiesConfigurator is used to configure logger from properties file
            PropertyConfigurator.configure("H:\\Course\\hillelCourse\\FinalProject\\src\\main\\webapp\\WEB-INF\\log4j.properties");
            //Log in log file
            logger.info("test");
        }
    }

