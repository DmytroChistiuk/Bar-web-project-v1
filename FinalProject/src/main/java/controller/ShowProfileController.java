package controller;

import entity.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ShowProfileController implements Controller {
    private UserService userService = new UserService();
    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        User user = userService.getById(userId);
        req.setAttribute("login",user.getLogin());
        req.setAttribute("password", user.getPassword());
        return new ControllerResultDto("profile");
    }
}
