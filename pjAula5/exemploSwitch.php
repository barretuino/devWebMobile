<!-- Exemplo de delimitação de strings heredoc -->
<!DOCTYPE HTML>
<html>
    <head>
        <title>Exemplo Switch Case --</title>
    </head>
    <body>

       <?php
          $opcao = 'C';

          switch ($opcao){
			case 'A':
				echo "<p>Selecionada opção A</p>";
				break;
			case 'B':
				echo "<p>Selecionada opção B</p>";
				break;
			default:
				echo "<p>Opção Inv&aacute;lida</p>";
				break;
		  }
        ?>
    </body>
</html>


