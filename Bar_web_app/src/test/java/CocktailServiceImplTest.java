import dao.CocktailDaoImpl;
import entity.Cocktail;
import org.junit.Test;
import service.CocktailServiceImpl;
import util.ConnectionContext;
import util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class CocktailServiceImplTest {
    @Test
    public void findAll_isFindAllWorked() throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        Connection connection = connectionPool.getConnection();
        CocktailDaoImpl cocktailDAOImpl = mock(CocktailDaoImpl.class);
        CocktailServiceImpl cocktailServiceImpl = new CocktailServiceImpl(cocktailDAOImpl);

        List<Cocktail> testList = new ArrayList<>();
        Cocktail testCocktail1 = new Cocktail();
        testCocktail1.setCocktailId(1);
        testCocktail1.setCocktailName("1");
        testCocktail1.setCocktailType("1");
        testCocktail1.setCocktailHistory("1");
        testCocktail1.setRecipe("1");
        testCocktail1.setCocktailIcon("1");
        testCocktail1.setCocktailPhoto("1");

        when(cocktailDAOImpl.findAllCocktails(any())).thenReturn(testList);
        List<Cocktail> currentList = cocktailServiceImpl.findAll();
        for (Cocktail cocktail : currentList) {
            assertEquals(cocktail.getCocktailId(), testCocktail1.getCocktailId());
            assertEquals(cocktail.getCocktailName(), testCocktail1.getCocktailName());
            assertEquals(cocktail.getCocktailType(), testCocktail1.getCocktailType());
            assertEquals(cocktail.getRecipe(), testCocktail1.getRecipe());
            assertEquals(cocktail.getCocktailIcon(), testCocktail1.getCocktailIcon());
            assertEquals(cocktail.getCocktailPhoto(), testCocktail1.getCocktailPhoto());
        }


    }

    @Test
    public void getById_isCocktailWasFound() throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        Connection connection = connectionPool.getConnection();
        CocktailDaoImpl cocktailDAOImpl = mock(CocktailDaoImpl.class);
        CocktailServiceImpl cocktailServiceImpl = new CocktailServiceImpl(cocktailDAOImpl);

        Cocktail testCocktail = new Cocktail();
        testCocktail.setCocktailId(1);
        testCocktail.setCocktailName("1");
        testCocktail.setCocktailType("2");
        testCocktail.setCocktailHistory("3");
        testCocktail.setRecipe("5");
        testCocktail.setCocktailIcon("6");
        testCocktail.setCocktailPhoto("7");

        when(cocktailDAOImpl.findById(eq(1), any())).thenReturn(testCocktail);
        Cocktail current = cocktailServiceImpl.getById(1);
        assertEquals(testCocktail, current);
    }

    @Test
    public void findAll_isDatabaseUsed() throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        Connection connection = connectionPool.getConnection();
        CocktailDaoImpl cocktailDAOImpl = mock(CocktailDaoImpl.class);
        CocktailServiceImpl cocktailServiceImpl = new CocktailServiceImpl(cocktailDAOImpl);

        List<Cocktail> testList = new ArrayList<>();
        Cocktail testCocktail1 = new Cocktail();
        Cocktail testCocktail2 = new Cocktail();
        Cocktail testCocktail3 = new Cocktail();
        testList.add(testCocktail1);
        testList.add(testCocktail2);
        testList.add(testCocktail3);

        when(cocktailDAOImpl.findAllCocktails(any())).thenReturn(testList);
        cocktailServiceImpl.findAll();
        verify(cocktailDAOImpl, times(1)).findAllCocktails(any());
    }

    @Test
    public void getById_isDatabaseUsed() throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        Connection connection = connectionPool.getConnection();
        CocktailDaoImpl cocktailDAOImpl = mock(CocktailDaoImpl.class);
        CocktailServiceImpl cocktailServiceImpl = new CocktailServiceImpl(cocktailDAOImpl);

        Cocktail testCocktail = new Cocktail();
        testCocktail.setCocktailId(1);
        testCocktail.setCocktailName("1");
        testCocktail.setCocktailType("2");
        testCocktail.setCocktailHistory("3");
        testCocktail.setRecipe("5");
        testCocktail.setCocktailIcon("6");
        testCocktail.setCocktailPhoto("7");

        when(cocktailDAOImpl.findById(eq(1), any())).thenReturn(testCocktail);
        cocktailServiceImpl.getById(1);
        verify(cocktailDAOImpl, times(1)).findById(eq(1), any());
    }

    @Test
    public void delete_isDatabaseUsed() throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        Connection connection = connectionPool.getConnection();
        CocktailDaoImpl cocktailDAOImpl = mock(CocktailDaoImpl.class);
        CocktailServiceImpl cocktailServiceImpl = new CocktailServiceImpl(cocktailDAOImpl);

        Cocktail testCocktail = new Cocktail();
        testCocktail.setCocktailId(1);
        testCocktail.setCocktailName("1");
        testCocktail.setCocktailType("2");
        testCocktail.setCocktailHistory("3");
        testCocktail.setRecipe("5");
        testCocktail.setCocktailIcon("6");
        testCocktail.setCocktailPhoto("7");

        cocktailServiceImpl.delete(1);
        verify(cocktailDAOImpl, times(1)).deleteCocktail(eq(1), any());
    }
}
