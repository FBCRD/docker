package org.sis.controller.Usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.sis.model.Usuario;
import org.sis.service.UsuarioService;


import java.io.IOException;



@WebServlet("CadastraServlet") //Chamada para este metodo
public class CadastraUsuario extends HttpServlet{

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        //Faz o requerimento dos parametros do formulario e armazena

        String email = req.getParameter("email");
        String nome_usuario = req.getParameter("nome_usuario");
        String senha = req.getParameter("senha");
        String cpf = req.getParameter("cpf");
        String endereco = req.getParameter("endereco");
        String telefone = req.getParameter("telefone");
        String dt_nasc = req.getParameter("dt_nasc");

        //Cria um novo usuario e atraves do construtor registra o usuario na classe
        Usuario usuario = new Usuario(nome_usuario, email, senha, dt_nasc,endereco,telefone, cpf);

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/LoginUsuario.jsp");

        // Se ocorrer tudo bem com o programa, vai para a pagina login
        if (new UsuarioService().inserir(usuario)>0){
            req.setAttribute("retorno", "Usuario salvo com sucesso");
        }else {
            req.setAttribute("retorno", "Erro ao salvar o usuario");
        }
        rd.forward(req, resp);
    }



}
