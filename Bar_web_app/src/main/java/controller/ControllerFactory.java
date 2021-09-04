package controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * The class operate with requests and its controllers.
 */
public class ControllerFactory {
    /**
     * HashMap consist:
     * key - GET/POST/PUT request
     * object - Controller which processes request
     */
    private Map<String, Controller> controllerMap = new HashMap<>();

    /**
     * Method to initiated all request and controllers.
     */
    private void init() {
        controllerMap.put("GET/login", new ShowPageController("login"));
        controllerMap.put("GET/register", new ShowPageController("register"));
        controllerMap.put("GET/addCocktail", new ShowPageController("addCocktail"));
        controllerMap.put("GET/allCocktails", new FindAllCocktailController());
        controllerMap.put("GET/currentCocktails", new ShowCocktailController());
        controllerMap.put("GET/addToUserBar", new AddUserBarController());
        controllerMap.put("GET/deleteFromUserBar", new DeleteFromUserBarController());
        controllerMap.put("GET/deleteDublicatesFromUserBar", new DeleteDuplicateCocktailFromUserBarController());
        controllerMap.put("GET/UserBar", new ShowUserBarController());
        controllerMap.put("GET/viewCocktailProfile", new ShowCocktailProfileController());
        controllerMap.put("GET/allIngredients", new ShowAllIngredientController());
        controllerMap.put("GET/SearchCocktailsByIngredient", new AllCocktailsByIngredient());
        controllerMap.put("GET/profile", new ShowUserProfileController());
        controllerMap.put("GET/changeRole", new ChangeUserRoleController());

        controllerMap.put("POST/currentCocktails", new SearchCocktailController());
        controllerMap.put("POST/addCocktail", (Controller) new CreateCocktailController());
        controllerMap.put("POST/register", (Controller) new RegisterController());
        controllerMap.put("POST/login", (Controller) new LoginController());


    }
    /**
     * The method returns the request and its controller.
     * If controllerMap is empty call method init.
     */
    public Controller getController(HttpServletRequest request) {
        if (controllerMap.isEmpty()) {
            init();
        }
        return controllerMap.get(request.getMethod() + request.getPathInfo());
    }
}
