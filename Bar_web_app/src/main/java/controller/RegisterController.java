package controller;

import entity.User;
import org.apache.log4j.Logger;
import service.UserServiceImpl;
import util.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
/**
 * The class realized logic of creating new user.
 * The user's parameters is got by request parameter.
 * The password will be encrypt by Sha256.
 */
public class RegisterController implements Controller {
    private static final Logger logger = Logger.getLogger(RegisterController.class);
    private UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String name = req.getParameter(Constant.name);
            String surname = req.getParameter(Constant.surname);
            String login = req.getParameter(Constant.login);
            String password = req.getParameter(Constant.password);
            User user = userServiceImpl.createNewUser(name, surname, login, password);

            if (Objects.isNull(user)) {
                return new ControllerResultDto(Constant.error403);
            } else {
                req.setAttribute(Constant.user, user);
                return new ControllerResultDto(Constant.login,true);
            }
        } catch (Exception e) {
            logger.error("Failed to get results from service(create new user)", e);
            return new ControllerResultDto(Constant.error500);
        }
    }
}


