package controller;

import entity.User;
import org.apache.log4j.Logger;
import service.UserServiceImpl;
import util.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * The class realized logic of showing current user's profile.
 * The user's id is got by session parameter.
 * If user get admin role, they will redirect to admin profile.
 */
public class ShowUserProfileController implements Controller {
    private static final Logger logger = Logger.getLogger(ShowUserProfileController.class);
    private UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Integer userId = (Integer) req.getSession().getAttribute(Constant.userId);
            User user = userServiceImpl.getById(userId);
            req.setAttribute(Constant.user, user);
            if (user.getRole().equals(Constant.admin)) {
                req.setAttribute(Constant.user, user);
                List<User> users = userServiceImpl.findAll();
                users.remove(user);
                req.setAttribute(Constant.users, users);
                return new ControllerResultDto(Constant.adminProfile);
            }
            return new ControllerResultDto(Constant.profile);
        } catch (Exception e) {
            logger.error("Failed to get results from service (get user/users)", e);
            return new ControllerResultDto(Constant.error500);
        }
    }
}
