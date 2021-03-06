package controller;

import entity.User;
import org.apache.log4j.Logger;
import service.UserBarServiceImpl;
import service.UserServiceImpl;
import util.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The class realized logic of finding all cocktails which is in current user's bar, displaying current user's bar profile.
 * The user's id is got by session parameter.
 */
public class ShowUserBarController implements Controller {
    private static final Logger logger = Logger.getLogger(ShowUserBarController.class);
    private UserServiceImpl userServiceImpl = new UserServiceImpl();
    private UserBarServiceImpl userBarServiceImpl = new UserBarServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute(Constant.userId);
            User user = userServiceImpl.getById(userId);
            req.setAttribute(Constant.userBar, userBarServiceImpl.getUserBar(user.getId()));

            return new ControllerResultDto(Constant.mybar);
        } catch (Exception e) {
            {
                logger.error("Failed to get results from service (get user's bar)", e);
                return new ControllerResultDto(Constant.error500);
            }
        }
    }
}
