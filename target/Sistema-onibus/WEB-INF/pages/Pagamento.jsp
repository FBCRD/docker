<%-- Created by IntelliJ IDEA. User: FABRI Date: 03/06/2024 Time: 20:47 To change this template use File | Settings |
    File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<% HttpSession session1=request.getSession(); int
        id_cartao1=Integer.parseInt(request.getParameter("id_cartao")); session1.setAttribute("id_cartao",
        id_cartao1); %>
<!DOCTYPE html>
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
            margin-top: 70px;
        }

        img {
            position: relative;
            right: 100px;

        }

        h2 {
            padding: 20px;
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

        .sectionforms {
            display: flex;
            flex-direction: column;
            margin-right: 20px;
            margin-bottom: 10px;
        }

        h1 {
            font-size: 30px;
        }

        .sla {
            font-size: 10px;
        }

        .red-hat-display {
            font-family: "Red Hat Display", sans-serif;
            font-optical-sizing: auto;
            font-style: normal;
        }

        .tipodecartao {
            margin: 10px;
            margin-top: 40px;

        }

        .intercart {
            margin-right: auto;
            margin-top: 80px;
        }

        .botaologout {
            margin-right: 20px;
            margin-top: 10px;
        }

        .botaovoltar {
            margin-left: 20px;
            margin-top: 10px;
        }

        .inputs {
            margin-bottom: 10px;
        }

        #interfaceCartao {
            display: none;
        }

        #interfacePix {
            display: none;
        }

        .divLinhas {
            margin: auto;
            text-align: center;
        }

        .interpix {
            margin: auto;


        }

        .img {
            margin-bottom: 10px;
            margin-left: 200px;
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
        <form class="botaovoltar" action="Voltarpagcartao" method="post">
            <input type="submit" class="botao" value="Voltar">
        </form>
        <div class="cad">
            <form action="pagPagamento" method="post">
                <h1 class="red-hat-display">Selecione a forma de pagamento</h1>
                <div>
                    <div>
                        <label for="tipodecartao">Selecione a forma de pagamento:</label>
                        <select name="opcao" id="opcao" onchange="mostrarInterface()">
                            <option selected>Selecione</option>
                            <option value="CartaoCred">Cartão Crédito</option>
                            <option value="CartaoDeb">Cartão Débito</option>
                            <option value="Pix">Pix</option>
                        </select>
                    </div>
                    <br>
                    <div>
                        <label for="valor">Valor:</label>
                        <input class="caixaforms" type="number" name="valor" id="valor"
                               placeholder="R$0.00">
                    </div>

                </div>

                <c:if test="${not empty erro}">
                <h2>${erro}</h2>
                </c:if>
        </div>
        <div class="divLinhas">
            <div id="interfacePix" class=" intercart">
                <h1 class="red-hat-display">PIX</h1>
                <div class="img">
                    <img src="img/frame.png">
                </div>
                <div>
                    <input type="submit" class="botao" value="Confirmar">
                </div>
            </div>
            <div id="interfaceCartao" class="sectionforms intercart">
                <h1 class="red-hat-display">Cartao</h1>

                <label for="">Número do Cartão: </label>
                <div class="inputs">
                    <input class="caixaforms" type="text" name="" id="" required>
                </div>
                <label for="">CVV:</label>
                <div class="inputs">
                    <input class="caixaforms" type="text" name="" id="" required>
                </div>
                <label for="">Nome no Cartão:</label>
                <div class="inputs">
                    <input class="caixaforms" type="text" name="" id="" required>
                </div>
                <input type="submit" class="botao" value="Confirmar">

            </div>

        </form>
        </div>

        <form class="botaologout" action="Voltarpaglogin" method="post">
            <input type="submit" class="botao" value="Logout">
        </form>
    </div>
</div>

<script>
    function mostrarInterface() {
        var opcao = document.getElementById("opcao").value;
        var interfaceCartao = document.getElementById("interfaceCartao");
        var interfacePix = document.getElementById("interfacePix");

        if (opcao === "CartaoCred" || opcao === "CartaoDeb") {
            interfaceCartao.style.display = "block";
            interfacePix.style.display = "none";
        } else if (opcao === "Pix") {
            interfacePix.style.display = "block";
            interfaceCartao.style.display = "none";
        } else {
            interfaceCartao.style.display = "none";
            interfacePix.style.display = "none";
        }
    }
</script>
</body>

</html>