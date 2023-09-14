<%-- 
    Document   : admin
    Created on : Nov 7, 2020, 10:07:28 AM
    Author     : Gia Toan
--%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Welcome: ${sessionScope.LOGIN_USER.fullName}</h1>
        <c:url var="logoutUrl" value="MainController?btnAction=logout" ></c:url>
        <a href="${logoutUrl}">Logout</a>

        <form action="MainController" method="POST">
            Search User <input type="text" name="txtSearchUser"/>
            <input type="submit" value="SearchUser" name="btnAction"/>
        </form>

        <c:set var="listUser" value="${requestScope.LIST_USER}"/>
        <c:if test="${listUser != null}">
            <c:if test="${not empty listUser}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>User ID</th>
                            <th>User Name</th>
                            <th>Password</th>
                            <th>Role ID</th>
                            <th>Address</th>
                            <th>Phone</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${listUser}" varStatus="counter">
                        <form action="MainController" method="POST">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${user.userID}
                                    <input type="hidden" name="txtUserID" value="${user.userID}"/>
                                </td>
                                <td>
                                    <input type="text" name="txtFullName" value="${user.fullName}"/>
                                </td>
                                <td>${user.password}
                                    <input type="hidden" name="txtPassword" value="${user.password}"/>
                                </td>
                                <td>${user.roleID}
                                    <input type="hidden" name="txtRoleID" value="${user.roleID}"/>
                                </td>
                                <td>
                                    <input type="text" name="txtAddress" value="${user.address}"/>
                                </td>
                                <td>
                                    <input type="text" name="txtPhone" value="${user.phone}"/>
                                </td>
                                <td>
                                    <c:url var="Delete" value="MainController">
                                        <c:param name="txtUserID" value="${user.userID}"/>
                                        <c:param name="txtRoleID" value="${user.roleID}"/>
                                        <c:param name="btnAction" value="Delete"/>
                                    </c:url>
                                    <a href="${Delete}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" name="btnAction" value="Update"/>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
    </c:if>
    <h1>${requestScope.notify}</h1>
</body>
</html>
