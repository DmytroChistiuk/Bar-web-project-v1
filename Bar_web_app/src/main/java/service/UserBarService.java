package service;

import entity.Cocktail;
import entity.User;

import java.util.List;

public interface UserBarService {
    Cocktail addCocktail(int id, Cocktail cocktail) throws ServiceException;
    List<Cocktail> getUserBar(int id) throws ServiceException;
    Cocktail deleteCocktail(Cocktail cocktail, User user) throws ServiceException;
    Cocktail deleteDuplicateCocktail(Cocktail cocktail, User user) throws ServiceException;
}
