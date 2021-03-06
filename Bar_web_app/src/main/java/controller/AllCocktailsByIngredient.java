package controller;

import entity.Cocktail;
import entity.Ingredient;
import org.apache.log4j.Logger;
import service.CocktailIngredientServiceImpl;
import service.IngredientServiceImpl;
import util.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * The class realized logic of finding all cocktails by current ingredient.
 * The ingredient's id is got by request parameter.
 * The result cocktails sets to session parameter.
 */
public class AllCocktailsByIngredient implements Controller {
    private static final Logger logger = Logger.getLogger(AllCocktailsByIngredient.class);
    private IngredientServiceImpl ingredientServiceImpl = new IngredientServiceImpl();
    private CocktailIngredientServiceImpl cocktailIngredientServiceImpl = new CocktailIngredientServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String ingredientId = req.getParameter(Constant.ingredientId);
            Ingredient ingredient = ingredientServiceImpl.getById(Integer.parseInt(ingredientId));
            List<Cocktail> cocktails = cocktailIngredientServiceImpl.getAllCocktailsByIngredientName(ingredient.getName());
            HttpSession session = req.getSession();
            session.setAttribute(Constant.cocktails, cocktails);
            return new ControllerResultDto(Constant.currentCocktails, true);
        } catch (Exception e) {
            logger.error("Failed to get results from service (get all cocktails by ingredient)", e);
            return new ControllerResultDto(Constant.error500);
        }
    }
}
