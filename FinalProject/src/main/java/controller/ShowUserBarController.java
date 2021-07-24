package controller;

import entity.Cocktail;
import entity.User;
import service.UserBarService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowUserBarController implements Controller {
    private UserService userService = new UserService();
    private UserBarService userBarService = new UserBarService();
    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        User user = userService.getById(userId);
        req.setAttribute("userBar",userBarService.getUserBar(user.getId()));
       /* User user = userService.getById(1);
        List<Cocktail> cocktails = userBarService.getUserBar(1);
        req.setAttribute("userBar",cocktails);*/
        return new ControllerResultDto("mybar");
    }
}
