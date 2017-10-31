<%-- 
    Document   : result
    Created on : Oct 16, 2017, 11:22:46 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RESULT</title>
        <link rel="stylesheet" href="./material.min.css">
        <script src="./material.min.js"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <style>
            .demo-card-square.mdl-card {
                width: 320px;
                height: 120px;
            }
            .demo-card-square > .mdl-card__title {
                color: #fff;
                background: #505a59;
            }
            .addsub{
                font-weight: 900;
                color:#d32f2f;
            }
            .mul{
                font-weight: 900;
                color:#00b8d4;
            }
            h1 , h2{
                text-align: center;
                
            }
            h2{
                color: dimgrey;
            }
            h1{
                 text-transform: uppercase;
            }
            body {
                background: #f9f9f9;
            }
        </style>

    </head>
    <body>
        <div class="mdl-grid">

            <div class="mdl-layout-spacer"></div>
            <div class="mdl-cell mdl-cell--4-col mdl-cell--4-col-phone" style="margin-top: 10%;">
                <div class="mdl-card mdl-shadow--2dp" style="width: 100%">
                    <h2> 
                        <%
                            String formula = request.getParameter("formula");
                            for (int i = 0; i < formula.length(); i++) {
                                if (formula.charAt(i) == '+' || formula.charAt(i) == '-') {
                                    out.print("<span class=\"addsub\">");
                                } else if (formula.charAt(i) == '*' || formula.charAt(i) == '/') {
                                    out.print("<span class=\"mul\">");

                                } else {
                                    out.print("<span>");

                                }

                                out.print(formula.charAt(i));

                                out.print("</span>");

                            }%> 
                    </h2>

                            <h1> <span style="color: #455a64; font-size: 50px;"> Result : </span> <span style="font-weight: 900;" ><%= request.getAttribute("result")%> </span> </h1>
                    <a class="mdl-button mdl-js-button mdl-button--fab mdl-button--colored" href="index.jsp" style="margin-bottom: 30px; background: #8ecfce;">
  <i class="material-icons">arrow_back</i>
</a>
                </div>
            </div>
            <div class="mdl-layout-spacer"></div>

        </div>
    </body>
</html>
