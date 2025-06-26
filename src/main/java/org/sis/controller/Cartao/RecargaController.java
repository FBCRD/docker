package org.sis.controller.Cartao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.sis.service.CartaoService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("pagPagamento")
public class RecargaController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        Integer id_cartao = (Integer) session.getAttribute("id_cartao");
        float valor = Float.parseFloat(req.getParameter("valor"));
        System.out.println("entou");
        RequestDispatcher rd = req.getRequestDispatcher("recarregar");
        try {
            new CartaoService().recarregar(id_cartao, valor);
        } catch (SQLException e) {
            System.out.println("Erro aki p");
            throw new RuntimeException(e);
        }
        rd.forward(req, resp);
    }
}
