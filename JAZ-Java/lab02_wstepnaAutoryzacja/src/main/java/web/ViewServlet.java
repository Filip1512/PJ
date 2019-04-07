package web;

import domain.UserInfo;
import repositories.UserInfoDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")

public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='index.jsp'>Add New User</a>");
        out.println("<h1>User List</h1>");

        List<UserInfo> list = UserInfoDAO.getAllUsers();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Nick</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th>tal</tr>");
        for(UserInfo user : list){
            out.print("<tr><td>"+user.getId()+"</td>" +
                    "<td>"+user.getUsername()+"</td>" +
                    "<td>"+user.getPassword()+"</td>" +
                    "<td>"+user.getEmail()+"</td>" +
                    "<td>"+user.getAccountType()+"</td>" +
                    "<td><a href='EditServlet?id="+user.getId()+"'>edit</a></td>" +
                    "<td><a href='DeleteServlet?id="+user.getId()+"'>delete</a></td></tr>");
        }
        out.print("</table>");

        out.close();
    }
}