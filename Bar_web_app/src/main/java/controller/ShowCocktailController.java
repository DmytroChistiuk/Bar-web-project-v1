package controller;

import entity.Cocktail;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class ShowCocktailController implements Controller {
    private static final Logger logger = Logger.getLogger(ShowCocktailController.class);

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Cocktail> cocktails = (List<Cocktail>) req.getSession().getAttribute("cocktails");
            req.setAttribute("cocktails", cocktails);
            return new ControllerResultDto("cocktails");
        } catch (Exception e) {
            logger.error("Failed to get session attribute", e);
            return new ControllerResultDto("error-500");
        }
    }
}
