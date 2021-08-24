package controller;

import entity.Cocktail;
import entity.Ingredient;
import org.apache.log4j.Logger;
import service.CocktailIngredientService;
import service.CocktailService;
import service.IngredientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Objects;

public class CreateCocktailController implements Controller {
    private static final Logger logger = Logger.getLogger(CreateCocktailController.class);
    private CocktailService cocktailService = new CocktailService();
    private IngredientService ingredientService = new IngredientService();
    private CocktailIngredientService cocktailIngredientService = new CocktailIngredientService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String cocktailName = req.getParameter("cocktailName");
            String recipe = req.getParameter("recipe");
            String cocktailType = req.getParameter("cocktailType");
            String cocktailHistory = req.getParameter("cocktailHistory");
            String cocktailIcon = req.getParameter("cocktailIcon");
            String cocktailPhoto = req.getParameter("cocktailPhoto");
            String ingredientsName = req.getParameter("ingredientsName");
            if (!cocktailService.checkCocktailInDatabase(cocktailName)) {
                Cocktail cocktailFromDatabase = cocktailService.create(cocktailName, recipe, cocktailType, cocktailHistory, cocktailIcon, cocktailPhoto);
                if (Objects.isNull(cocktailFromDatabase)) {
                    return new ControllerResultDto("error-403");
                } else {
                    Cocktail cocktail = cocktailService.getByName(cocktailName);
                    for (String ingredient : ingredientsName.split(",")) {
                        if (!ingredientService.checkIngredientInDatabase(ingredient)) {
                            Ingredient ingredientFromDatabase = ingredientService.create(ingredient);
                            if (Objects.isNull(ingredientFromDatabase)) {
                                return new ControllerResultDto("error-403");
                            }
                            Ingredient currentCreatedIngredient = ingredientService.getByName(ingredient);
                            cocktailIngredientService.setChainCocktailIngredient(cocktail.getCocktailId(), currentCreatedIngredient.getIngredientId());
                        } else {
                            Ingredient currentIngredient = ingredientService.getByName(ingredient);
                            cocktailIngredientService.setChainCocktailIngredient(cocktail.getCocktailId(), currentIngredient.getIngredientId());

                        }
                    }
                }
            } else {
                return new ControllerResultDto("cocktailAlreadyInDB");
            }
            return new ControllerResultDto("success");
        } catch (Exception e) {
            logger.error("Failed to get results from service (create cocktail, set chain cocktailID->ingredientID)", e);
            return new ControllerResultDto("error-500");
        }
    }
}