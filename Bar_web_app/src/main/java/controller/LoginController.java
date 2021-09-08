package controller;

import entity.User;
import org.apache.log4j.Logger;
import service.UserServiceImpl;
import util.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static util.Sha256Encryption.getSha256;
/**
 * The class realized logic of login.
 * The user's parameters is got by request parameter.
 * The user's id sets to session parameter.
 */
public class LoginController implements Controller {
    private static final Logger logger = Logger.getLogger(LoginController.class);
    private UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String login = req.getParameter(Constant.login);
            String password = req.getParameter(Constant.password);
            User user = userServiceImpl.getByUserLogin(login);
            if (user.getPassword().equals(getSha256(password))) {
                req.setAttribute(Constant.user, user);
                HttpSession session = req.getSession();
                session.setAttribute(Constant.userId, user.getId());
                return new ControllerResultDto(Constant.profile, true);
            } else {
                return new ControllerResultDto(Constant.error403);
            }
        } catch (Exception e) {
            logger.error("Failed to get results from service (get user)", e);
            return new ControllerResultDto(Constant.error500);
        }
    }
}
