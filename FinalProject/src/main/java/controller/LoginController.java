package controller;

import entity.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {
    private UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userService.getByUserLogin(login);

        if(user.getPassword().equals(password)) {
            req.setAttribute("user", user);
            return new ControllerResultDto("profile");
        } else {
            return new ControllerResultDto("error-403");
        }
    }
}