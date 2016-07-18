package gpotes.junitworkshop.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class PersistenceUtil {

    static Connection getDBConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/,");
        } catch (SQLException exception) {

        }
        return connection;
    }
}
