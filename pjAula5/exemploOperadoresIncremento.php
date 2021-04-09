<!DOCTYPE HTML>
<html>
    <head>
        <title>Exemplo Operadores Atribui??o e Incremento</title>
    </head>
    <body>
		<!-- Exemplo de Operadores Atribui??o e Incremento -->
        <?php
			for($i=0; $i<100; $i++){
				if($i % 2 == 0)
					continue;
				echo "<p> $i </p>";
			}
			
			$contador = 0;
			while($contador < 100){
				echo "<p> $contador </p>";
				$contador++;
			}
			
			do{
				echo "<p> $contador </p>";
				$contador--;
			}while($contador > 0);
		?>
    </body>
</html>