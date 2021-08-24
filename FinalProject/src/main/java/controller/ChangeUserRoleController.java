package controller;

import entity.User;
import org.apache.log4j.Logger;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ChangeUserRoleController implements Controller {
    private UserService userService = new UserService();
    private static final Logger logger = Logger.getLogger(ChangeUserRoleController.class);

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String currentUserId = req.getParameter("id");
            User user = userService.getById(Integer.parseInt(currentUserId));
            if (user.getRole().equals("admin")) {
                userService.setUserRole(user.getId());
                return new ControllerResultDto("success");
            } else {
                userService.setAdminRole(user.getId());
                return new ControllerResultDto("success");
            }

        } catch (Exception e) {
            logger.error("Failed to get results from service (set new role to user)", e);
            return new ControllerResultDto("error-500");
        }
    }
}
