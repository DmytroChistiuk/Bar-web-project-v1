package controller;

import entity.Ingredient;
import org.apache.log4j.Logger;
import service.IngredientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class ShowAllIngredientsController implements Controller {
    private static final Logger logger = Logger.getLogger(ShowAllIngredientsController.class);
    private IngredientService ingredientService = new IngredientService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Ingredient> ingredients = ingredientService.findAll();
            req.setAttribute("ingredients", ingredients);
            return new ControllerResultDto("allIngredients");
        } catch (Exception e) {
            logger.error("Failed to get results from service (find all ingredient)", e);
            return new ControllerResultDto("error-500");
        }
    }
}
