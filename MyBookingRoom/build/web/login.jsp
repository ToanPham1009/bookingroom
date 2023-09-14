<%-- 
    Document   : index
    Created on : Nov 2, 2020, 8:57:43 PM
    Author     : Gia Toan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Welcome to Booking Page</h1>
        <form action="MainController" method="POST">
            User ID : <input type="text" name="txtUserID"/></br>
            Password: <input type="password" name="txtPassword"/></br>
            <input type="submit" value="login" name="btnAction"/>
            <input type="reset" value="Reset"/>
        </form>
        
        <a href="MainController?btnAction=CreatePage">Create New User</a>
    </body>
</html>
