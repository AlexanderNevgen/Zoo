<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Visitor</title>
</head>
<body>

<h2>Enter visitor information</h2>
<form:form method="post" action="addVisitor">
    <table>
        <tr>
            <td><form:label path="firstName">Name</form:label></td>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td><form:label path="ticketCount">ticketCount</form:label></td>
            <td><form:input path="ticketCount" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>