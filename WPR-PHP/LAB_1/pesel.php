<html>
<head>
<title>Dekodowanie numeru PESEL</title>
</head>
<body>
<h1>Dekodowanie numeru PESEL</h1>
<hr>

<h2>
<?php
	function Dekoduj(){
		$numerPesel=$_POST['pesel'];
		$dzien=substr($numerPesel, 4, 2);
		$miesiac=substr($numerPesel, 2, 2);
		$rok=substr($numerPesel, 0, 2);
		$plec=substr($numerPesel, 9, 1);
		
		echo "Twoja data urodzenia: ";
		
		switch($dzien)
		{
			case in_array($dzien, range(1, 31)): echo $dzien; break;
			default: echo "BLAD";
		}
		echo ".";
		
		switch($miesiac){
			case in_array($miesiac, range(81, 92)): echo $miesiac-80 . ".18"; break;
			case in_array($miesiac, range(1, 12)): echo $miesiac . ".19"; break;
			case in_array($miesiac, range(21, 32)): echo $miesiac-20 . ".20"; break;
			case in_array($miesiac, range(41, 52)): echo $miesiac-40 . ".21"; break;
			case in_array($miesiac, range(61, 72)): echo $miesiac-60 . ".22"; break;
			default: echo "BLAD.00";
		}

		echo $rok;
		
		if($plec % 2 == 0)
		{
			echo ". Jestes kobietą.";
		}
		else echo ". Jestes mezczyzna.";
		
	}
	
	if(isset($_POST['pesel']))
	{
		?>
			<FORM action="" method="POST">
			<input type="text" name="pesel" pattern="[0-9]{11}">

			<br>
			<h1><input type="submit" value="Dekoduj"></h1>
			</FORM>
		<?php
		Dekoduj();
	}
	else
	{
		?>
			<FORM action="" method="POST">
			<input type="text" name="pesel" pattern="[0-9]{11}">

			<br>
			<h1><input type="submit" value="Dekoduj"></h1>
			</FORM>
	<?php
	}

?>
</h2>
<hr>
</body>
</html>