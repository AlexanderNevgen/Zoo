<%--
  Created by IntelliJ IDEA.
  User: alexander.nevgen
  Date: 1/20/2021
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visitors List</title>
</head>
<body>

<form action="findVisitorByName" method="post">
    firstName: <input name="firstName" />
    <br><br>
    lastName: <input name="lastName" />
    <br><br>

    <input type="submit" value="Submit" />
</form>
</body>
