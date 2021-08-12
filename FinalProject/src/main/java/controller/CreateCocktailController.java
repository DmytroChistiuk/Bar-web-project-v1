package controller;

import entity.Cocktail;
import service.CocktailService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Objects;

public class CreateCocktailController implements Controller {
    CocktailService cocktailService = new CocktailService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String cocktailName = req.getParameter("cocktailName");
        String recipe = req.getParameter("recipe");
        String cocktailType = req.getParameter("cocktailType");
        String cocktailHistory = req.getParameter("cocktailHistory");
        Cocktail cocktail = cocktailService.create(cocktailName, recipe, cocktailType, cocktailHistory);
        if (Objects.isNull(cocktail)) {
            return new ControllerResultDto("error-403");
        } else {
            return new ControllerResultDto("addCocktail");
        }
    }
}
