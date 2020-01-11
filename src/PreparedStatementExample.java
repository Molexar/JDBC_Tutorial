import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{

        // Get a connection
        Connection connection = MySQLConnUtils.getMySQLConnection();

        //Create a SQL statement with two parameters (?)
        String sql = "Select Employee.EMP_ID, Employee.EMP_NO, Employee.EMP_NAME from Employee "
                + "where Employee.EMP_NAME like ? and Employee.EMP_ID = ? ";

        //Create a PreparedStatement object.
        PreparedStatement pstm = connection.prepareStatement(sql);

        //Set value for the first parameter (First '?')
        pstm.setString(1, "BL%");

        // Set value for the second parameter
        pstm.setInt(2, 7698);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()){
            System.out.println(" ---- ");
            System.out.println("EmpId : " + rs.getInt("EMP_ID"));
            System.out.println("EmpNo : " + rs.getString(2));
            System.out.println("EmpName : " + rs.getString("EMP_NAME"));
        }

        System.out.println();
        System.out.println("Set other parameters ..");

        //Reuse PreparedStatement
        //Set other values
        pstm.setString(1, "KI%");
        pstm.setInt(2, 7839);

        //Execute statement
        rs = pstm.executeQuery();

        while (rs.next()) {
            System.out.println(" ---- ");
            System.out.println("EmpId : " + rs.getInt("EMP_ID"));
            System.out.println("EmpNo : " + rs.getString(2));
            System.out.println("EmpName : " + rs.getString("EMP_NAME"));
        }
    }
}
