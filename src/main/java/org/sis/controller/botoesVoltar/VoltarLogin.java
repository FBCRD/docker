package org.sis.controller.botoesVoltar;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("Voltarpaglogin")
public class VoltarLogin extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session != null) {
            // Invalide a sessão
            session.invalidate();
        }

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/LoginUsuario.jsp");
        rd.forward(req, resp);
    }
}
