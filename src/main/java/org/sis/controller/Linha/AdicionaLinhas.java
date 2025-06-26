package org.sis.controller.Linha;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.sis.dao.LinhasOnibusDAO;
import org.sis.dao.UsuarioDao;
import org.sis.model.Linhas;
import org.sis.model.Usuario;
import org.sis.service.LinhasService;

import java.io.IOException;

@WebServlet("adicionarLinhas")
public class AdicionaLinhas extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome_linha = req.getParameter("optlinha");
        Linhas linha = null;

        switch (nome_linha){
            case "1":
                linha = Linhas.Linha1;
                break;
            case "2":
                linha = Linhas.Linha2;
                break;
            case "3":
                linha = Linhas.Linha3;
                break;
            case "4":
                linha = Linhas.Linha4;
                break;
            case "5":
                linha = Linhas.Linha5;
                break;
            case "6":
                linha = Linhas.Linha6;
                break;
            case "7":
                linha = Linhas.Linha7;
                break;
            case "8":
                linha = Linhas.Linha8;
                break;
            case "9":
                linha = Linhas.Linha9;
                break;
            case "10":
                linha = Linhas.Linha10;
                break;
            case "11":
                linha = Linhas.Linha11;
                break;
            case "12":
                linha = Linhas.Linha12;
                break;
            case "13":
                linha = Linhas.Linha13;
                break;
            case "14":
                linha = Linhas.Linha14;
                break;
            case "15":
                linha = Linhas.Linha15;
                break;
            case "16":
                linha = Linhas.Linha16;
                break;
            case "17":
                linha = Linhas.Linha17;
                break;
            case "18":
                linha = Linhas.Linha18;
                break;
            case "19":
                linha = Linhas.Linha19;
                break;
            case "20":
                linha = Linhas.Linha20;
                break;
            case "21":
                linha = Linhas.Linha21;
                break;
            case "22":
                linha = Linhas.Linha22;
                break;
            case "23":
                linha = Linhas.Linha23;
                break;
            case "24":
                linha = Linhas.Linha24;
                break;
            case "25":
                linha = Linhas.Linha25;
                break;
            case "26":
                linha = Linhas.Linha26;
                break;
            case "27":
                linha = Linhas.Linha27;
                break;
            case "28":
                linha = Linhas.Linha28;
                break;
            case "29":
                linha = Linhas.Linha29;
                break;
            case "30":
                linha = Linhas.Linha30;
                break;
            case "31":
                linha = Linhas.Linha31;
                break;
            case "32":
                linha = Linhas.Linha32;
                break;
            case "33":
                linha = Linhas.Linha33;
                break;
            case "34":
                linha = Linhas.Linha34;
                break;
            case "35":
                linha = Linhas.Linha35;
                break;
            case "36":
                linha = Linhas.Linha36;
                break;
            case "37":
                linha = Linhas.Linha37;
                break;
            case "38":
                linha = Linhas.Linha38;
                break;
            default:
                System.out.println("Erro ao escolher linha");
                break;
        }
        System.out.println("Linha: "+linha.getNomeLinha());
        HttpSession sessao = req.getSession(false);
        Usuario usuario = null;

        int id_user = -1;

        if (sessao != null){
            usuario = (Usuario) sessao.getAttribute("sessaousuario");
            String sessaoId = (String) sessao.getAttribute("id");
            if (usuario != null){
                id_user = usuario.getId_usuario();
            }else{
                System.out.println("Erro no usuario em AdicionaLinhas");
            }
        }else {
            System.out.println("Erro na sessao");
        }

        Usuario user = new UsuarioDao().getusuario(id_user);
        RequestDispatcher rd =
                req.getRequestDispatcher("Tabela");
        if (new LinhasService().inserir(user, linha)){
            req.setAttribute("retornoTabela", "Linha adicionada a sua lista");
        }else{
            req.setAttribute("retornoTabela", "Erro ao adicionar");
        }
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = null;
        String opcao = req.getParameter("opcao");
        if (opcao!=null){
            if (opcao.equals("excluir")){
                int id = Integer.parseInt(req.getParameter("idLinha"));
                new LinhasService().excluir(id);
                req.setAttribute("linhas", new LinhasOnibusDAO().getLinhas());
                req.setAttribute("retornoTabela", "Linha excluida com sucesso");
                rd = req.getRequestDispatcher("Tabela");
            }
        }else{
            System.out.println("opcao nula");
        }
        rd.forward(req, resp);
    }
}