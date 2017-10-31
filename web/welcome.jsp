<%-- 
    Document   : welcome
    Created on : Oct 29, 2017, 11:38:58 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= request.getServletContext().getAttribute("result") %></h1>
    </body>
</html>
