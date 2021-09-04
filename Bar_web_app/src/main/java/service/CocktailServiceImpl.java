package service;

import dao.CocktailDaoImpl;
import entity.Cocktail;
import org.apache.log4j.Logger;
import util.ConnectionContext;
import util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * Implementation of CocktailService interface.
 * This class implements all the logic of working with the entity Cocktail.
 * This class work with CocktailDao.
 * In the methods of this class creates connection for transfer to Database.
 */
public class CocktailServiceImpl implements CocktailService {
    private CocktailDaoImpl cocktailDAOImpl;
    private ConnectionPool connectionPool = null;
    private static final Logger logger = Logger.getLogger(CocktailServiceImpl.class);

    public CocktailServiceImpl(CocktailDaoImpl cocktailDAOImpl) {
        this.cocktailDAOImpl = cocktailDAOImpl;
    }

    public CocktailServiceImpl() {
        cocktailDAOImpl = new CocktailDaoImpl();
    }

    @Override
    public void delete(int id) throws ServiceException {

        try {
            connectionPool = ConnectionContext.get();
        } catch (SQLException e) {
            logger.error("Failed to get connection from ConnectionContext", e);
            throw new ServiceException("Failed to get connection from ConnectionContext");
        }
        try (Connection connection = connectionPool.getConnection()) {
            cocktailDAOImpl.deleteCocktail(id, connection);
        } catch (SQLException e) {
            logger.error("Failed to delete cocktail", e);
            throw new ServiceException("Failed to delete cocktail");
        }
    }

    @Override
    public Cocktail create(String cocktailName, String recipe, String cocktailType, String cocktailHistory, String icon, String photo) throws ServiceException {
        Cocktail cocktail = new Cocktail();
        cocktail.setCocktailName(cocktailName);
        cocktail.setRecipe(recipe);
        cocktail.setCocktailType(cocktailType);
        cocktail.setCocktailHistory(cocktailHistory);
        cocktail.setCocktailIcon(icon);
        cocktail.setCocktailPhoto(photo);

        try {
            connectionPool = ConnectionContext.get();
        } catch (SQLException e) {
            logger.error("Failed to get connection from ConnectionContext", e);
            throw new ServiceException("Failed to get connection from ConnectionContext");
        }
        try (Connection connection = connectionPool.getConnection()) {
            return cocktailDAOImpl.createCocktail(cocktail, connection);
        } catch (SQLException e) {
            logger.error("Failed to create cocktail", e);
            throw new ServiceException("Failed to create cocktail");
        }
    }

    @Override
    public Cocktail getById(int id) throws ServiceException {

        try {
            connectionPool = ConnectionContext.get();
        } catch (SQLException e) {
            logger.error("Failed to get connection from ConnectionContext", e);
            throw new ServiceException("Failed to get connection from ConnectionContext");
        }
        try (Connection connection = connectionPool.getConnection()) {
            return cocktailDAOImpl.findById(id, connection);
        } catch (SQLException e) {
            logger.error("Failed to get cocktail by id", e);
            throw new ServiceException("Failed to get cocktail by id");
        }
    }

    @Override
    public Cocktail getByName(String name) throws ServiceException {

        try {
            connectionPool = ConnectionContext.get();
        } catch (SQLException e) {
            logger.error("Failed to get connection from ConnectionContext", e);
            throw new ServiceException("Failed to get connection from ConnectionContext");
        }
        try (Connection connection = connectionPool.getConnection()) {
            return cocktailDAOImpl.findByName(name, connection);
        } catch (SQLException e) {
            logger.error("Failed to get cocktail by name", e);
            throw new ServiceException("Failed to get cocktail by name");
        }
    }

    @Override
    public List<Cocktail> findAll() throws ServiceException {

        try {
            connectionPool = ConnectionContext.get();
        } catch (SQLException e) {
            logger.error("Failed to get connection from ConnectionContext", e);
            throw new ServiceException("Failed to get connection from ConnectionContext");
        }
        try (Connection connection = connectionPool.getConnection()) {
            return cocktailDAOImpl.findAllCocktails(connection);
        } catch (SQLException e) {
            logger.error("Failed to find all cocktails", e);
            throw new ServiceException("Failed to find all cocktails");
        }
    }

    /**
     * This method checks is cocktail exist in database and return true or false.
     * Method is used to prevent duplicates in database.
     * @param name
     * @return
     * @throws ServiceException
     */
    @Override
    public boolean checkCocktailInDatabase(String name) throws ServiceException {
        try {
            List<Cocktail> allCocktails = findAll();
            for (Cocktail cocktail : allCocktails) {
                if (cocktail.getCocktailName().equals(name)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            logger.error("Failed to check is cocktail exist", e);
            throw new ServiceException("Failed to check is cocktail exist");
        }
        return false;
    }
}
