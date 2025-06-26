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
            margin-left: 10px;
            margin-top: 80px;
            display: grid;


        }

        img {
            position: relative;
            right: 100px;


        }

        .a1 {
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
            margin-top: 20px;
        }

        .caixaforms {
            border-radius: 5px;
            padding: 5px;
            border: none;
            margin-top: 20px;
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
            margin: auto;
            font-style: normal;
        }

        .divLinhas {
            margin-left: auto                                                                                           ;
            margin-right: auto;
            margin-top: 90px;
        }

        .selectLinhas {
            padding-left: 50px;
            margin-top: 80px;
        }

        .styled-table thead tr {
            background-color: #009879;
            color: #ffffff;
            text-align: left;
        }

        .styled-table th,
        .styled-table td {
            padding: 12px 15px;
        }

        .styled-table tbody tr {
            border-bottom: 1px solid #dddddd;
        }



        .styled-table tbody tr:last-of-type {
            border-bottom: 2px solid black;
        }

        .styled-table tbody tr.active-row {
            font-weight: bold;
            color: black;
        }

        .botaovoltar{
            margin-left: 20px;
        }
        .btnlogout{

            margin-right: 20px;

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
    <link href="https://fonts.googleapis.com/css2?family=Red+Hat+Display:ital,wght@0,300..900;1,300..900&display=swap"
          rel="stylesheet">
</head>

<body class="red-hat-display">
<div class="container">
    <div class="div_cadastro">

        <form class="botaovoltar" action="VoltarpagDash" method="post">
            <input type="submit" class="botao" value="Voltar">
        </form>
        <div class="cad">
            <form action="adicionarLinhas" method="Post">
            <h1 class="red-hat-display">Escolha suas linhas favoritas</h1>

                    <label for="options">
                        Linhas:
                    </label>
                    <select class="caixaforms" name="optlinha" id="optlinha">
                        <option value="1">UFSM Faixa Nova - Bombeiros</option>
                        <option value="2">UFSM Faixa Velha - Bombeiros </option>
                        <option value="3">UFSM Faixa Nova</option>
                        <option value="4">UFSM Faixa Velha</option>
                        <option value="5">T.Neves - Campus</option>
                        <option value="6">7 DE DEZEMBRO - ALTO DA BOA VISTA</option>
                        <option value="7">ATE SEMINARIO SAO JOSE HORARIOS CORRIDOS</option>
                        <option value="8">BOCA DO MONTE</option>
                        <option selected>SELECIONE A LINHA</option>
                        <option value="10">CAMOBI-CARLOS GOMES-CFFERRARI</option>
                        <option value="11">CAMPESTRE</option>
                        <option value="12">CAPIVARA</option>
                        <option value="13">CAROLINA - SAO JOSE</option>
                        <option value="14">CASA DE SAUDE</option>
                        <option value="15">CIRCULAR SUL -SAIDA CEMITERIO MUNICIPAL</option>
                        <option value="16">CIRCULAR T NEVES</option>
                        <option value="17">HORARIOS CLUBE DORES VIA FAIXA NOVA- JARDIM BERLEZE</option>
                        <option value="18">HORARIOS VIA FAIXA NOVA</option>
                        <option value="19">ITARARE BRIGADA - BRIGADA ITARARE</option>
                        <option value="20">JARDIM BERLEZE - MARINGA- VIA ZILDA ARNS</option>
                        <option value="21">MEDIANEIRA VIA CARLOS HUR</option>
                        <option value="22">NORTE - SALGADO FILHO - GENTIL DALLALANA - CATURRITA - CONCEICAO - BELA
                            UNIAO - SANTA TEREZINHA - VITORIA</option>
                        <option value="23">PARQUE PINHEIRO MACHADO</option>
                        <option value="24">PARQUE RIACHUELO</option>
                        <option value="25">PASSO DAS TROPAS - MINUANO</option>
                        <option value="26">PATRONATO</option>
                        <option value="27">PAU A PIQUE</option>
                        <option value="28">PRADO</option>
                        <option value="29">SANTA MARTA</option>
                        <option value="30">SANTOS - URLANDIA</option>
                        <option value="31">SAO JOAO - KM2 - FORUM</option>
                        <option value="32">T NEVES RODOVIARIA</option>
                        <option value="33">TANCREDO NEVES</option>
                        <option value="34">UFSM CIRCULAR</option>
                        <option value="35">VILA LORENZI</option>
                        <option value="36">VILA OLIVEIRA - CHACARA DAS FLORES</option>
                        <option value="37">VILA ROSSI - BOI MORTO</option>
                        <option value="38">VILA SCHIRMER-CAMPESTRE</option>
                    </select>

                <input type="submit" class="botao" value="Cadastrar">
                <c:if test="${not empty retornoTabela}">
                    <p>${retornoTabela}</p>
                </c:if>
            </form>
        </div>
        <div class="divLinhas">

            <table>
                <th>Suas linhas favoritas</th>
                <th>Opcao</th>
                <c:forEach var="linhas" items="${linhas}">
                    <tr >
                        <td>${linhas.nomeLinha}</td>
                        <td>
                            <a href="adicionarLinhas?opcao=excluir&&idLinha=${linhas.idLinha}">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <form class="btnlogout" action="Voltarpaglogin" method="post">
            <input type="submit" class="botao" value="Log-out">
        </form>
    </div>


</body>

</html>