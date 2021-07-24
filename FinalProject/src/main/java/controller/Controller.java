package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public interface Controller {
    ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException;

}
