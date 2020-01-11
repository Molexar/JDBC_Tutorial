import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertDataExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{

        //Get a connection
        Connection connection = MySQLConnUtils.getMySQLConnection();

        //Get Statement object
        Statement statement = connection.createStatement();

        String sql = "Insert into Employee (EMP_ID, EMP_NO, EMP_NAME)"
                + " values (7256, 'E7256', 'BROWN') ";

        //Execute statement
        //executeUpdate(String) using for Insert, Update, Delete statement
        int rowCount = statement.executeUpdate(sql);

        System.out.println("Row Count Affected = " + rowCount);
    }
}
