<!DOCTYPE HTML>
<html>
    <head>
        <title>Exemplo Operadores Aritm?ticos de Atribui??o</title>
    </head>
    <body>
		<!-- Exemplo de Operadores Aritm?ticos de Atribui??o -->
        <?php
			$valorAcumulado = 0;
			for($i=0; $i<1000; $i++){
				/**Equivalente a
					$valorAcumulado = $valorAcumulado + $i;
				**/
				$valorAcumulado += $i;
			}				
			echo "<p> $valorAcumulado </p>";
		?>
    </body>
</html>