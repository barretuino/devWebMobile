<!DOCTYPE HTML>
<html>
    <head>
        <title>Exemplo Constante</title>
    </head>
    <body>
		<!-- Exemplo de Constantes -->
        <?php
			define("dolar", 5.40);
			
			$quantidade = 4;
			$valor_unitario = 1.55;
			$valor_venda = $quantidade * ($valor_unitario * dolar);
			
			echo "<p> Valor de Venda final &eacute; U$ $valor_venda </p>";
		?>
    </body>
</html>