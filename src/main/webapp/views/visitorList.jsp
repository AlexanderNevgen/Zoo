<%@ page session="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="model.Visitor" %>

<html>
<head>
    <title>Visitors List</title>
</head>
<body>

<table>
    <tr>
        <th>First Name</th>
        <th>ID</th>
    </tr>

    <c:forEach var="visitorList" items="${list}">
        <tr>
            <td>${visitorList.getFirstName()}</td>
            <td>${visitorList.getId()}</td>
        </tr>
    </c:forEach>

</table>
<p style="text-align: center"><button onclick="window.location.href = 'http://localhost:8080/Zoo_war/';">Go to menu</button>
</body>
