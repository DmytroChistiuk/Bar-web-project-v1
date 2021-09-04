package dao;

import entity.Cocktail;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
/**
 * Defines all methods that will be used with the entity Ingredient and Cocktail simultaneously in database.
 */
public interface CocktailIngredientDao {
    HashMap<String, List<Cocktail>> findAllCocktailsByIngredientName(String name, Connection connection) throws DaoException;

    void create(int cocktailId, int ingredientId, Connection connection) throws DaoException;
}
