package repositories;

import domain.UserInfo;
import java.sql.*;

public class LoginDAO {
    public static boolean validate(String nick, String password) {
        boolean status = false;

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection con = DriverManager.getConnection("jdbc:hsqldb:mem:s16664");
            PreparedStatement ps = con.prepareStatement
                    ("select * from USERS where USERNAME=? and USERPASSWORD=?");
            ps.setString(1,nick);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }


    return status;
    }
}