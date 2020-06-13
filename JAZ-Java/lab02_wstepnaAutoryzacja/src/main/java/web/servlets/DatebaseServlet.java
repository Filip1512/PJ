package web.servlets;

import datebase.Connect;
import datebase.CreateTable;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DatebaseServlet", urlPatterns = {"datebase"})
public class DatebaseServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Connect connect = new Connect();
        CreateTable create = new CreateTable();
        connect.getGonnection();
        create.create();
        response.sendRedirect("/");
    }

}