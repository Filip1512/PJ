<html>
<head>
<title>Praca na plikach</title>
</head>
<body>

<?php
	$str = "Przykladowy wiersz tekstu";
	if(!$fd = fopen('./test.txt', 'a')){
		echo "Nie moge otworzyc pliku test.txt.";
	}
	else{
		if(fwrite($fd, $str) === false){
			echo "Blad, nie zapisano nowych danych";
		}
		else{
			echo "Zapisano pomyslnie!";
		}
			fclose($fd);
		}
?>

</body>
</html>