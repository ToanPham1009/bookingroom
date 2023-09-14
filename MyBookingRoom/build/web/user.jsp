

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <h1>Welcome: ${sessionScope.LOGIN_USER.fullName}</h1>
        <c:url var="logoutUrl" value="MainController?btnAction=logout" >Logout</c:url>
        <a href="${logoutUrl}">logout</a>
        
        <form action="MainController" method="POST">
            Search Hotel From Area <input type="text" name="txtSearch" value="${sessionScope.txtSearch}"/> </br>
            Date In (YYYY/MM/DD)<input type="text" name="txtCheckIn" value="${sessionScope.txtCheckIn}"/> </br>
            Date Out (YYYY/MM/DD)<input type="text" name="txtCheckOut" value="${sessionScope.txtCheckOut}"/> </br>
            <select name="cmbRoomType">
                <option value="Nho">Small room for 2 people</option>
                <option value="Vua">Family room for 4 people</option>
                <option value="Lon">Big room for 8 people</option>
            </select>
            <input type="submit" value="Search" name="btnAction"/>
        </form>
        
        
        
        
        <c:set var="list" value="${requestScope.LIST_HOTEL}"/>
        <c:if test="${list != null}">
            <c:if test="${not empty list}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th> 
                            <th>Hotel ID</th>
                            <th>Hotel Name</th>
                            <th>Hotel Address</th>
                            <th>Description</th>  
                            <th>Room Type</th>
                            <th>View Detail</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="hotel" items="${list}" varStatus="counter">
                        <form action="MainController" method="POST">
                        <tr>
                            <td>${counter.count}</td>
                            <td>
                                ${hotel.hotelID}
                                <input type="hidden" name="hotelID" value="${hotel.hotelID}"/>
                            </td>
                            <td>${hotel.hotelName}

                            </td>
                            <td>${hotel.hotelAddress}</td>
                            <td>${hotel.hotelDescription}</td>
                            <td>${hotel.rtName}
                                <input type="hidden" name="rtName" value="${hotel.rtName}"/>
                            </td>
                            <td>                                
                                <input type="submit" value="View" name="btnAction"/>
                            </td>
                        </tr>
                        </form>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
        </c:if>
    </body>
</html>
