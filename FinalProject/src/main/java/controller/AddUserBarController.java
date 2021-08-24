package controller;

import entity.Cocktail;
import entity.User;
import entity.UserBar;
import org.apache.log4j.Logger;
import service.CocktailService;
import service.UserBarService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddUserBarController implements Controller {
    private static final Logger logger = Logger.getLogger(AddUserBarController.class);
    private UserService userService = new UserService();
    private CocktailService cocktailService = new CocktailService();
    private UserBarService userBarService = new UserBarService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String cocktailId = req.getParameter("cocktailId");
            Cocktail cocktail = cocktailService.getById(Integer.parseInt(cocktailId));
            Integer userId = (Integer) req.getSession().getAttribute("userId");
            User user = userService.getById(userId);
            userBarService.addCocktail(user.getId(), cocktail);
            return new ControllerResultDto("allCocktails", true);
        } catch (Exception e) {
            logger.error("Failed to get results from service (add cocktail to user's bar)", e);
            return new ControllerResultDto("error-500");
        }
    }
}


