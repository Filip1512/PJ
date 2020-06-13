package datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable{
    private static Boolean tableExists = false;

    public void create(){
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");

            if(!tableExists) {
                Statement stmt = con.createStatement();
                Statement stmt1 = con.createStatement();
                stmt.executeUpdate(
                        "CREATE TABLE users (id INT NOT NULL AUTO_INCREMENT, username varchar(30), password  varchar(30), email varchar(60), isAdmin bit, isPremium bit)");
                stmt1.executeUpdate(
                        "INSERT INTO users VALUES ('1','admin','admin','admin@admin.pl',true,true)");
                tableExists = true;
            }
        }  catch (Exception e) {
            e.printStackTrace(System.out);
        }
        System.out.println("Table created successfully");
    }
}

