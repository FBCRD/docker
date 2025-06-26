package org.sis.controller.Cartao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.sis.dao.CartaoDao;
import org.sis.dao.UsuarioDao;
import org.sis.model.Cartao;
import org.sis.model.GrupoCartao;
import org.sis.model.Usuario;
import org.sis.service.CartaoService;

import java.io.IOException;
@WebServlet("cadastrarCartao")
public class CadastraCartao extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id = Integer.parseInt(req.getParameter("idcartao"));

            String nome = req.getParameter("nome_cartao");
            String grupo = req.getParameter("opt");
            GrupoCartao gc = null;
            switch (grupo) {
                case "1":
                    gc = GrupoCartao.GRUPO_1;
                    break;
                case "2":
                    gc = GrupoCartao.GRUPO_2;
                    break;
                case "3":
                    gc = GrupoCartao.GRUPO_3;
                    break;
                case "4":
                    gc = GrupoCartao.GRUPO_4;
                    break;
                case "5":
                    gc = GrupoCartao.GRUPO_5;
                    break;
                default:
                    System.out.println("Erro ao escolher grupo");
                    break;
            }
            System.out.println("Grupo" + grupo);

            HttpSession sessao = req.getSession(true);
            Usuario usuario = null;
            Cartao cartao = new Cartao();
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
        if (id>0){
            System.out.println("atualizar cartao");
            RequestDispatcher rd =
                    req.getRequestDispatcher("recarregar");
            if (new CartaoService().editar(new CartaoDao().getcartao(id), nome, gc)){
                req.setAttribute("retorno", "Cartao editado com sucesso");
            }
            else {
                req.setAttribute("retorno", "Erro ao editar cartao");
            }
            rd.forward(req, resp);
        }else{

            Usuario user = new UsuarioDao().getusuario(id_user);
            cartao = new Cartao(nome, gc, user, 0);
            System.out.println("saiu");

            // Se ocorrer tudo bem vai levar novamente a mesma pagina

            RequestDispatcher rd =
                    req.getRequestDispatcher("recarregar");
            if (new CartaoService().inserir(cartao)) {
                req.setAttribute("retorno", "Cartao salvo com sucesso");
            } else {
                req.setAttribute("retorno", "O usuario ja tem um cartão deste tipo cadastrado");
            }
            rd.forward(req, resp);
        }
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = null;
        System.out.println("opção: " + req.getParameter("opcao"));
        HttpSession sessao = req.getSession(false);
        Usuario usuario = null;
        String editar = null;
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
        String opcao = req.getParameter("opcao");
        if (opcao != null) {

            if (opcao.equals("excluir")) {

                int id = Integer.parseInt(req.getParameter("id_cartao"));
                new CartaoService().deletar(id);
                req.setAttribute("retorno", "Cartao EXCLUÍDO com SUCESSO");
                req.setAttribute("cartoes", new CartaoDao().getCartoes2(id_user));
                rd = req.getRequestDispatcher("WEB-INF/pages/CadastraCartao.jsp");

            } else if (opcao.equals("recarregar")) {
                int id = Integer.parseInt(req.getParameter("id_cartao"));
                rd = req.getRequestDispatcher("WEB-INF/pages/Pagamento.jsp");

            } else if (opcao.equals("editar")) {
                int id = Integer.parseInt(req.getParameter("id_cartao"));
                Cartao cartao = new CartaoDao().getcartao(id);
                req.setAttribute("cartao", cartao);
                req.setAttribute("cartoes", new CartaoDao().getCartoes2(id_user));
                rd = req.getRequestDispatcher("WEB-INF/pages/CadastraCartao.jsp");

            }
        }else{
            System.out.println("Null");
        }

        rd.forward(req, resp);
    }
}


