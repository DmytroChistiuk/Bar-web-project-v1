package controller;

import entity.Ingredient;
import service.IngredientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class ShowAllIngredientsController implements Controller {
    private IngredientService ingredientService = new IngredientService();
    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        List<Ingredient> ingredients = ingredientService.findAll();
        req.setAttribute("ingredients", ingredients);
        return new ControllerResultDto("allIngredients");
    }
}
