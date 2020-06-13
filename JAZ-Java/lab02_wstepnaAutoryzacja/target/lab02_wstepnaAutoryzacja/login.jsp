<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="UTF-8">
    <title>Tajna strona</title>
</head>
<body>
<form action="login" method="POST">
    Login:<input type="text" id="username" name="username"/>
    Hasło:<input type="password" id="password" name="password"/>
    <input type="submit" name="loginButton" value="wyslij">
</form>
<c:if test="${not empty errorMessage}">
    ${errorMessage}
</c:if>
</body>
</html>


