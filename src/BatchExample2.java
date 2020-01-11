import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.UUID;

public class BatchExample2 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{

        // Get a connection
        Connection connection = MySQLConnUtils.getMySQLConnection();

        try{
            String sql = "Insert into Employee (EMP_ID, EMP_NO, EMP_NAME) "
                    + " values (?, ?, ?) ";
            //Create statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //Set auto-commit to false
            connection.setAutoCommit(false);

            //Set values for the ? marks
            preparedStatement.setString(1, "8945");
            preparedStatement.setString(2, "E"+"8945");
            preparedStatement.setString(3, "BRAWN");

            //Add to batch
            preparedStatement.addBatch();

            //Set values
            preparedStatement.setString(1, "6856");
            preparedStatement.setString(2, "E"+"6856");
            preparedStatement.setString(3, "CARTER");

            //Add batch
            preparedStatement.addBatch();

            //Execute batches
            int[] counts = preparedStatement.executeBatch();

            System.out.println("Batch1 :" + counts[0]);
            System.out.println("Batch2 :" + counts[1]);

            //Commit changes to DB
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            connection.rollback();
        }
    }
}
