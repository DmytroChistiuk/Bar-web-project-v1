package service;

import entity.Cocktail;

import java.sql.SQLException;
import java.util.List;
/**
 * Defines all methods that will be used with the entity Cocktail and Ingredient in the same time.
 */
public interface CocktailIngredientService {
    List<Cocktail> getAllCocktailsByIngredientName(String name) throws SQLException;

    void setChainCocktailIngredient(int cocktailId, int ingredientId) throws SQLException;

}
