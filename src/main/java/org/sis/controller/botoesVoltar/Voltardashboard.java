package org.sis.controller.botoesVoltar;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.sis.model.Usuario;

import java.io.IOException;
@WebServlet("VoltarpagDash")
public class Voltardashboard extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sessao = req.getSession(false);

        RequestDispatcher rd =
                req.getRequestDispatcher("WEB-INF/pages/Dashboard.jsp");
        rd.forward(req, resp);
    }
}
