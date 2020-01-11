import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

class MySQLConnUtils {

    // Connect to MySql
    static Connection getMySQLConnection() throws SQLException, ClassNotFoundException{
        String hostName = "localhost";
        String dbName = "learningSql";
        String userName = "root";
        String password = "12345";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws
            SQLException, ClassNotFoundException{
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?useUnicode=true&serverTimezone=UTC";

        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
}
