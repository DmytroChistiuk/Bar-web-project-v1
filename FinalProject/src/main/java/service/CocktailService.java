package service;

import dao.CocktailDAO;
import entity.Cocktail;

import java.sql.SQLException;
import java.util.List;

public class CocktailService {
    private CocktailDAO cocktailDAO = new CocktailDAO();

    public Cocktail getById(int id) {
        try {
            return cocktailDAO.findById(id);
        } catch (SQLException e) {
            System.out.println("Failed to find");
            return null;
        }
    }

    public List<Cocktail> findAll() {
        try {
           return cocktailDAO.findAllCocktails();
        } catch (SQLException e) {
            System.out.println("Failed to find");
            return null;
        }
    }
}
