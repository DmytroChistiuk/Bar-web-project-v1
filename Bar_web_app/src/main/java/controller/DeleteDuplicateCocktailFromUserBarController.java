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
 * The class realized logic of deleting duplicate of current cocktail from user's bar.
 * The cocktail's id is got by request parameter.
 * The user's id is got by session parameter.
 */
public class DeleteDuplicateCocktailFromUserBarController implements Controller {
    private static final Logger logger = Logger.getLogger(DeleteDuplicateCocktailFromUserBarController.class);
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
            userBarServiceImpl.deleteDuplicateCocktail(cocktail, user);
            req.setAttribute(Constant.userBar, userBarServiceImpl.getUserBar(user.getId()));
            return new ControllerResultDto(Constant.mybar);
        } catch (Exception e) {
            logger.error("Failed to get results from service (delete duplicate cocktail,get user's bar)", e);
            return new ControllerResultDto(Constant.error500);
        }
    }
}
