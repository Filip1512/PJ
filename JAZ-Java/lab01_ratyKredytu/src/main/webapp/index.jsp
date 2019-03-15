<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="UTF-8">
    <title>Wyliczanie rat kredytu</title>
</head>

<body>
<form action="harmonogram" method="post">
    <fieldset>
        <legend><h1 align="center">Wyliczanie rat kredytu</h1></legend>
        <table>
            <tr><td>Wnioskowana kwota kredytu: </td><td><input type="number" step=".01" min="100" id="kwotaKredytu" name="kwotaKredytu" required /></tr>
            <tr><td>Ilość rat: </td><td><input type="number" min="3" id="iloscRat" name="iloscRat" required /></td></tr>
            <tr><td>Oprocentowanie: </td><td><input type="number" step=".01" max="20" id="oprocentowanie" name="oprocentowanie" required /></td></tr>
            <tr><td>Opłata stała: </td><td><input type="number" step=".01" id="oplataStala" name="oplataStala" required /></td></tr>
            <tr><td>Rodzaj rat: </td><td><select id="rodzajRat" name="rodzajRat">
            <option value="stala">Raty stałe</option>
            <option value="malejaca">Raty malejące</option>
        </select></td></tr>
            <tr><td><br></td></tr>
            <tr><td><input type="submit" value="Oblicz"/></td></tr>
        </table>
    </fieldset>
</form>
</body>
</html>