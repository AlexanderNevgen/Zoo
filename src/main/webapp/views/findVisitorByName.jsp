<%--
  Created by IntelliJ IDEA.
  User: alexander.nevgen
  Date: 1/20/2021
  Time: 6:10 PM
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
        <th>ID</th>
        <th>FirstName</th>
        <th>LastName</th>>
        <th>Age</th>
    </tr>
    <c:forEach var="visitorList" items="${list}">
        <tr>
            <td>${visitorList.getId()}</td>
            <td>${visitorList.getFirstName()}</td>
            <td>${visitorList.getLastName()}</td>
            <td>${visitorList.getAge()}</td>
        </tr>
    </c:forEach>

</table>
<p style="text-align: center"><button onclick="window.location.href = 'http://localhost:8080/Zoo_master_war/';">Go to menu</button>
</body>
