package controller;

import entity.Cocktail;
import org.apache.log4j.Logger;
import service.CocktailServiceImpl;
import util.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * The class realized logic of finding all cocktails which exist in database.
 * The result cocktails sets to session parameter.
 */
public class FindAllCocktailController implements Controller {
    private static final Logger logger = Logger.getLogger(FindAllCocktailController.class);
    private CocktailServiceImpl cocktailServiceImpl = new CocktailServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Cocktail> cocktails = cocktailServiceImpl.findAll();
            HttpSession session = req.getSession();
            session.setAttribute(Constant.cocktails, cocktails);
            return new ControllerResultDto(Constant.currentCocktails, true);
        } catch (Exception e) {
            logger.error("Failed to get results from service (find all cocktails)", e);
            return new ControllerResultDto(Constant.error500);
        }
    }
}
