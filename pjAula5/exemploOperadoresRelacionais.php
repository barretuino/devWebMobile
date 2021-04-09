<!DOCTYPE HTML>
<html>
    <head>
        <title>Exemplo Operadores Relacionais</title>
    </head>
    <body>
		<!-- Exemplo de Operadores Relacionais -->
        <?php
			$a = 100;
			$b = false;
			$c = 15;
			
			if($a > 50 && (!$b|| $c < 20)){
				echo "<p>Verdadeiro</p>";
			}else{
				echo "<p>Falso</p>";
			}
		?>
    </body>
</html>