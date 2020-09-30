import java.sql.*;

public class UpdateDbDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "martina", "password");
            Statement stat = con.createStatement();
            int numRows = stat.executeUpdate("INSERT INTO `agents`(`AgentId`, `AgtFirstName`, `AgtMiddleInitial`, `AgtLastName`, `AgtBusPhone`, `AgtEmail`, `AgtPosition`, `AgencyId`) VALUES (null,'fred','q','smith','403-555-5555','fred@te.com','agent',1)");
            if (numRows == 0){
                System.out.println("Error");
            }
            else{
                System.out.println("Updated Successfully");
            }
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
