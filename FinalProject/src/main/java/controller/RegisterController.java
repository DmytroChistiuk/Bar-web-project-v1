package controller;

import entity.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Objects;

public class RegisterController implements Controller {
    private UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userService.createNewUser(name,surname,login,password);

       if(Objects.isNull(user)) {
           return new ControllerResultDto("error-403");
       }

       else {
        req.setAttribute("user", user);
        return new ControllerResultDto("login");

        }
    }
}


