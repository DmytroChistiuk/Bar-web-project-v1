package dao;

import entity.Cocktail;

import java.sql.Connection;
import java.util.List;
/**
 * Defines all methods that will be used with the entity UserBar in database.
 */
public interface UserBarDao {

    void deleteCocktailFromUserBar(String name, int id, Connection connection) throws DaoException;

    Cocktail addCocktailToUserBar(int id, Cocktail cocktail, Connection connection) throws DaoException;

    List<Cocktail> findAllCocktailByUserBarId(int id, Connection connection) throws DaoException;

    List<Cocktail> findAllCocktailInUserBarByName(String name, Connection connection) throws DaoException;

}
