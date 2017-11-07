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
        <h1>Hello<%= request.getAttribute("username") %>,</h1>
        <h2>Email<%= request.getAttribute("email") %></h2>
        <h2>Phone<%= request.getAttribute("phone") %></h2>
        <form action="Logout">
            <button type="submit"> LOGOUT </button>
        </form>
    </body>
</html>
