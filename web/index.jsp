<%-- 
    Document   : index
    Created on : Nov 5, 2017, 11:03:56 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Page </title>
    </head>
    
    <% 
       RequestDispatcher rd =  request.getRequestDispatcher("Auth");
       rd.forward(request, response);
    %>

    <body>
        <h1>Hello World!</h1>
    </body>
</html>
