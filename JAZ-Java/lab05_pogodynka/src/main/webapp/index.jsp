<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Witaj na stronie - Pogodynka!</h1>
Wybierz z formularza miasto, w którym interesuje Cie pogoda:

<form action="/pogoda" method="get">
    <select name="cityForm" id="cityForm">
        <option value="Warsaw">Warszawa</option>
        <option value="Gdansk">Gdańsk</option>
        <option value="Krakow">Kraków</option>
        <option value="Wroclaw">Wrocław</option>
        <option value="Poznan">Poznań</option>
        <option value="Lodz">Łódź</option>
        <option value="Katowice">Katowice</option>
    </select>
    <input type="submit" value="Sprawdź pogodę">
</form>

</body>
</html>
