import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {

    private static final String URL="jdbc:mysql://localhost:3306/spark6";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    public static void main(String[] args) {

        try {
           // Class.forName("com.mysql.cj.jdbc.Driver"); //1.7

            Connection con= DriverManager.getConnection(URL,USERNAME,PASSWORD);//java spec

            System.out.println("Database connected successfully");
            con.close();
        }
       catch (Exception e)
       {
           e.printStackTrace();
       }

    }
}
