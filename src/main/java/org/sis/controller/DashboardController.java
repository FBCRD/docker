package org.sis.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.sis.dao.CartaoDao;
import org.sis.dao.LinhasOnibusDAO;
import org.sis.dao.UsuarioDao;
import org.sis.model.Usuario;

import java.io.IOException;
@WebServlet("dashboard")
public class DashboardController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcao = req.getParameter("opcao");
        HttpSession sessao = req.getSession(false);
        Usuario usuario = null;

        int id_user = -1;

        if (sessao != null) {
            usuario = (Usuario) sessao.getAttribute("sessaousuario");
            String sessaoId = (String) sessao.getAttribute("id");
            if (usuario != null) {
                id_user = usuario.getId_usuario();
            } else {
                System.out.println("erro no usuario");
            }
        } else {
            System.out.println("Erro na sessao");
        }

        Usuario user = new UsuarioDao().getusuario(id_user);
        RequestDispatcher rd = null;
        switch (opcao){
            case "cartao":
                req.setAttribute("cartoes", new CartaoDao().getCartoes2(id_user));
                rd = req.getRequestDispatcher("WEB-INF/pages/CadastraCartao.jsp");
                break;
            case "linhas":
                req.setAttribute("linhas", new LinhasOnibusDAO().getLinhas2(id_user));
                rd = req.getRequestDispatcher("WEB-INF/pages/Linhas.jsp");
                break;
            default:
                System.out.println("Erro ao selecionar pagina");
                break;
        }
        rd.forward(req, resp);
    }
}
