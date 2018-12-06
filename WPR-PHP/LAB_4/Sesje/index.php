<?php
session_start();

	if( isset ($_SESSION['zalogowany']) )
		{
		header('Location: main.php');
		}
		
	else if ( !(isset($_SESSION['zalogowany'])) )
		{
		include('index2.html');
		
		if( ($_POST['login']=='student') && ($_POST['haslo']=='student') )
			{
				$_SESSION['zalogowany'] = $_POST['login'];
				header('Location: main.php');
			}
		}
		
?>