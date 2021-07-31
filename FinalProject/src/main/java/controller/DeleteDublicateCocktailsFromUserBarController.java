package controller;

import entity.Cocktail;
import entity.User;
import service.CocktailService;
import service.UserBarService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class DeleteDublicateCocktailsFromUserBarController implements Controller{
    private UserService userService = new UserService();
    private CocktailService cocktailService = new CocktailService();
    private UserBarService userBarService = new UserBarService();
    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        try {
        String cocktailId = req.getParameter("cocktailId");
        Cocktail cocktail = cocktailService.getById(Integer.parseInt(cocktailId));
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        User user = userService.getById(userId);
        userBarService.deleteDublicateCocktail(cocktail, user);
        req.setAttribute("userBar", userBarService.getUserBar(user.getId()));
        return new ControllerResultDto("mybar");
        } catch (Exception e) {
            return new ControllerResultDto("error-500");
        }
    }
}
