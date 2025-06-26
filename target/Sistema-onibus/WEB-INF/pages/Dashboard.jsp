<%--
  Created by IntelliJ IDEA.
  User: FABRI
  Date: 28/06/2024
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
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

        .sectionforms {
            display: flex;
            flex-direction: column;
            margin-bottom: 10px;

        }

        h1 {
            font-size: 40px;
        }

        .sla {
            font-size: 10px;
        }
        .btnlogout{
            margin-top:20px;
            margin-right:20px;

        }


        .red-hat-display {
            font-family: "Red Hat Display", sans-serif;
            font-optical-sizing: auto;
            margin: auto;
            font-style: normal;
        }
        .mg{
            margin-left: 64px ;
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
        <div class="orange_div">
            <h2 class="red-hat-display stp">Seu transporte, agora mais proximo de você...</h2>
            <img src="img/Onibus.png">
        </div>

        <div class="cad">
            <form class="mg" action="dashboard" method="Post">
            <h1 class="red-hat-display">Home</h1>


                <div class="sectionforms">
                    <button type="submit" class="botao"
                            name="opcao" value="cartao">Cartoes</button>
                </div>


                <div class="sectionforms">
                    <button type="submit" class="botao"
                            name="opcao" value="linhas">Linhas</button>
                </div>


            </form>

        </div>

        <form class="btnlogout" action="Voltarpaglogin" method="post">
            <input type="submit" class="botao" value="Log-out">
        </form>
    </div>

</div>


</body>

</html>
