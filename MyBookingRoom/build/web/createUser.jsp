<%-- 
    Document   : createUser
    Created on : Nov 9, 2020, 2:59:02 PM
    Author     : Gia Toan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User Page</title>
    </head>
    <body>
        <h1>Fill out the form to create new user:</h1></br>
        <form action="MainController" method="POST">
            User ID <input type="text" name="txtUserID"/> </br>
            User Name <input type="text" name="txtUserName"/> </br>
            Password <input type="password" name="txtPassword"/> </br>
            Confirm <input type="password" name="txtConfirm"/> </br>
            Address <input type="text" name="txtAddress"/> </br>
            Phone <input type="text" name="txtPhone"/> </br>
            <input type="submit" name="btnAction" value="CreateUser"/>
            <input type="reset" value="Reset"/>
        </form>
        <c:url var="logoutUrl" value="MainController?btnAction=logout" ></c:url>
        <a href="${logoutUrl}">Login</a>
    </body>
</html>
