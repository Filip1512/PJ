package web.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Users;
import repositories.DummyRegistrationRepository;

@WebServlet("/acp")
public class AdminPanelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("saveData") != null) {
            request.getParameterMap();
            String[] loginList = request.getParameterValues("username");
            String[] checkedList = request.getParameterValues("isPremium") != null ? request.getParameterValues("isPremium") : new String[0];
            try {
                new DummyRegistrationRepository().updatePremiumStatus(loginList, checkedList);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        List<Users> userList = new DummyRegistrationRepository().getAllUsersData();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/acp.jsp").forward(request, response);
    }


}