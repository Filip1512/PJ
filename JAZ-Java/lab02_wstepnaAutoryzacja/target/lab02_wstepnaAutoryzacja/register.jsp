<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="UTF-8">
    <title>Rejestracja</title>
</head>
<body>
<form action="register" method="POST">
    Login: <input type="text" id="username" name="username"/>
    Hasło: <input type="password" id="password" name="password"/>
    Potwierdz hasło: <input type="password" id="passwordConfirm" name="passwordConfirm"/>
    Email: <input type="text" id="email" name="email"/>
    <input type="submit" name="registerButton" value="Wyslij">
</form>
<c:if test="${not empty errorMessage}">
    <strong>${errorMessage}</strong>

</c:if>
</body>
</html>