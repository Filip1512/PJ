package servlets;

import services.CityService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pogoda")
public class CityServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String city1 = request.getParameter("cityForm");
        printCity(response, city1);

        printCity(response, "Warsaw");
        printCity(response, "Gdansk");
        printCity(response, "Krakow");
        printCity(response, "Wroclaw");
        printCity(response, "Poznan");
        printCity(response, "Lodz");
        printCity(response, "Katowice");

    }


    public void printCity(HttpServletResponse response, String name) throws IOException {
        CityService city = new CityService();
        response.getWriter().println("Miasto: " + city.getCity(name).getName());
        response.getWriter().println(city.getCity(name).getCore().getTemp() + " stopni Celsjusza");
        response.getWriter().println("Cisnienie :" + city.getCity(name).getCore().getPressure() + " hPa");
        response.getWriter().println("Predkosc wiatru: " + city.getCity(name).getWind().getSpeed() + "m/s");
        response.getWriter().println("Zachmurzenie: " + city.getCity(name).getWeather().getDescription());
        response.getWriter().println();
    }
}