import java.sql.Connection;
import java.sql.SQLException;

public class TransactionExample {

    private static void doJob1(Connection conn){
        //Todo smth here
    }

    private static void doJob2(Connection conn){
        //Todo smth here
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //Get a connection
        Connection conn = MySQLConnUtils.getMySQLConnection();

        //Set auto-commit to false
        conn.setAutoCommit(false);

        try{
            //Do smth related to the db
            doJob1(conn);
            doJob2(conn);

            //Commit statements to apply changes
            conn.commit();
        } catch (Exception e){
            e.printStackTrace();

            //Rollback changes
            conn.rollback();
        }
        conn.close();
    }
}
