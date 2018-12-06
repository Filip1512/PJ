<?php
session_start();

	if ( !( isset($_SESSION['zalogowany']) ) )
		{
		header('Location: index.php');
		}
	else
		{
			include('main2.html');
		}
?>