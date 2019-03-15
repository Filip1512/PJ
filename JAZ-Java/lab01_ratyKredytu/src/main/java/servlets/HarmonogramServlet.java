package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/harmonogram.jsp")
public class HarmonogramServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kwotaKredytuS = request.getParameter("kwotaKredytu");
        String iloscRatS = request.getParameter("iloscRat");
        String oprocentowanieS = request.getParameter("oprocentowanie");
        String oplataStalaS = request.getParameter("oplataStala");
        String rodzajRat = request.getParameter("rodzajRat");

        double kwotaKredytu = Double.parseDouble(kwotaKredytuS);
        double iloscRat = Double.parseDouble(iloscRatS);
        double oprocentowanie = Double.parseDouble(oprocentowanieS);
        double oplataStala = Double.parseDouble(oplataStalaS);

        response.setContentType("text/html");
        response.getWriter().println(kwotaKredytuS);
        response.getWriter().println(kwotaKredytu);
        response.getWriter().println(rodzajRat);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
