import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
    static Connection getMyConnection() throws SQLException, ClassNotFoundException{
        return MySQLConnUtils.getMySQLConnection();
    }
    //
    //Test connection
    //
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Get connection..");

        // Get connection object
        Connection conn = getMyConnection();

        System.out.println("Get connection " + conn);

        System.out.println("Done");
    }
}
