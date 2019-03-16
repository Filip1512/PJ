import org.junit.Test;
import org.mockito.Mockito;
import servlets.HarmonogramServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestHarmonogramServlet extends Mockito {

    @Test
    public void servlet_should_not_greet_the_user_if_the_kwotaKredytu_is_null() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HarmonogramServlet servlet = new HarmonogramServlet();

        when(request.getParameter("kwotaKredytu")).thenReturn(null);

        servlet.doPost(request, response);

        verify(response).sendRedirect("/");
    }

    @Test
    public void servlet_should_not_greet_the_user_if_the_kwotaKredytu_is_empty() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HarmonogramServlet servlet = new HarmonogramServlet();

        when(request.getParameter("kwotaKredytu")).thenReturn("");

        servlet.doPost(request, response);

        verify(response).sendRedirect("/");
    }

    @Test
    public void servlet_should_greet_the_user_when_the_kwotaKredytu_is_provided() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);

        when(request.getParameter("kwotaKredytu")).thenReturn("Passed");
        when(response.getWriter()).thenReturn(writer);

        new HarmonogramServlet().doPost(request, response);

        verify(writer).println("<h1>Hello<h1>");
    }
}
