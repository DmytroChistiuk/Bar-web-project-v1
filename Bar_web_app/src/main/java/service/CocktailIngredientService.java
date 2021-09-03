package service;

import entity.Cocktail;

import java.sql.SQLException;
import java.util.List;

public interface CocktailIngredientService {
    List<Cocktail> getAllCocktailsByIngredientName(String name) throws SQLException;

    void setChainCocktailIngredient(int cocktailId, int ingredientId) throws SQLException;

}
