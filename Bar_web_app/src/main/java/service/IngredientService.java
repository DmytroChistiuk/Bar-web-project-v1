package service;

import entity.Ingredient;

import java.util.List;
/**
 * Defines all methods that will be used with the entity Ingredient.
 */
public interface IngredientService {
    Ingredient create(String name) throws ServiceException;

    Ingredient getById(int id) throws ServiceException;

    Ingredient getByName(String name) throws ServiceException;

    List<Ingredient> findAll() throws ServiceException;

    boolean checkIngredientInDatabase(String name) throws ServiceException;
}
