<form action="" method="post">
<input name="pole0">
<input name="pole1">
<input name="pole2">
<input name="pole3">
<input name="pole4">
<input name="pole5">
<br>
<input type="submit" name="przycisk" value="Losuj">
</form>


<?php


	$lotto_wybrane = array();
	$lotto_wybrane[0] = $_POST['pole0'];
	$lotto_wybrane[1] = $_POST['pole1'];
	$lotto_wybrane[2] = $_POST['pole2'];
	$lotto_wybrane[3] = $_POST['pole3'];
	$lotto_wybrane[4] = $_POST['pole4'];
	$lotto_wybrane[5] = $_POST['pole5'];

	$lotto = array();
	$i = 0;

	while($i < 6){
		$los = rand(1,49);
			if(in_array($los, $lotto)){
			continue;
		}
		else {
			$lotto[$i] = $los;
			$i++;
		}
	}
	echo "<pre>";
	sort($lotto);
	print_r($lotto);
	echo "</pre><br><br><br>";

	echo "<table border='1'><tr><td>";
	echo "<h1><p align='center'>Lotto</p></h1>";
		foreach($lotto as $x) echo "<img src =\"lotto/p".$x.".png\" width=80 height=80>";
	echo "</td></tr></table>";
	echo "<br><br><h1>Twoje liczby</h1>: ";
	sort($lotto_wybrane);
	echo "<pre>";
	foreach($lotto_wybrane as $x) echo "<img src =\"lotto/p".$x.".png\" width=80 height=80>";
	echo "</pre>";
	echo "<br><br><h1>Trafione liczby</h1>: ";
	$wynik=array_intersect($lotto, $lotto_wybrane);
	echo "<pre>";
		foreach($wynik as $x) echo "<img src =\"lotto/p".$x.".png\" width=80 height=80>";
	echo "</pre>";
?>