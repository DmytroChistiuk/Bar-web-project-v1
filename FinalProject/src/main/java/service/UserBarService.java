package service;

import dao.UserBarDAO;
import entity.Cocktail;

import java.sql.SQLException;
import java.util.List;

public class UserBarService {
   private UserBarDAO userBarDAO = new UserBarDAO();
    public Cocktail addCocktail(int id, Cocktail cocktail) {
        try {
            return userBarDAO.addCocktailToUserBar(id,cocktail);
        } catch (SQLException e) {
            System.out.println("Failed to add");
            return null;
        }
    }

    public List<Cocktail> getUserBar(int id) {
        try {
            return userBarDAO.findAllCocktailByUserBarId(id);
        } catch (SQLException e) {
            System.out.println("Failed to find");
            return null;
        }
    }
}
