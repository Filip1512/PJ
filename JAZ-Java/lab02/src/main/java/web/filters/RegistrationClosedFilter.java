package web.filters;

import repositories.DummyConferenceApplicationRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter( urlPatterns = "/", servletNames = "AddApplicantServlet")
public class RegistrationClosedFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        int iloscZapisanychOsob = new DummyConferenceApplicationRepository().count();

        if(iloscZapisanychOsob >= 5)
        {
            response.getWriter().println("Rejestracja na konferencje już się zakończyła.");
            response.getWriter().println("Ilość zapisanych osób: " + iloscZapisanychOsob);
            return;
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
