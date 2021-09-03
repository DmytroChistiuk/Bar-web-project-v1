package util;

import java.sql.Connection;
import java.sql.SQLException;

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
