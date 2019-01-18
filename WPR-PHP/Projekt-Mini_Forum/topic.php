<?php
$db_host = 'not';
$db_user = 'this';
$db_pass = 'time';
$db_name = 'bro';

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
<h2>
<a href="index.php" style="text-decoration: none"> --- STRONA GŁÓWNA --- </a>
</h2>
</center>

<br><br><hr><br><br>

<?php
if ( !isset($_GET['t']) )
{
    header("index.php");
}
else
{
	$topic_id = $_GET['t'];
	
	$query = "SELECT * FROM forum_topics WHERE topicId='{$topic_id}'";
	$result = mysqli_fetch_row( mysqli_query($dbcon, $query) );
	$queryPosty = "SELECT * FROM forum_posts WHERE postTopicId='{$topic_id}'";
	
	if ($_GET['s'] == 'addnewpost')
	{
		$topic_id = $_GET['t'];
		echo '<center>';
		include('addnewpost.html');
		echo '<center/>';
		if ( isset($_POST['nick']) && isset($_POST['trescPostu']) )
		{
			$newPostAuthor = $_POST['nick'];
			$newPostContent = $_POST['trescPostu'];
			
			$queryInsertPost = "INSERT INTO `forum_posts` (`postTopicId`, `postContent`,`postAuthor`, `postCreateDate`) VALUES ('{$topic_id}', '{$newPostContent}', '{$newPostAuthor}', NOW())";
			//echo $queryInsertPost;
			
			if ( !mysqli_query($dbcon, $queryInsertPost) )
			{
				echo 'Blad insert';
			}	
		}
		if ( isset($_POST['addNewPostButton']) )
		{
			echo '<br>Dodano odpowiedz do tematu<br>';
		}
	}
	
	echo '<table width="40%" align="center" border="1" cellpadding="10">
	<tr>
	<td><b>Temat: </b>'.$result[1].'<br><b>Autor: </b>'.$result[3].'<br><b>Data zalozenia tematu: </b>'.$result[4].'</td>
	</tr>
	<tr><td>'.$result[2].'</td></tr>
	</table>';
	
	if ( $result2 = mysqli_query($dbcon, $queryPosty) )
	{
		while ( $row = mysqli_fetch_array($result2) )
		{
			echo "<table width='40%' align='center' border='1' cellpadding='10'><tr><td width='25%'><b>Autor: </b>".$row[3]."<br><b>Post z dnia: </b>".$row[4]."</td><td width='75%'>".$row[2]."</td></tr></table>";
		}
    }
	
	echo "<center><h2><a href='topic.php?t={$topic_id}&s=addnewpost' style='text-decoration: none'>Odpowiedz w temacie</a></h2></center>";

}
?>