package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repositories.DummyRegistrationRepository;

@WebFilter("/register")
public class RegistrationFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        if (httpRequest.getParameter("registerButton") == null) {
            if (session.getAttribute("userData") == null) {
                ((HttpServletResponse) response).sendRedirect("/register.jsp");
            } else {
                ((HttpServletResponse) response).sendRedirect("/userData.jsp");
            }
        } else {
            String validateResult = validateData(httpRequest);
            if (validateResult.equals("ok")) {
                chain.doFilter(request, response);
            } else {
                request.setAttribute("errorMessage", validateResult);
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        }


    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig arg0) {

    }

    private String validateData(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");
        String email = request.getParameter("email");

        username = username != null ? username.trim() : "";
        password = password != null ? password.trim() : "";
        passwordConfirm = passwordConfirm != null ? passwordConfirm.trim() : "";
        email = email != null ? email.trim() : "";

        if (username.equals("") || password.equals("") || passwordConfirm.equals("") || email.equals("")) {
            return "Uzupełnij wymagane pola";
        }
        if (!password.equals(passwordConfirm)) {
            return "Podane hasła różnią się";
        }
        if (new DummyRegistrationRepository().getRegistrationByLogin(username) != null) {
            return "Użytkownik o takim loginie już istnieje";
        }
        return "Validation ok";
    }
}