package datebase;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    public Connection getGonnection() {
        Connection con = null;

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:mem:localhost/db", "", "");

            if (con != null)
            {
                System.out.println("Connected to s16664/db datebase!");
            }
            else
            {
                System.out.println("Not connected to s16664/db datebase!");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return con;
    }
}