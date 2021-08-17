package controller;

import entity.CocktailIngredients;
import entity.Ingredient;
import service.CocktailIngredientService;
import service.IngredientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class AllCocktailsByIngredient implements Controller {
    private IngredientService ingredientService = new IngredientService();
    private CocktailIngredientService cocktailIngredientService = new CocktailIngredientService();
    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String ingredientId = req.getParameter("ingredientId");
        Ingredient ingredient = ingredientService.getById(Integer.parseInt(ingredientId));
        List<CocktailIngredients> cocktails = cocktailIngredientService.getAllCocktailsByIngredientName(ingredient.getName());
        req.setAttribute("cocktails", cocktails);
        return new ControllerResultDto("cocktailsByIngredient");
    }
}
