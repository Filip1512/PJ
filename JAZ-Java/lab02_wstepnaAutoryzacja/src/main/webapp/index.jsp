<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="UTF-8">
    <title>Tajna strona</title>
</head>
<body>

<h3><a href="register.jsp"><i>Stwórz nowe konto</i></a></h3>

<form action="login" method="post">
    <fieldset>
        <legend><h1>Zaloguj się</h1></legend>
        <table>
            <tr><td>Nick</td><td><input type="text" id="username" name="username" required></td></tr>
            <tr><td>Hasło</td><td><input type="text" id="surname" name="surname" required></td></tr>
            <tr><td><input value="Zaloguj się" type="submit" id="login" name="login"></td></tr>
        </table>
    </fieldset>
</form>

</body>
</html>