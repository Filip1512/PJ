<%--
  Created by IntelliJ IDEA.
  User: Filip
  Date: 2019-06-18
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dane</title>
</head>
<body>
Dane użytkownika
<form action="" method="POST">
    Login:<input readonly="readonly" type="text" id="login" name="login" value="${userData.username}"/>
    Email<input readonly="readonly" type="text" id="email" name="email" value="${userData.email}"/>
</form>
</body>
</html>
