import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class QueryDataExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //Get connection
        Connection connection = ConnectionUtils.getMyConnection();

        //Create statement
        Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

        String sql = "Select EMP_ID, EMP_NO, EMP_NAME from Employee";

        // Execute SQL statement return ResultSet obj
        ResultSet rs = statement.executeQuery(sql);

        //Fetch the ResultSet
        // Moving the cursor throw ResultSet
        while (rs.next()){
            int empId = rs.getInt(1);
            String empNo = rs.getString(2);
            String empName = rs.getString(3);
            System.out.println("------------------------");
            System.out.println("EmpId:" + empId);
            System.out.println("EmpNo:" + empNo);
            System.out.println("EmpName:" + empName);
        }

        // close connection
        connection.close();
    }
}
