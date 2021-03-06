package controller;

import entity.Cocktail;
import org.apache.log4j.Logger;
import service.CocktailServiceImpl;
import util.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
/**
 * The class realized logic of searching cocktail by name.
 * The cocktail's name is got by request parameter.
 * The result cocktail sets to session parameter.
 */
public class SearchCocktailController implements Controller {
    private static final Logger logger = Logger.getLogger(SearchCocktailController.class);
    private CocktailServiceImpl cocktailServiceImpl = new CocktailServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String cocktailName = req.getParameter(Constant.cocktailName);
            List<Cocktail> cocktails = new ArrayList<>();
            Cocktail cocktail = cocktailServiceImpl.getByName(cocktailName);
            cocktails.add(cocktail);
            HttpSession session = req.getSession();
            session.setAttribute(Constant.cocktails, cocktails);
            return new ControllerResultDto(Constant.currentCocktails, true);
        } catch (Exception e) {
            logger.error("Failed to get results from service (get cocktail)", e);
            return new ControllerResultDto(Constant.error500);
        }
    }
}
