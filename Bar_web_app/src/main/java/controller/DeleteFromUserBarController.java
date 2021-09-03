package controller;

import entity.Cocktail;
import entity.User;
import org.apache.log4j.Logger;
import service.CocktailServiceImpl;
import service.UserBarServiceImpl;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFromUserBarController implements Controller {
    private static final Logger logger = Logger.getLogger(DeleteFromUserBarController.class);
    private UserServiceImpl userServiceImpl = new UserServiceImpl();
    private CocktailServiceImpl cocktailServiceImpl = new CocktailServiceImpl();
    private UserBarServiceImpl userBarServiceImpl = new UserBarServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String cocktailId = req.getParameter("cocktailId");
            Cocktail cocktail = cocktailServiceImpl.getById(Integer.parseInt(cocktailId));
            Integer userId = (Integer) req.getSession().getAttribute("userId");
            User user = userServiceImpl.getById(userId);
            userBarServiceImpl.deleteCocktail(cocktail, user);
            req.setAttribute("userBar", userBarServiceImpl.getUserBar(user.getId()));
            return new ControllerResultDto("mybar");
        } catch (Exception e) {
            logger.error("Failed to get results from service (delete cocktail, get user's bar)", e);
            return new ControllerResultDto("error-500");
        }
    }
}
