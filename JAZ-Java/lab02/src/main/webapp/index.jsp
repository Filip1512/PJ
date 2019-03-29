<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="UTF-8">
    <title>Zapisy do Java 4 US!</title>
</head>
<body>

<form action="/add" method="get">
    <fieldset>
        <legend><h1>Zapisy do konferencji Java 4 US!</h1></legend>
        <table>
            <tr><td>Imię</td><td><input type="text" id="name" name="name" required></td></tr>
            <tr><td>Nazwisko</td><td><input type="text" id="surname" name="surname" required></td></tr>
            <tr><td>Pracodawca</td><td><input type="text" id="employment" name="employment" required></td></tr>
            <tr><td>Adres email</td><td><input type="email" id="email" name="email" required></td></tr>
            <tr><td>Potwierdz email</td><td><input type="email" id="confirmemail" name="confirmemail" required></td></tr>
            <tr><td>Skad wiesz o konferencji</td><td><select id="info" name="info">
                <option value="work">Ogłoszenie w pracy</option>
                <option value="school">Ogłoszenie na uczelni</option>
                <option value="facebook">Facebook</option>
                <option value="friends">Znajomi</option>
            </select></tr>
            <tr><td><input value="Zapisz się" type="submit" id="submit" name="submit"></td></tr>
        </table>
    </fieldset>
</form>

</body>
</html>