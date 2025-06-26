package org.sis.controller.Usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.sis.model.Usuario;
import org.sis.service.Loginservice;

import java.io.IOException;

@WebServlet("login")
public class LoginUsuario extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Usuario usuario = new Loginservice().logar(email,senha);

        HttpSession sessao = req.getSession(true);

        sessao.setAttribute("sessaousuario", usuario);
        sessao.setAttribute("id", sessao.getId());


            RequestDispatcher rd =
                    req.getRequestDispatcher("WEB-INF/pages/Dashboard.jsp");
        if (usuario !=null) {
            req.setAttribute("usuario", usuario);
            System.out.println("usuario: "+usuario.getNome_usuario());

        }else{
            rd = req.getRequestDispatcher("WEB-INF/pages/LoginUsuario.jsp");
            System.out.println("Usuario nulo");
            req.setAttribute("erro", "USUÁRIO OU SENHA INCORRETOS");
        }
            rd.forward(req, resp);
    }
}
