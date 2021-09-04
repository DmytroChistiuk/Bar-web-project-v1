package dao;

import entity.Cocktail;

import java.sql.Connection;
import java.util.List;
/**
 * Defines all methods that will be used with the entity Cocktail in database.
 */
public interface СocktailDao {
    void deleteCocktail(int id, Connection connection) throws DaoException;

    Cocktail createCocktail(Cocktail cocktail, Connection connection) throws DaoException;

    Cocktail findById(int id, Connection connection) throws DaoException;

    Cocktail findByName(String name, Connection connection) throws DaoException;

    List<Cocktail> findAllCocktails(Connection connection) throws DaoException;
}
