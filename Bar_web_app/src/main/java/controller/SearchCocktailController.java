package controller;

import entity.Cocktail;
import org.apache.log4j.Logger;
import service.CocktailServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class SearchCocktailController implements Controller {
    private static final Logger logger = Logger.getLogger(SearchCocktailController.class);
    private CocktailServiceImpl cocktailServiceImpl = new CocktailServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String cocktailName = req.getParameter("cocktailName");
            List<Cocktail> cocktails = new ArrayList<>();
            Cocktail cocktail = cocktailServiceImpl.getByName(cocktailName);
            cocktails.add(cocktail);
            HttpSession session = req.getSession();
            session.setAttribute("cocktails", cocktails);
            return new ControllerResultDto("currentCocktails", true);
        } catch (Exception e) {
            logger.error("Failed to get results from service (get cocktail)", e);
            return new ControllerResultDto("error-500");
        }
    }
}
