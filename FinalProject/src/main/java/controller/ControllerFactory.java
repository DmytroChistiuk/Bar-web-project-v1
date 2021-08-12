package controller;

import controller.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {
    private Map<String, Controller> controllerMap = new HashMap<>();

    private void init() {
        controllerMap.put("GET/profile", new ShowPageController("profile"));
        controllerMap.put("GET/login", new ShowPageController("login"));
        controllerMap.put("GET/main", new ShowPageController("main"));
        controllerMap.put("GET/client", new ShowPageController("login"));
        controllerMap.put("GET/cocktails", new ShowAllCocktailController());
        controllerMap.put("GET/addToUserBar", new AddUserBarController());
        controllerMap.put("GET/deleteFromUserBar", new DeleteFromUserBarController());
        controllerMap.put("GET/deleteDublicatesFromUserBar", new DeleteDublicateCocktailsFromUserBarController());
        controllerMap.put("GET/UserBar", new ShowUserBarController());
        controllerMap.put("GET/register", new ShowPageController("register"));
        controllerMap.put("GET/addCocktail", new ShowPageController("addCocktail"));
        controllerMap.put("GET/cocktailProfile", new ShowCocktailProfileController());
        controllerMap.put("GET/viewCocktailProfile", new ShowCocktailProfileController());

        controllerMap.put("POST/addCocktail", (Controller) new CreateCocktailController());
        controllerMap.put("POST/register", (Controller) new RegisterController());
        controllerMap.put("POST/login", (Controller) new LoginController());

    }

    public Controller getController(HttpServletRequest request) {
        if (controllerMap.isEmpty()) {
            init();
        }

        return controllerMap.get(request.getMethod() + request.getPathInfo());
    }
}
