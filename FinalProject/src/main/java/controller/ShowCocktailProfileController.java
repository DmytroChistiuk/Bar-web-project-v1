package controller;

import entity.Cocktail;
import service.CocktailService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ShowCocktailProfileController implements Controller{
    CocktailService cocktailService = new CocktailService();
    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String cocktailId = req.getParameter("cocktailId");
        Cocktail cocktail = cocktailService.getById(Integer.parseInt(cocktailId));
        req.setAttribute("cocktail", cocktail);
        return new ControllerResultDto("cocktailProfile");
    }
}
