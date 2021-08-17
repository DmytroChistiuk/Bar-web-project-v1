package controller;

import entity.Cocktail;
import service.CocktailService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class SearchCocktailController implements Controller{
private CocktailService cocktailService = new CocktailService();
    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String cocktailName = req.getParameter("cocktailName");
        Cocktail cocktail = cocktailService.getByName(cocktailName);
        req.setAttribute("cocktail", cocktail);
        return new ControllerResultDto("cocktailProfile");
    }
}
