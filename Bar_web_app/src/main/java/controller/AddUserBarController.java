package controller;

import entity.Cocktail;
import entity.User;
import org.apache.log4j.Logger;
import service.CocktailServiceImpl;
import service.UserBarServiceImpl;
import service.UserServiceImpl;
import util.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The class realized logic of adding current cocktail to current user's bar.
 * The cocktail's id is got by request parameter.
 * The user's id is got by session parameter.
 */
public class AddUserBarController implements Controller {
    private static final Logger logger = Logger.getLogger(AddUserBarController.class);
    private UserServiceImpl userServiceImpl = new UserServiceImpl();
    private CocktailServiceImpl cocktailServiceImpl = new CocktailServiceImpl();
    private UserBarServiceImpl userBarServiceImpl = new UserBarServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String cocktailId = req.getParameter(Constant.cocktailId);
            Cocktail cocktail = cocktailServiceImpl.getById(Integer.parseInt(cocktailId));
            Integer userId = (Integer) req.getSession().getAttribute(Constant.userId);
            User user = userServiceImpl.getById(userId);
            userBarServiceImpl.addCocktail(user.getId(), cocktail);
            return new ControllerResultDto(Constant.allCocktails, true);
        } catch (Exception e) {
            logger.error("Failed to get results from service (add cocktail to user's bar)", e);
            return new ControllerResultDto(Constant.error500);
        }
    }
}


