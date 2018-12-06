<html>
<head>
<title>Napisz opinie</title>
</head>
<body>

<?php
	$strona = file_get_contents('http://szuflandia.pjwstk.edu.pl/~KAROLAD/WPR/Lab3/linki');
	$regexLink = "http:\/\/(.)+?~[sS][0-9]+";
	$regexOpis = 
	
	preg_match_all($regexLink, $strona, $linki, PREG_SET_ORDER);
	preg_match_all($regexOpis, $strona, $opisy, PREG_SET_ORDER);
	$linki = array();
	$opisy = array();
	
	foreach $linki as $link
	
	
?>

</body>
</html>