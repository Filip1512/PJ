package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        response.getWriter().println("<fieldset>" +
                "<legend>" +
                "<h1 align=\"center\">Harmonogram spłat kredytu</h1>" +
                "</legend>" +
                "<table border=\"1\">" +
                "<tr><td>Numer raty</td><td>Kwota</td></tr>");

        if (rodzajRat.equals("malejaca"))
        {
            for (int numerRaty=1; numerRaty<=iloscRat; numerRaty++)
            {
                double kwotaRaty = ((kwotaKredytu/iloscRat)*(1+(iloscRat-numerRaty+1)*oprocentowanie/12)+oplataStala);
                response.getWriter().println("<tr><td>" + numerRaty + "</td><td>" + Math.round(kwotaRaty * 100.00)/100.00 + " zł");
            }
        }

        if (rodzajRat.equals("stala"))
        {
            for (int numerRaty=1; numerRaty<=iloscRat; numerRaty++)
            {
                double kwotaRaty = (kwotaKredytu*Math.pow(1+(oprocentowanie/12),iloscRat)*oprocentowanie/12)/((Math.pow(1+(oprocentowanie/12),iloscRat)-1));
                response.getWriter().println("<tr><td>" + numerRaty + "</td><td>" + Math.round(kwotaRaty * 100.00)/100.00  + " zł");
            }
        }

        response.getWriter().println("</table></fieldset>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
