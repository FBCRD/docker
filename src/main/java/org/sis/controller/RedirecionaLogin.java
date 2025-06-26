package org.sis.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("paglogin")
public class RedirecionaLogin extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        System.out.println("Pagina de login");

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/LoginUsuario.jsp");
        rd.forward(req, resp);
    }
}
