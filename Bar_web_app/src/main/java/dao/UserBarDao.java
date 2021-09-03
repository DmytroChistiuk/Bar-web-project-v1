package dao;

import entity.Cocktail;

import java.sql.Connection;
import java.util.List;

public interface UserBarDao {

    void deleteCocktailFromUserBar(String name, int id, Connection connection) throws DaoException;

    Cocktail addCocktailToUserBar(int id, Cocktail cocktail, Connection connection) throws DaoException;

    List<Cocktail> findAllCocktailByUserBarId(int id, Connection connection) throws DaoException;

    List<Cocktail> findAllCocktailInUserBarByName(String name, Connection connection) throws DaoException;

}
