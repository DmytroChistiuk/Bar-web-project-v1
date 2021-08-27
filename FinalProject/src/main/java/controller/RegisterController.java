package controller;

import entity.User;
import org.apache.log4j.Logger;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Objects;

public class RegisterController implements Controller {
    private static final Logger logger = Logger.getLogger(RegisterController.class);
    private UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            User user = userService.createNewUser(name, surname, login, password);

            if (Objects.isNull(user)) {
                return new ControllerResultDto("error-403");
            } else {
                req.setAttribute("user", user);
                return new ControllerResultDto("login",true);
            }
        } catch (Exception e) {
            logger.error("Failed to get results from service(create new user)", e);
            return new ControllerResultDto("error-500");
        }
    }
}


