package controller;

import entity.Cocktail;
import org.apache.log4j.Logger;
import util.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * The class implements the logic of displaying all cocktails for a given session.
 */
public class ShowCocktailController implements Controller {
    private static final Logger logger = Logger.getLogger(ShowCocktailController.class);

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Cocktail> cocktails = (List<Cocktail>) req.getSession().getAttribute("cocktails");
            req.setAttribute(Constant.cocktails, cocktails);
            return new ControllerResultDto(Constant.cocktails);
        } catch (Exception e) {
            logger.error("Failed to get session attribute", e);
            return new ControllerResultDto(Constant.error500);
        }
    }
}
