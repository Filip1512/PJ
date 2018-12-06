<?php

	if(!isset($_COOKIE['nazwa']) && !isset($_POST['nazwa'])){
		include ("header.html");
		include ("form.html");
		include ("footer.html");
		}
	
	else if (isset($_POST['nazwa'])){
		// w tym miejscu warto dodac instrukcje weryfikujace poprawnosc danych
		setcookie("nazwa", $_POST['nazwa'], time() + 60*60*24*365);
		include("header.html");
		echo ("<p>Dziekujemy za podanie danych.</p>");
		include ("footer.html");
		}
	else{
		include("header.html");
		echo("Witamy, zostales rozpoznany jako {$_COOKIE['nazwa']}.");
		include("footer.html");
		}
?>