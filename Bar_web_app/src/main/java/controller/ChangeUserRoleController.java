package controller;

import entity.User;
import org.apache.log4j.Logger;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeUserRoleController implements Controller {
    private UserServiceImpl userServiceImpl = new UserServiceImpl();
    private static final Logger logger = Logger.getLogger(ChangeUserRoleController.class);

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String currentUserId = req.getParameter("id");
            User user = userServiceImpl.getById(Integer.parseInt(currentUserId));
            if (user.getRole().equals("admin")) {
                userServiceImpl.setUserRole(user.getId());
                return new ControllerResultDto("success");
            } else {
                userServiceImpl.setAdminRole(user.getId());
                return new ControllerResultDto("success");
            }

        } catch (Exception e) {
            logger.error("Failed to get results from service (set new role to user)", e);
            return new ControllerResultDto("error-500");
        }
    }
}
