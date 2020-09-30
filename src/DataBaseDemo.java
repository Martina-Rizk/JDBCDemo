import java.sql.*;

public class DataBaseDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "martina", "password");
            Statement stat = con.createStatement();
            ResultSet result = stat.executeQuery("select * from agents");

            ResultSetMetaData rsmd = result.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++){
                System.out.println(rsmd.getColumnName(i) + "\t");
            }

            while (result.next()){
                for(int i = 1; i <= 8; i++){
                    System.out.print(result.getString(i) + "\t");
                }
                System.out.println();
            }
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
