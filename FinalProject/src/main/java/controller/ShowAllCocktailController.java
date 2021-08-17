package controller;

import dao.CocktailDAO;
import entity.Cocktail;
import service.CocktailService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;


public class ShowAllCocktailController implements Controller {
  private CocktailService cocktailService = new CocktailService();
    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
      List<Cocktail> cocktails = cocktailService.findAll();
       req.setAttribute("cocktails", cocktails);
        return new ControllerResultDto("cocktails");
    }
}
