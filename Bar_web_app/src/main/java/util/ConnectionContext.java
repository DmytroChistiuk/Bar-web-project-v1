package util;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * This class give one of the 4 connections from ConnectionPool.
 */
public class ConnectionContext {
    private static ConnectionPool connectionPool;

    public static ConnectionPool get() throws SQLException {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
            connectionPool.init();
        }
        return connectionPool;
    }
}
