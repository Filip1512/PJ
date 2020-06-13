package web.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Users;
import repositories.DummyRegistrationRepository;
import repositories.RegistrationRepository;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Users registration = retrieveRegistrationFromRequest(request);
        RegistrationRepository repository = new DummyRegistrationRepository();
        registration.setPremium(false);
        repository.add(registration);
        response.sendRedirect("login.jsp");

    }

    private Users retrieveRegistrationFromRequest(HttpServletRequest request) {
        Users result = new Users();
        result.setUsername(request.getParameter("name"));
        result.setPassword(request.getParameter("password"));
        result.setEmail(request.getParameter("email"));
        return result;
    }

}