<%@ page import="org.sis.model.Usuario" %><%-- Created by IntelliJ IDEA. User: FABRI Date: 03/06/2024 Time: 21:21 To change this template use File | Settings |
    File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <style>
        .container {
            background-color: white;
            color: black;
            font-family: Arial, Helvetica, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .div_cadastro {
            background-color: #DEDEDE;
            width: 1000px;
            height: 500px;
            display: flex;
            margin-top: auto;
            margin-bottom: auto;
            margin-left: auto;
            margin-right: auto;
            border-radius: 10px;
        }

        .orange_div {
            background-color: #F58220;
            width: 310px;
            height: 500px;
            border-radius: 10px;
        }

        .cad {
            margin: auto;
            display: grid;

        }

        img {
            position: relative;
            right: 100px;


        }

        .stp {
            padding: 50px;
            color: white;

        }

        .botao {
            border-radius: 10px;
            padding: 10px;
            background-color: black;
            border-style: none;
            color: white;
            cursor: pointer;
        }

        .caixaforms {
            border-radius: 5px;
            padding: 5px;
            border: none;
            margin: auto;
            width: 300px;

        }

        ._200 {
            width: 211%;

        }

        .rowforms {
            margin-bottom: 5px;


        }

        .rowforms2 {
            margin-bottom: 5px;
            display: grid;
            grid-template-columns: 100px 200px;
            justify-content: space-between;


        }



        h1 {
            font-size: 40px;
            padding-bottom: 20px;
        }

        .sla {
            font-size: 10px;
        }

        .red-hat-display {
            font-family: "Red Hat Display", sans-serif;
            font-optical-sizing: auto;
            margin: auto;
            font-style: normal;
        }

        .botaologout {
            margin-right: 10px;
            margin-top: 10px;
        }

        .botaovoltar {
            margin-left: 20px;
            margin-top: 10px;
        }

        th,
        td {
            border: solid 1px;
            font-size: 12px;
            margin: 0px;
        }

        table {
            border-collapse: collapse;
            background-color: white;

        }


    </style>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
            href="https://fonts.googleapis.com/css2?family=Red+Hat+Display:ital,wght@0,300..900;1,300..900&display=swap"
            rel="stylesheet">
</head>

<body class="red-hat-display">
<div class="container">
    <div class="div_cadastro">


        <form class="botaovoltar" action="VoltarpagDash" method="post">
            <input type="submit" class="botao" value="Voltar">
        </form>
        <div class="cad">

            <form action="cadastrarCartao" method="Post">
                    <c:choose>
                    <c:when test="${cartao != null}">
                        <h1 class="red-hat-display">Editar cartao</h1>
                        <input type="hidden" name="idcartao" value="${cartao.id_cartao}"/>
                    </c:when>
                    <c:otherwise>
                        <h1 class="red-hat-display">Cadastrar cartao</h1>
                        <input type="hidden" name="idcartao" value="0"/>
                    </c:otherwise>
                    </c:choose>
                <div>
                    <label for="nome">
                        Nome:
                    </label>
                    <input type="text" class="caixaforms" id="nome_cartao" name="nome_cartao"
                           value="${cartao.nome_cartao}" required>
                    <label for="options">
                        Tipo de cartão:
                    </label>
                    <select class="caixaforms" name="opt" id="opt" >
                        <option selected>Selecione o tipo</option>
                        <option value="1">Idoso</option>
                        <option value="2">Estudante</option>
                        <option value="3">Empresa</option>
                        <option value="4">Cidadão</option>
                        <option value="5">Operario</option>
                    </select>


                    <input type="submit" class="botao" value="Cadastrar">
                    <c:if test="${not empty retorno}">
                        <p>${retorno}</p>
                    </c:if>

                </div>
            </form>
            <h3>Cartoes</h3>
            <table>
                <th>Nome</th>
                <th>Grupo do Cartão</th>
                <th>Código do Cartão</th>
                <th>Saldo</th>
                <th>Opcao</th>
                <c:forEach var="cartao1" items="${cartoes}">
                    <c:choose>
                        <c:when test="${cartao1.grupoCartao.nome_grupo=='Idoso'}">
                            <tr>
                                <td>${cartao1.nome_cartao}</td>
                                <td>${cartao1.grupoCartao.nome_grupo}</td>
                                <td>${cartao1.id_cartao}</td>
                                <td>Passe livre</td>
                                <td>
                                    <a
                                            href="cadastrarCartao?opcao=excluir&&id_cartao=${cartao1.id_cartao}">Excluir</a>

                                    <a
                                            href="cadastrarCartao?opcao=editar&&id_cartao=${cartao1.id_cartao}">Editar</a>
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td>${cartao1.nome_cartao}</td>
                                <td>${cartao1.grupoCartao.nome_grupo}</td>
                                <td>${cartao1.id_cartao}</td>
                                <td>R$ ${cartao1.saldo}</td>
                                <td>
                                    <a
                                            href="cadastrarCartao?opcao=excluir&&id_cartao=${cartao1.id_cartao}">Excluir</a>

                                    <a
                                            href="cadastrarCartao?opcao=recarregar&&id_cartao=${cartao1.id_cartao}">Recarregar</a>

                                    <a
                                            href="cadastrarCartao?opcao=editar&&id_cartao=${cartao1.id_cartao}">
                                        Editar
                                    </a>
                                </td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </table>
        </div>
        <form class="botaologout" action="Voltarpaglogin" method="post">
            <input type="submit" class="botao" value="Log-out">
        </form>
    </div>
</div>


</body>

</html>