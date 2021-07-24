package test;

import dao.CocktailDAO;
import dao.CocktailIngredientsDAO;
import dao.UserBarDAO;
import dao.UserDAO;
import entity.Cocktail;
import entity.CocktailIngredients;
import entity.User;
import service.CocktailService;
import service.UserBarService;
import service.UserService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static dao.CocktailIngredientsDAO.findAll;
import static dao.CocktailIngredientsDAO.findByCocktailName;



public class Test {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        userService.createNewUser("sa","sa", "s","a");

    }
}
