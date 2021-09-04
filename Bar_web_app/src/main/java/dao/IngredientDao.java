package dao;

import entity.Ingredient;

import java.sql.Connection;
import java.util.List;
/**
 * Defines all methods that will be used with the entity Ingredient in database.
 */
public interface IngredientDao {
    Ingredient createIngredient(Ingredient ingredient, Connection connection) throws DaoException;

    Ingredient findById(int id, Connection connection) throws DaoException;

    Ingredient findByName(String name, Connection connection) throws DaoException;

    List<Ingredient> findAllIngredients(Connection connection) throws DaoException;

}
