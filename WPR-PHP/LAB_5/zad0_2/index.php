<?php
$db_host = 'not';
$db_user = 'this';
$db_pass = 'time';
$db_name = 'bro';

include('header.html');

if ( !$db_lnk = mysqli_connect($db_host, $db_user, $db_pass) )
	{
	exit('Wystapil blad podczas proby polaczenia z serwerem MySQL...<br>');
	}
	
if ( !mysqli_select_db($db_lnk, $db_name) )
	{
	echo 'Wystapil blad podczas wyboru bazy danych: '.$db_name.'<br>';
	}
	
include('form.html');

if ( isset($_POST['saveButton']) )
	{
		$imie = $_POST['imie'];
		$nazwisko = $_POST['nazwisko'];
		$rok_urodzenia = $_POST['rok_urodzenia'];
		$miejsce_urodzenia = $_POST['miejsce_urodzenia'];
		
		$query = "INSERT INTO osoba(Imie,Nazwisko,Rok_urodzenia,Miejsce_urodzenia) VALUES ('$imie','$nazwisko','$rok_urodzenia','$miejsce_urodzenia')";
		echo $query;
		
		if ( !mysqli_query($db_lnk, $query) )
		{
			echo 'Blad insert';
		}	
	}
else
	echo 'Dziekujemy!';

	
if ( !mysqli_close($db_lnk) )
	{
	echo '<br>Blad podczas zamykania polaczenia z baza danych...<br>';
	}
?>