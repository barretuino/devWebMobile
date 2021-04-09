<!DOCTYPE HTML>
<html>
    <head>
        <title>Exemplo Casting</title>
    </head>
    <body>
		<!-- Exemplo de Casting -->
        <?php
			echo "<p>Upcast</p>";
		
			$b = 3.7; //Implicito valor flutuante
			echo "<h1> $b </h1>";
			
			$a = (int) $b; //For?ar a convers?o
			echo "<h1> Paulo $a </h1>";
			
			$c = (double) "1.44"; //explicito
			$c = ($c + 16);
			echo "<h1> $c </h1>";

		?>
    </body>
</html>