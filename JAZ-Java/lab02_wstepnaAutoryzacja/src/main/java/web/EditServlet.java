package web;

import domain.UserInfo;
import repositories.UserInfoDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")

public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Update Employee</h1>");
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);

        UserInfo user = UserInfoDAO.getUserById(id);

        out.print("<form action='EditServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+user.getId()+"'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+user.getUsername()+"'/></td></tr>");
        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+user.getPassword()+"'/></td></tr>");
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+user.getEmail()+"'/></td></tr>");

        out.print("<tr><td>AccountType:</td><td>");
        out.print("<select name='accountType'>");
        out.print("<option value='0'>0 - admin</option>");
        out.print("<option value='1'>1 - premium</option>");
        out.print("<option value='2'>2 - normal</option>");
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}