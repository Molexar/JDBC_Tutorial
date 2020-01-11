import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSimplify {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Connection connection = MySQLConnUtils.getMySQLConnection();

        Statement statement = connection.createStatement();

        int rows = statement.executeUpdate(sqls.Insert.insert("Employee", sqls.Insert.setFields("EMP_ID", "EMP_NO", "EMP_NAME"),
                sqls.Insert.setValues("7854", "E7854", "BOND")));

        System.out.println("rows :" + rows);
    }
}
