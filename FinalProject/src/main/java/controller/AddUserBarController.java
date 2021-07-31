package controller;

import entity.Cocktail;
import entity.User;
import entity.UserBar;
import service.CocktailService;
import service.UserBarService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddUserBarController implements Controller {
    private UserService userService = new UserService();
    private CocktailService cocktailService = new CocktailService();
    private UserBarService userBarService = new UserBarService();


    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {

            String cocktailId = req.getParameter("cocktailId");
            Cocktail cocktail = cocktailService.getById(Integer.parseInt(cocktailId));
            Integer userId = (Integer) req.getSession().getAttribute("userId");
            User user = userService.getById(userId);
            userBarService.addCocktail(user.getId(), cocktail);
            List<Cocktail> cocktails = cocktailService.findAll();
            req.setAttribute("cocktails", cocktails);

            return new ControllerResultDto("cocktails");
        } catch (Exception e) {
            return new ControllerResultDto("error-500");
        }
    }
}


