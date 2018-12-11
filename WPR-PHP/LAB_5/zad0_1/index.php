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

$query = 'SELECT * FROM osoba';
if ( !$result = mysqli_query($db_lnk, $query) )
{
	mysqli_close($db_lnk);
	echo 'Wystapil blad, nieprawidlowe zapytanie';
	exit;
}

include('tab_start.html');

while($row = mysqli_fetch_row($result) )
{
	echo '<tr>';
	echo '<td>'.$row[0].'</td>';
	echo '<td>'.$row[1].'</td>';
	echo '<td>'.$row[2].'</td>';
	echo '<td>'.$row[3].'</td>';
	echo '<td>'.$row[4].'</td>';	
}
	
include('tab_end.html');
	
if ( !mysqli_close($db_lnk) )
	{
	echo '<br>Blad podczas zamykania polaczenia z baza danych...<br>';
	}
else
	{
	echo '<br>Polaczenie z baza danych zostalo zamkniete.<br>';
	}
?>