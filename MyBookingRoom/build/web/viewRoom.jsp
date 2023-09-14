<%-- 
    Document   : viewRoom
    Created on : Nov 8, 2020, 9:17:16 PM
    Author     : Gia Toan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Room Page</title>
    </head>
    <body>
        <h1>Welcome to ${sessionScope.HOTEL_NAME}</h1>

        <c:set var="listRoom" value="${requestScope.LIST_ROOM}"/>
        <c:if test="${listRoom != null}">
            <c:if test="${not empty listRoom}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th> 
                            <th>Room ID</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Description</th>  
                            <th>Booking</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="room" items="${listRoom}" varStatus="counter">
                            
                            <tr>
                                <td>${counter.count}</td>
                                <td>
                                    ${room.roomID}                               
                                </td>
                                <td>${room.price}</td>
                                <td>${room.quantity}</td>
                                <td>${room.roomDescription}</td>   
                                <td>
                                    <input type="submit" name="btnAction" value="Booking"/>
                                </td>

                            </tr>

                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
        </c:if>
    </body>
</html>
