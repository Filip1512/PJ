<html>
<head>
<title>Praca na plikach</title>
</head>
<body>

<?php
	if(!$fd = fopen('./test.txt', 'r')){
		echo "Nie moge otworzyc pliku test.txt.";
	}
	else{
		while(!feof($fd)){
			$str = fgets($fd);
			$str = nl2br($str);
			echo($str);
			}
			fclose($fd);
		}
?>

</body>
</html>