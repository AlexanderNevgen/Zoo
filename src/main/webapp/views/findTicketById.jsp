<%--
  Created by IntelliJ IDEA.
  User: alexander.nevgen
  Date: 1/10/2021
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="main.model.Visitor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <th>TicketId</th>
        <th>Date</th>>
        <th>VisitorId</th>
    </tr>
    <c:forEach var="ticketList" items="${list}">
        <tr>
            <td>${ticketList.getTicketId()}</td>
            <td>${ticketList.getDate()}</td>
            <td>${ticketList.getVisitorId()}</td>
        </tr>
    </c:forEach>

</table>
    <p style="text-align: center"><button onclick="window.location.href = 'http://localhost:8080/Zoo_master_war/';">Go to menu</button>
</body>
