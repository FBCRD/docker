<%--
  Created by IntelliJ IDEA.
  User: FABRI
  Date: 03/06/2024
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIM</title>
    <link rel="stylesheet" href="css.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <style>

        .container{
            background-color: white;
            color: black;
            font-family: Arial, Helvetica, sans-serif;

            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .div_cadastro{
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
        .orange_div{
            background-color:#F58220;
            width:310px;
            height:500px;
            border-radius: 10px;
        }
        .cad{
            margin: auto;
            display: grid;

        }
        img{
            position: relative;
            right: 100px;


        }
        .stp{
            padding: 50px;
            color: white;

        }
        .botao{
            border-radius: 10px;
            padding: 10px;
            background-color: black;
            border-style: none;
            color: white;
            cursor: pointer;
        }
        .caixaforms{
            border-radius: 5px;
            padding: 5px;
            border: none;
            width:100%;

        }
        ._200{
            width: 211%;

        }

        .rowforms{
            margin-bottom: 5px;
            display: grid;
            grid-template-columns: 200px 200px;

        }
        .rowforms2{
            margin-bottom: 5px;
            display: grid;
            grid-template-columns: 100px 200px;
            justify-content: space-between;


        }
        .sectionforms{
            display:flex;
            flex-direction: column;
            margin-right: 20px;
        }

        h1{
            font-size: 40px;
        }
        .sla{
            font-size: 10px;
        }
        .red-hat-display{
            font-family: "Red Hat Display", sans-serif;
            font-optical-sizing: auto;
            margin: auto;
            font-style: normal;
        }



    </style>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Red+Hat+Display:ital,wght@0,300..900;1,300..900&display=swap" rel="stylesheet">
</head>

<body class="red-hat-display">
<div class="container">
    <div class="div_cadastro">
        <div class="orange_div">
            <h2 class="red-hat-display stp" >Seu transporte, agora mais proximo de você...</h2>
            <img src="img/Onibus.png">
        </div>
        <div class="cad">
            <h1 class="red-hat-display">Cadastre-se</h1>
            <form action="CadastraServlet" method="Post">

                <div class="rowforms">
                    <div class="sectionforms">
                        <label for="">E-mail:</label>
                        <input type="email" class="caixaforms" name="email" id="email"
                               placeholder="seuemail@gmail.com" required>
                    </div>
                    <div class="sectionforms">
                        <label for="">Nome de Usúario:</label>
                        <input type="text" class="caixaforms" name="nome_usuario" id="nome_usuario"
                               placeholder="Seu nome de Usuario" required>
                    </div>
                </div>


                <div class="rowforms">
                    <div class="sectionforms">
                        <label for="">Senha:</label>
                        <input type="password" class="caixaforms" name="senha" id="senha" placeholder="senha" required>
                    </div>
                    <div class="sectionforms">
                        <label for="">CPF:</label>
                        <input type="text" class="caixaforms" name="cpf" id="cpf" placeholder="000.000-00000" required>
                    </div>
                </div>


                <div class="rowforms ">
                    <div class="sectionforms">
                        <label for="">Endereço:</label>
                        <input type="text" class="caixaforms _200" name="endereco" id="endereco"
                               placeholder="Rua Java, 23" required>
                    </div>
                </div>


                <div class="rowforms">
                    <div class="sectionforms">
                        <label for="">Telefone:</label>
                        <input type="text" class="caixaforms" name="telefone" id="telefone"
                               placeholder="(55) 99999-9999" required>
                    </div>
                    <div class="sectionforms">
                        <label for="">Data de Nascimento:</label>
                        <input type="date" class="caixaforms" name="dt_nasc" id="dt_nasc" required>
                    </div>
                </div>

                <div class="rowforms2">
                    <input type="submit" class="botao" value="Cadastrar" required>

                    <p class="sla">(*)Campos Obrigatorios</p>
                </div>
            </form>
            <form action="paglogin" method="post">

            <button type="submit">Login</button>
            </form>
        </div>
    </div>
</div>


</body>

</html>
