package web;

import repositories.LoginDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String nick = request.getParameter("username");
        String password = request.getParameter("password");

        if(LoginDAO.validate(nick,password)) {
            RequestDispatcher redirect = request.getRequestDispatcher("loggedInServlet");
            redirect.forward(request, response);
        }
        else{
            out.print("Podane dane są nieprawidlowe");
            RequestDispatcher redirect = request.getRequestDispatcher("index.jsp");
            redirect.include(request, response);
        }

        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

    }

}
