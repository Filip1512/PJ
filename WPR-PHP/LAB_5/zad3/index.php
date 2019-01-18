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
?>
	<fieldset>

	<form method="post" action="">

	<legend>Usuwanie rekordow w bazie</legend>
	<br>ID w bazie: <input type='text' name='dbRecordId'>
	<br><br><input type="submit" value="Usun konkretny rekord z bazy (ID)" name='delEachButton'/>
	<br><br><input type="submit" value="Usun wszystkie puste rekordy z bazy" name='delButton'/>
	</form>

	</fieldset>
<?php

if ( isset($_POST['delButton']) )
	{
		$queryDelEmpty = "DELETE FROM osoba WHERE imie='' ";
		echo $queryDelEmpty;
		
		if ( !mysqli_query($db_lnk, $queryDelEmpty) )
		{
			echo '<br><br>Blad queryDelEmpty';
		}	
	}
if ( isset($_POST['delEachButton']) )
	{
		$queryDelEach = ("DELETE FROM osoba WHERE Id={$_POST['dbRecordId']}");
		echo $queryDelEach;
		
		if ( !mysqli_query($db_lnk, $queryDelEach) )
		{
			echo '<br><br>Blad queryDelEach';
		}	
	}
else
	echo '<br><br>Dziekujemy!';

	
if ( !mysqli_close($db_lnk) )
	{
	echo '<br>Blad podczas zamykania polaczenia z baza danych...<br>';
	}
	
include('footer.html');
?>