<%-- 
    Document   : index
    Created on : Oct 16, 2017, 11:14:57 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./material.min.css">
        <script src="./material.min.js"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <style>
            .demo-card-square.mdl-card {
                width: 320px;
            }
            .demo-card-square > .mdl-card__title {
                color: #fff;
                background: #505a59;
            }
            .mdl-textfield{
                width :100%;
                margin: 20px;
            }
            .mdl-card__title-text{
                text-transform: uppercase;
            }
            mdl-card__supporting-text{
                min-height: 200px; 
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
                <form action="auth" method="POST">

                    <div class="demo-card-square mdl-card mdl-shadow--2dp" style="width: 100%;">
                        <div class="mdl-card__title mdl-card--expand">
                            <h2 class="mdl-card__title-text"> Login </h2>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield" style="font-size: 20px;">
                                <input class="mdl-textfield__input" type="text" style="font-size: 20px;" name="email" id="sample1">
                                <label  style="font-size: 20px;" class="mdl-textfield__label" for="sample1"> Email.. </label>
                            </div>
                            <div class="mdl-textfield mdl-js-textfield" style="font-size: 20px;">
                                <input class="mdl-textfield__input" type="text" style="font-size: 20px;" name="password" id="sample1">
                                <label  style="font-size: 20px;" class="mdl-textfield__label" for="sample1"> Password.. </label>
                            </div>

                        </div>
                        <div class="mdl-card__actions mdl-card--border" style="margin-top: 10px;  ">
                            <button class="mdl-button mdl-js-button" style="background: #46B6AC ;  font-weight: 900; float: right;" type="submit"> LOGIN </button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="mdl-layout-spacer"></div>

        </div>
    </body>
</html>
