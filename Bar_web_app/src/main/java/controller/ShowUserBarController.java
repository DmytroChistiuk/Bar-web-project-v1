package controller;

import entity.User;
import org.apache.log4j.Logger;
import service.UserBarServiceImpl;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShowUserBarController implements Controller {
    private static final Logger logger = Logger.getLogger(ShowUserBarController.class);
    private UserServiceImpl userServiceImpl = new UserServiceImpl();
    private UserBarServiceImpl userBarServiceImpl = new UserBarServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute("userId");
            User user = userServiceImpl.getById(userId);
            req.setAttribute("userBar", userBarServiceImpl.getUserBar(user.getId()));

            return new ControllerResultDto("mybar");
        } catch (Exception e) {
            {
                logger.error("Failed to get results from service (get user's bar)", e);
                return new ControllerResultDto("error-500");
            }
        }
    }
}
