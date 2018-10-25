<html>
<head>
<title>Kalkulator</title>
</head>
<body>
<h1>Kalkulator</h1>
<hr>
<h2>Prosty</h2>

<FORM action="" method="POST">
<input name="liczba1">

<select name="lista">
<option value="dodaj">+</option>
<option value="odejmij">-</option>
<option value="pomnoz">*</option>
<option value="podziel">/</option>
</select>

<input name="liczba2">

<br>
<h1><input type=submit value=Oblicz></h1>
</FORM>

<h1>wynik to: 
<?php
	$liczba1=$_POST['liczba1'];
	$liczba2=$_POST['liczba2'];
	$dzialanie=$_POST['lista'];
	switch($dzialanie)
	{
		case "dodaj":
		echo $liczba1+$liczba2;
		break;

		case "odejmij":
		echo $liczba1-$liczba2;
		break;

		case "pomnoz":
		echo $liczba1*$liczba2;
		break;

		case "podziel":
		echo $liczba1/$liczba2;
		break;
	}
?>
</h1>

<hr>

<h2>Zaawansowany</h2>

<FORM action="" method="POST">
<input name="liczba">

<select name="listaAdvanced">
<option value="cosinus">cos</option>
<option value="sinus">sin</option>
<option value="tangens">tg</option>
<option value="decBin">dziesietne na binarne</option>
<option value="binDec">binarne na dziesietne</option>
<option value="decHex">dziesietne na szesnastkowe</option>
<option value="HexDec">szesnastkowe na dziesietne</option>
<option value="deg2rad">stopnie na radiany</option>
<option value="rad2deg">radiany na stopnie</option>
</select>

<br>
<h1><input type=submit value=Oblicz></h1>
</FORM>

<h1>wynik to: 
<?php
	$liczbaAdv=$_POST['liczba'];
	$dzialanieA=$_POST['listaAdvanced'];
	switch($dzialanieA)
	{
		case "cosinus":
		echo cos($liczbaAdv);
		break;

		case "sinus":
		echo sin($liczbaAdv);
		break;

		case "tangens":
		echo tan($liczbaAdv);
		break;

		case "decBin":
		echo decbin($liczbaAdv);
		break;
		
		case "binDec":
		echo bindec($liczbaAdv);
		break;

		case "dexHex":
		echo dechex($liczbaAdv);
		break;

		case "hexDec":
		echo hexdec($liczbaAdv);
		break;

		case "deg2rad":
		echo deg2rad($liczbaAdv);
		break;

		case "rad2deg":
		echo rad2deg($liczbaAdv);
		break;

	}
?>
</h1>


</body>
</html>