package test;

import dao.UserDAO;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import service.UserService;
import util.ConnectionContext;
import util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;


import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private UserService userService;
    private UserDAO userDAO;
    @Before
    public void init() throws SQLException {
        userDAO = mock(UserDAO.class);
    }

    @Test
    public void createUser_wasUserCreatedInService() throws SQLException {
        User user1 = new User();
        user1.setName("Mikhail");
        user1.setSurname("Fitcher");
        user1.setLogin("123");
        user1.setPassword("321");
        User user2 = userService.createNewUser("Mikhail","Fitcher","123","321");

        assertEquals(user1,user2);


    }

    @Test
    public void createUser_wasUserCreatedInDatabase() throws SQLException {
        User user1 = new User();
        user1.setName("Mikhail");
        user1.setSurname("Fitcher");
        user1.setLogin("123");
        user1.setPassword("321");
        ConnectionPool connectionPool = ConnectionContext.get();
        Connection connection = connectionPool.getConnection();
        when(userDAO.createUser(user1,connection)).thenReturn(user1);
        userService.createNewUser("Mikhail","Fitcher","123","321");
        verify(userDAO, times(1)).createUser(user1,connection);

    }
    @Test
    public void getById_calledSeveralTime() throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        Connection connection = connectionPool.getConnection();
        User user1 = new User();
        user1.setId(1);
        user1.setName("Mikhail");
        user1.setSurname("Fitcher");
        user1.setLogin("123");
        user1.setPassword("321");
        User user2 = new User();
        user2.setId(2);
        user2.setName("Denis");
        user2.setSurname("Klever");
        user2.setLogin("123");
        user2.setPassword("321");

        when(userDAO.findById(eq(1),connection)).thenReturn(user1);
        when(userDAO.findById(eq(2),connection)).thenReturn(user2);

        User currentUser1 = userService.getById(1);
        User currentUser2 = userService.getById(2);

        assertEquals(user1, currentUser1);
        assertEquals(user2, currentUser2);
    }
    public void getByLogin_calledSeveralTime() throws SQLException {
        ConnectionPool connectionPool = ConnectionContext.get();
        Connection connection = connectionPool.getConnection();
        User user1 = new User();
        user1.setId(1);
        user1.setName("Mikhail");
        user1.setSurname("Fitcher");
        user1.setLogin("11111");
        user1.setPassword("321");
        User user2 = new User();
        user2.setId(2);
        user2.setName("Denis");
        user2.setSurname("Klever");
        user2.setLogin("22222");
        user2.setPassword("321");

        when(userDAO.findByLogin(eq("11111"),connection)).thenReturn(user1);
        when(userDAO.findByLogin(eq("22222"),connection)).thenReturn(user2);
        User currentUser1 = userService.getByUserLogin("11111");
        User currentUser2 = userService.getByUserLogin("22222");

        assertEquals(user1.getName(),currentUser1.getName());
        assertEquals(user1.getSurname(),currentUser1.getSurname());
        assertEquals(user1.getLogin(),currentUser1.getLogin());
        assertEquals(user1.getPassword(),currentUser1.getPassword());

        assertEquals(user2.getName(),currentUser2.getName());
        assertEquals(user2.getSurname(),currentUser2.getSurname());
        assertEquals(user2.getLogin(),currentUser2.getLogin());
        assertEquals(user2.getPassword(),currentUser2.getPassword());

    }
}
