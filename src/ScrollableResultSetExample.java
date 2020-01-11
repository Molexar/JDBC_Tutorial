import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class ScrollableResultSetExample{
    public static void main(String[] args) throws SQLException, ClassNotFoundException{

        // Get a Connection
        Connection connection = MySQLConnUtils.getMySQLConnection();

        //Create a Statement
        //that is can be scrolled, but no sensitive to changes under DB
        //ResultSet is readOnly
        Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );


        String sql = "Select EMP_ID, EMP_NO, EMP_NAME from Employee";

        //Execute statement, return ResultSet object
        ResultSet rs = statement.executeQuery(sql);

        //Jump the cursor to last record
        boolean last = rs.last();
        System.out.println("last :" + last);

        if (last){
            // Print Data of last record
            System.out.println("EmpId:" + rs.getInt(1));
            System.out.println("EmpNo:" + rs.getString(2));
            System.out.println("EmpName:" + rs.getString(3));
        }

        System.out.println("------------------");

        //Move cursor to previous record
        boolean previous = rs.previous();
        System.out.println("Previous :" + previous);
        boolean previous2 = rs.previous();
        System.out.println("Previous2 :" + previous2);

        // Fetch in the ResultSet
        while (rs.next()){
            //Get Value of column 2
            String empNo = rs.getString(2);

            //Get value of column 1
            int empId = rs.getInt(1);

            //Get value of column 3
            String empName = rs.getString("EMP_NAME");

            System.out.println("--------------------");
            System.out.println("EmpId:" + empId);
            System.out.println("EmpNo:" + empNo);
            System.out.println("EmpName:" + empName);
        }

        // Close connection
        connection.close();
    }
}
