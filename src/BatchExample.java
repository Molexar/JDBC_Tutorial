import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{

        //Get a connection
        Connection connection = MySQLConnUtils.getMySQLConnection();

        try{
            // Create Statement obj
            Statement statement = connection.createStatement();

            //Set auto-commit to false
            connection.setAutoCommit(false);

            //Create sql statement to insert in Employee table
            String sql1 = "Update Employee set Employee.EMP_ID = Employee.EMP_ID + 100 "
                    + " where Employee.EMP_NO = 'E7839' ";

            //Add above sql statement in the batch
            statement.addBatch(sql1);

            //Create one more SQL statement
            String sql2 = "Insert into Employee(EMP_ID, EMP_NO, EMP_NAME) values (7758, 'E7758', 'BOUNTY')";

            //Add one more SQL statement to the bath
            statement.addBatch(sql2);

            //Execute batch
            int[] counts = statement.executeBatch();

            System.out.println("SQL1 count = " + counts[0]);
            System.out.println("SQL2 count = " + counts[1]);

            //commit changes to database
            connection.commit();

        } catch (Exception e){
            e.printStackTrace();
            connection.rollback();
        }
    }
}
