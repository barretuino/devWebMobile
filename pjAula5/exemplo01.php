<!DOCTYPE HTML>
<html>
    <head>
        <title>Exemplo 01</title>
    </head>
    <body>
        <?php 
			$txtNome = "Paulo"; //String
			echo "<h1> $txtNome </h1>";
			
			for($i=0; $i<10; $i++){ //Numeral Inteiro
				echo "<p>$i</p>";
			}
			
			$status = true; //Tipo L?gico (Booleano)
			if($status == true){
				echo "<p>Sim, verdade</p>";
			}
			
		?>
    </body>
</html>