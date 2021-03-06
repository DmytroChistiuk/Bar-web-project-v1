package controller;

import entity.Ingredient;
import org.apache.log4j.Logger;
import service.IngredientServiceImpl;
import util.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * The class realized logic of finding all ingredients which exist in database.
 * The result will send by respond parameter.
 */
public class ShowAllIngredientController implements Controller {
    private static final Logger logger = Logger.getLogger(ShowAllIngredientController.class);
    private IngredientServiceImpl ingredientServiceImpl = new IngredientServiceImpl();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Ingredient> ingredients = ingredientServiceImpl.findAll();
            req.setAttribute(Constant.ingredients, ingredients);
            return new ControllerResultDto(Constant.allIngredients);
        } catch (Exception e) {
            logger.error("Failed to get results from service (find all ingredient)", e);
            return new ControllerResultDto(Constant.error500);
        }
    }
}
