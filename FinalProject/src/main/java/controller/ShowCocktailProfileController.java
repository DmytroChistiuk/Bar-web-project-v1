package controller;

import entity.Cocktail;
import org.apache.log4j.Logger;
import service.CocktailService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ShowCocktailProfileController implements Controller {
    private static final Logger logger = Logger.getLogger(ShowCocktailProfileController.class);
    private CocktailService cocktailService = new CocktailService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String cocktailId = req.getParameter("cocktailId");
            Cocktail cocktail = cocktailService.getById(Integer.parseInt(cocktailId));
            req.setAttribute("cocktail", cocktail);
            return new ControllerResultDto("cocktailProfile");
        } catch (Exception e) {
            logger.error("Failed to get results from service (get cocktail)", e);
            return new ControllerResultDto("error-500");
        }
    }
}
