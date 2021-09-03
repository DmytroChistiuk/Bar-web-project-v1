package controller;

import entity.User;
import org.apache.log4j.Logger;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowUserProfileController implements Controller {
    private static final Logger logger = Logger.getLogger(ShowUserProfileController.class);
    private UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Integer userId = (Integer) req.getSession().getAttribute("userId");
            User user = userServiceImpl.getById(userId);
            req.setAttribute("user", user);
            if (user.getRole().equals("admin")) {
                req.setAttribute("user", user);
                List<User> users = userServiceImpl.findAll();
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
