<%--
  Created by IntelliJ IDEA.
  User: Filip
  Date: 2019-06-18
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Control Panel</title>
</head>
<body>
<form action="acp" method="POST">
    <table>
        <tr>
            <th>Login</th>
            <th>Email</th>
            <th>Premium</th>
        </tr>
        <c:forEach items="${userList}" var="element">
            <tr>
                <td><input type="text" readonly="readonly" value="${element.username}"/></td>
                <td><input type="text" readonly="readonly" value="${element.email}"/></td>
                <td><input type="checkbox" name="isPremium"
                           <c:if test="${element.isPremium}">checked</c:if>
                           value="${element.username}"><br></td>
            </tr>
        </c:forEach>

    </table>
    <input type="submit" name="saveData" value="Zapisz zmiany">
</form>

</body>
</html>
