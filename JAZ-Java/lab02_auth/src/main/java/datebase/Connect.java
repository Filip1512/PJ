package datebase;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    public Connection getGonnection() {
        Connection con = null;

        try {
            Class.forName("org.hsqldb.jdbcDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");

            if (con != null)
            {
                System.out.println("Polaczona z h2/db datebase!");
            }
            else
            {
                System.out.println("Nie polaczono z s16664/db datebase!");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return con;
    }
}