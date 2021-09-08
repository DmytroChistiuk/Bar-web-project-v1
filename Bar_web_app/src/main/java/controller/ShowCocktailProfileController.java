package controller;

import entity.Cocktail;
import org.apache.log4j.Logger;
import service.CocktailServiceImpl;
import util.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * The class realized logic of displaying current cocktail's profile.
 * The cocktail's id is got by request parameter.
 * The result will send by respond parameter.
 */
public class ShowCocktailProfileController implements Controller {
    private static final Logger logger = Logger.getLogger(ShowCocktailProfileController.class);
    private CocktailServiceImpl cocktailServiceImpl = new CocktailServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String cocktailId = req.getParameter(Constant.cocktailId);
            Cocktail cocktail = cocktailServiceImpl.getById(Integer.parseInt(cocktailId));
            req.setAttribute(Constant.cocktail, cocktail);
            return new ControllerResultDto(Constant.cocktailProfile);
        } catch (Exception e) {
            logger.error("Failed to get results from service (get cocktail)", e);
            return new ControllerResultDto(Constant.error500);
        }
    }
}
