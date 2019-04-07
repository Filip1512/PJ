package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(urlPatterns = "register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String nick = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        try{
            Connection con = DriverManager.getConnection("jdbc:hsqldb:mem:s16664");

            PreparedStatement ps=con.prepareStatement
                    ("insert into USERS values (?,?,?,?)");
            ps.setString(1,nick);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4, "0");

            int i = ps.executeUpdate();
            if(i>0)
                out.print("Zarejestrowano pomyślnie!");

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
