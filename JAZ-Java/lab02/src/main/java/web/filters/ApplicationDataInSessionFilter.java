package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/add")
public class ApplicationDataInSessionFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        if(session.getAttribute("conf") != null)
        {
            response.getWriter().println("Twoje zgłoszenie zostało już wysłane.");
            return;
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
