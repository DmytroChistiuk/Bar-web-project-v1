package controller;

import entity.Cocktail;
import entity.User;
import org.apache.log4j.Logger;
import service.CocktailServiceImpl;
import service.UserBarServiceImpl;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserBarController implements Controller {
    private static final Logger logger = Logger.getLogger(AddUserBarController.class);
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
            userBarServiceImpl.addCocktail(user.getId(), cocktail);
            return new ControllerResultDto("allCocktails", true);
        } catch (Exception e) {
            logger.error("Failed to get results from service (add cocktail to user's bar)", e);
            return new ControllerResultDto("error-500");
        }
    }
}


