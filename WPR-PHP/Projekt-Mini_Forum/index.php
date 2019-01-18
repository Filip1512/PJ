<?php
$db_host = 'not';
$db_user = 'this';
$db_pass = 'time';
$db_name = 'bro';

include('header.html');

// DB CONNECT
if ( !$dbcon = mysqli_connect($db_host, $db_user, $db_pass) )
	{
	exit('Wystapil blad podczas proby polaczenia z serwerem MySQL...<br>');
	}
	
if ( !mysqli_select_db($dbcon, $db_name) )
	{
	echo 'Wystapil blad podczas wyboru bazy danych: '.$db_name.'<br>';
	}
// DB END OF CONNECTING

?>

<center>
<h2><a href="index.php" style="text-decoration: none"> --- STRONA GŁÓWNA --- </a></h2><br><br>
<h2><a href="index.php?s=addnewtopic" style="text-decoration: none"> -- Nowy Temat --- </a></h2>
<br><hr><br>

<?php

if ($_GET['s'] == 'addnewtopic')
{
	include('addnewtopic.html');
	
	if ( isset($_POST['nick']) && isset($_POST['nazwaTematu']) )
	{
		$newTopicAuthor = $_POST['nick'];
		$newTopicName = $_POST['nazwaTematu'];
		$newTopicContent = $_POST['trescTematu'];
		
		$queryInsertTopic = "INSERT INTO `forum_topics` (`topicName`, `topicContent`, `topicAuthor`, `topicCreateDate`) VALUES ('{$newTopicName}', '{$newTopicContent}', '{$newTopicAuthor}', NOW())";
		//echo $queryInsertTopic;
		
		if ( !mysqli_query($dbcon, $queryInsertTopic) )
		{
			echo 'Blad insert';
		}	
	}
	if ( isset($_POST['addNewTopicButton']) )
	{
		echo '<br>Stworzono nowy temat<br>';
	}
}

echo '<br><br><br>';

$query = "SELECT * FROM forum_topics ORDER BY topicId DESC";

if ( $result = mysqli_query($dbcon, $query) )
{
	if ( mysqli_num_rows($result) > 0 ){
		echo "<table width='80%' border='1'><tr><td align='center' width='5%'><h3>ID</h3></td><td align='center'> <h3>Nazwa tematu</h3> </td> <td align='center'> <h3>Autor</h3> </td> <td align='center'> <h3>Data zalozenia</h3> </td></tr>";
		
		while ( $row = mysqli_fetch_array($result) )	
		{
			echo '<tr><td align="center" width="5%">'.$row['topicId'].'</td><td align="center"><a href="topic.php?t='.$row['topicId'].'">'.$row['topicName'].'</a></td><td align="center">'.$row['topicAuthor'].'</td><td align="center">'.$row['topicCreateDate'].'</td></tr>';
		}
	echo '</table></center>';
	}
}
else
{
	echo 'Blad query: '.$query;
}


?>
