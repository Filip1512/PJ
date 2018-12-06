<html>
<head>
<title>Napisz opinie</title>
</head>
<body>

<?php
	$opinia = date("d-m-Y g:i:s")." | ".$_POST[opinia]."\n";
	$zawartoscPliku = file('opinie.txt');
	
	if(isset($_POST['opinia'])){
		
		if(!$fd = fopen('./opinie.txt', 'w+')){
			echo "Blad podczas otwierania pliku.";
		}
		else{
			$rev = array_reverse($zawartoscPliku);
			array_push($rev, $opinia);
			$zawartoscPliku = array_reverse($rev);
			
			foreach($zawartoscPliku as $linia){
				if(fwrite($fd, $linia) === FALSE){
					echo "Blad podczas zapisywania opini do pliku.";
				}
			}
			echo "Dziękujemy za opinie!";
		}
		fclose($fd);
	}
	else {
	?>
	<form action="" method="post">
		<fieldset>
			<legend><h3>Wyraz swoja opinie:</h3><br>(maksymalnie 255 znakow)</legend>
			
			<textarea name="opinia" cols=20 rows=10></textarea>
			<input type="submit" name="przycisk" value="Wyslij opinie">
		</fieldset>
	</form>
	<?php
	}
	?>

</body>
</html>