package controller;

import entity.Cocktail;
import entity.Ingredient;
import org.apache.log4j.Logger;
import service.CocktailIngredientServiceImpl;
import service.CocktailServiceImpl;
import service.IngredientServiceImpl;
import util.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
/**
 * The class realized logic of creating new cocktail and adding that cocktail to database.
 * The cocktail's parameters is got by request parameter.
 * Сhecks if the created cocktail exists in the database.
 * Сhecks if the created cocktail's ingredients exist in the database.
 */
public class CreateCocktailController implements Controller {
    private static final Logger logger = Logger.getLogger(CreateCocktailController.class);
    private CocktailServiceImpl cocktailServiceImpl = new CocktailServiceImpl();
    private IngredientServiceImpl ingredientServiceImpl = new IngredientServiceImpl();
    private CocktailIngredientServiceImpl cocktailIngredientServiceImpl = new CocktailIngredientServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String cocktailName = req.getParameter(Constant.cocktailName);
            String recipe = req.getParameter(Constant.recipe);
            String cocktailType = req.getParameter(Constant.cocktailType);
            String cocktailHistory = req.getParameter(Constant.cocktailHistory);
            String cocktailIcon = req.getParameter(Constant.cocktailIcon);
            String cocktailPhoto = req.getParameter(Constant.cocktailPhoto);
            String ingredientsName = req.getParameter(Constant.ingredientsName);
            if (!cocktailServiceImpl.checkCocktailInDatabase(cocktailName)) {
                Cocktail cocktailFromDatabase = cocktailServiceImpl.create(cocktailName, recipe, cocktailType, cocktailHistory, cocktailIcon, cocktailPhoto);
                if (Objects.isNull(cocktailFromDatabase)) {
                    return new ControllerResultDto(Constant.error403);
                } else {
                    Cocktail cocktail = cocktailServiceImpl.getByName(cocktailName);
                    for (String ingredient : ingredientsName.split(",")) {
                        if (!ingredientServiceImpl.checkIngredientInDatabase(ingredient)) {
                            Ingredient ingredientFromDatabase = ingredientServiceImpl.create(ingredient);
                            if (Objects.isNull(ingredientFromDatabase)) {
                                return new ControllerResultDto(Constant.error403);
                            }
                            Ingredient currentCreatedIngredient = ingredientServiceImpl.getByName(ingredient);
                            cocktailIngredientServiceImpl.setChainCocktailIngredient(cocktail.getCocktailId(), currentCreatedIngredient.getIngredientId());
                        } else {
                            Ingredient currentIngredient = ingredientServiceImpl.getByName(ingredient);
                            cocktailIngredientServiceImpl.setChainCocktailIngredient(cocktail.getCocktailId(), currentIngredient.getIngredientId());

                        }
                    }
                }
            } else {
                return new ControllerResultDto(Constant.cocktailAlreadyInDB);
            }
            return new ControllerResultDto(Constant.success);
        } catch (Exception e) {
            logger.error("Failed to get results from service (create cocktail, set chain cocktailID->ingredientID)", e);
            return new ControllerResultDto(Constant.error500);
        }
    }
}