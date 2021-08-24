package controller;

import entity.Cocktail;
import entity.User;
import org.apache.log4j.Logger;
import service.UserBarService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;


public class ShowUserBarController implements Controller {
    private static final Logger logger = Logger.getLogger(ShowUserBarController.class);
    private UserService userService = new UserService();
    private UserBarService userBarService = new UserBarService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute("userId");
            User user = userService.getById(userId);
            req.setAttribute("userBar", userBarService.getUserBar(user.getId()));

            return new ControllerResultDto("mybar");
        } catch (Exception e) {
            {
                logger.error("Failed to get results from service (get user's bar)", e);
                return new ControllerResultDto("error-500");
            }
        }
    }
}
