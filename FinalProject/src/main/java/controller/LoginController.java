package controller;

import entity.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

import static util.Sha256Encryption.getSha256;

public class LoginController implements Controller {
    private UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userService.getByUserLogin(login);

        if(user.getPassword().equals(getSha256(password))) {
            req.setAttribute("user", user);
            HttpSession session = req.getSession();
            session.setAttribute("userId", user.getId());
            if(user.getRole().equals("user")){
            return new ControllerResultDto("profile");
            }
            else {
                return new ControllerResultDto("adminProfile");
            }
        } else {
            return new ControllerResultDto("error-403");
        }
    }
}
