import java.sql.*;

public class CallableStatementExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        // Get a connection
        Connection connection = MySQLConnUtils.getMySQLConnection();

        String sql = "{call get_Employee_Info(?, ?, ?)}";

        // Create a CallableStatement obj
        CallableStatement cstm = connection.prepareCall(sql);

        //Set parameter value for first question mark
        // Emp(ID)
        cstm.setInt(1, 7839);

        //Register the OUT Parameter for 2nd ? mark
        //Emp(Emp_No)
        cstm.registerOutParameter(2, Types.VARCHAR);

        //Register the out parameter for third ? mark
        cstm.registerOutParameter(3, Types.VARCHAR);

        //execute statement
        cstm.executeUpdate();

        String empNo = cstm.getString(2);
        String emp_last_name = cstm.getString(3);

        System.out.println("Emp_No :" + empNo);
        System.out.println("Emp_last_name :" + emp_last_name);


    }
}
