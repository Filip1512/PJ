<html>
<head>
<title>Wyznacznik</title>
</head>
<body>
		<form action="" method="post"><p align="center">
			<fieldset>
				<legend>Wyznacznik macierzy</legend>
					<input name="pole11">
					<input name="pole12">
					<input name="pole13"><br><br>
					<input name="pole21">
					<input name="pole22">
					<input name="pole23"><br><br>
					<input name="pole31">
					<input name="pole32">
					<input name="pole33"><br><br>
					<input type="submit" name="przycisk" value="Policz wyznacznik">
			</fieldset>
		</form>


<?php

	if (isset($_POST['pole11']) && isset($_POST['pole12']) && isset($_POST['pole13']) && isset($_POST['pole21']) && isset($_POST['pole22']) && isset($_POST['pole23']) && isset($_POST['pole31']) && isset($_POST['pole32']) && isset($_POST['pole33']))
	{
		if (is_numeric($_POST['pole11']) && is_numeric($_POST['pole12']) && is_numeric($_POST['pole13']) && is_numeric($_POST['pole21']) && is_numeric($_POST['pole22']) && is_numeric($_POST['pole23']) && is_numeric($_POST['pole31']) && is_numeric($_POST['pole32']) && is_numeric($_POST['pole33']))
		{
			$macierz = array();
			$macierz[0][0] = $_POST['pole11'];
			$macierz[0][1] = $_POST['pole12'];
			$macierz[0][2] = $_POST['pole13'];
			
			$macierz[1][0] = $_POST['pole21'];
			$macierz[1][1] = $_POST['pole22'];
			$macierz[1][2] = $_POST['pole23'];
			
			$macierz[2][0] = $_POST['pole31'];
			$macierz[2][1] = $_POST['pole32'];
			$macierz[2][2] = $_POST['pole33'];
			
			$wyznacznik = ( ($macierz[0][0] * $macierz[1][1] * $macierz[2][2]) + ($macierz[0][1] * $macierz[1][2] * $macierz[2][0]) + ($macierz[0][2] * $macierz[1][0] * $macierz[2][1]) - 
				($macierz[0][1] * $macierz[1][0] * $macierz[2][2]) - ($macierz[0][0] * $macierz[1][2] * $macierz[2][1]) - ($macierz[0][2] * $macierz[1][1] * $macierz[2][0]) );
				
			echo "Det A = $wyznacznik";
			
		}
		else
		{
			echo "Błędne wartości.";
		}
	}
	
			

?>

</body>
</html>