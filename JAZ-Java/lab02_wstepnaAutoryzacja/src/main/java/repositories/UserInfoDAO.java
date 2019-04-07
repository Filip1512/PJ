package repositories;

import domain.UserInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDAO {

    public static Connection getConnection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:hsqldb:mem:s16664");
        } catch(Exception e){ System.out.println(e); }
        return con;
    }

    public static int create(UserInfo user){
        int status = 0;
        try{
            Connection con = UserInfoDAO.getConnection();
            PreparedStatement ps=con.prepareStatement
                    ("insert into USERS(username, userpassword, usertype, useremail) values (?,?,2,?)");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getEmail());

            status = ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }

    public static int update(UserInfo user){
        int status=0;
        try{
            Connection con = UserInfoDAO.getConnection();
            PreparedStatement ps=con.prepareStatement
                    ("update USERS set USERNAME=?,USERPASSWORD=?,USERTYPE=?,USEREMAIL=? where id=?");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getAccountType());
            ps.setString(4,user.getEmail());
            ps.setInt(5,user.getId());

            status = ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }

    public static int delete(int id){
        int status=0;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection con = DriverManager.getConnection("jdbc:hsqldb:mem:s16664");
            PreparedStatement ps = con.prepareStatement("delete from USERS where id=?");
            ps.setInt(1,id);
            status = ps.executeUpdate();

            con.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }

    public static UserInfo getUserById(int id){
        UserInfo user = new UserInfo();

        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection con = DriverManager.getConnection("jdbc:hsqldb:mem:s16664");
            PreparedStatement ps=con.prepareStatement("select * from USERS where id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setAccountType(rs.getString(4));
                user.setEmail(rs.getString(5));
            }
            con.close();
        } catch(Exception ex){ ex.printStackTrace(); }

        return user;
    }

    public static List<UserInfo> getAllUsers(){
        List<UserInfo> userlist = new ArrayList<UserInfo>();

        try{
            Connection con = UserInfoDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from USERS");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                UserInfo user = new UserInfo();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setAccountType(rs.getString(4));
                user.setEmail(rs.getString(5));
                userlist.add(user);
            }
            con.close();
        } catch(Exception e){e.printStackTrace();}

        return userlist;
    }

}
