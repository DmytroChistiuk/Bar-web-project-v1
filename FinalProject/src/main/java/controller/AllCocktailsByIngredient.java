package controller;

import entity.Cocktail;
import entity.Ingredient;
import org.apache.log4j.Logger;
import service.CocktailIngredientService;
import service.IngredientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AllCocktailsByIngredient implements Controller {
    private static final Logger logger = Logger.getLogger(AllCocktailsByIngredient.class);
    private IngredientService ingredientService = new IngredientService();
    private CocktailIngredientService cocktailIngredientService = new CocktailIngredientService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String ingredientId = req.getParameter("ingredientId");
            Ingredient ingredient = ingredientService.getById(Integer.parseInt(ingredientId));
            List<Cocktail> cocktails = cocktailIngredientService.getAllCocktailsByIngredientName(ingredient.getName());
            HttpSession session = req.getSession();
            session.setAttribute("cocktails", cocktails);
            return new ControllerResultDto("currentCocktails", true);
        } catch (Exception e) {
            logger.error("Failed to get results from service (get all cocktails by ingredient)", e);
            return new ControllerResultDto("error-500");
        }
    }
}
