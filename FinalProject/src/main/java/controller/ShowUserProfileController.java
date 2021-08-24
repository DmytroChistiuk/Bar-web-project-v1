package controller;

import entity.User;
import org.apache.log4j.Logger;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowUserProfileController implements Controller {
    private static final Logger logger = Logger.getLogger(ShowUserProfileController.class);
    private UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Integer userId = (Integer) req.getSession().getAttribute("userId");
            User user = userService.getById(userId);
            req.setAttribute("user", user);
            if (user.getRole().equals("admin")) {
                req.setAttribute("user", user);
                List<User> users = userService.findAll();
                users.remove(user);
                req.setAttribute("users", users);
                return new ControllerResultDto("adminProfile");
            }
            return new ControllerResultDto("profile");
        } catch (Exception e) {
            logger.error("Failed to get results from service (get user/users)", e);
            return new ControllerResultDto("error-500");
        }
    }
}
