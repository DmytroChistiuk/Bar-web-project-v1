package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
    ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp);

}
