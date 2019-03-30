<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="UTF-8">
    <title>Rejestracja</title>
</head>
<body>

<h3><a href="/"><i>Zaloguj się</i></a></h3>

<form action="action" method="post">
    <fieldset>
        <legend><h1>Zarejestruj się</h1></legend>
        <table>
            <tr><td>Nick</td><td><input type="text" id="username" name="username" required></td></tr>
            <tr><td>Hasło</td><td><input type="text" id="surname" name="surname" required></td></tr>
            <tr><td>Email</td><td><input type="email" id="email" name="email" required></td></tr>
            <tr><td><input value="Stwórz nowe konto" type="submit" id="register" name="register"></td></tr>
        </table>
    </fieldset>
</form>

</body>
</html>