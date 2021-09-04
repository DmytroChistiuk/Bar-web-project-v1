package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
/**
 * Defines all methods that will be used in Controllers
 */
public interface Controller {
    ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException;

}
