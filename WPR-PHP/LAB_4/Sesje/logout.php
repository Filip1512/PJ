<?php
	session_start();
	unset($_SESSION['zalogowany']);
	
	if ( session_destroy() )
		{
		echo('Sesja zostala zakonczona. Trwa wylogowywanie...');
		header('Refresh:2; URL=./index.php');	
		}
	else 
	{
		echo("Zakonczenie sesji nie powiodlo sie.");
	}
	
?>