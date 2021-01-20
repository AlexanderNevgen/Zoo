<%--
  Created by IntelliJ IDEA.
  User: alexander.nevgen
  Date: 12/27/2020
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updateVisitor" method="POST">
    id: <input name="id" />
    <br><br>
    firstName: <input name="firstName" />
    <br><br>
    lastName: <input name="lastName" />
    <br><br>
    age: <input name="age" />
    <br><br>
    ticketCount: <input name="ticketCount" />
    <br><br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
