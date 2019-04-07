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

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String nick = request.getParameter("name");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String accountType=request.getParameter("accountType");

        UserInfo user = new UserInfo();
        user.setId(id);
        user.setUsername(nick);
        user.setPassword(password);
        user.setEmail(email);
        user.setAccountType(accountType);

        int status = UserInfoDAO.update(user);
        if(status>0){
            response.sendRedirect("ViewServlet");
        }else{
            out.println("Nie można zaktualizować rekordu...");
        }

        out.close();
    }

}