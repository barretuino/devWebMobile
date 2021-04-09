<?php
// Definições de host, database, usuário e senha
$host = "localhost";
$db   = "pjcurso";
$user = "root";
$pass = "admin";
// Conecta ao banco de dados
$con = mysqli_connect($host, $user, $pass) or trigger_error(mysql_error(),E_USER_ERROR);
// Seleciona a base de dados em que vamos trabalhar
mysqli_select_db($con, $db);
// cria a instrução SQL que vai selecionar os dados
$query = sprintf("SELECT identificador, nome, telefone FROM cadastro");
// executa a query Retorno Implicito ResultSet List<Object[]>
$dados = mysqli_query($con, $query) or die(mysqli_error());
// transforma os dados em um array
$linha = mysqli_fetch_assoc($dados);
// calcula quantos dados retornaram
$total = mysqli_num_rows($dados);
echo "<H1>Total e&acute; $total </H1>"
?>

<html>
	<head>
	<title>Exemplo</title>
</head>
<body>
<?php
	// se o número de resultados for maior que zero, mostra os dados
	if($total > 0) {
		// inicia o loop que vai mostrar todos os dados
		do {
?>
			<p><?=$linha['nome']?> / <?=$linha['telefone']?></p>
<?php
		// finaliza o loop que vai mostrar os dados
		}while($linha = mysqli_fetch_assoc($dados));
	// fim do if
	}
?>
</body>
</html>
<?php
// tira o resultado da busca da memória
mysqli_free_result($dados);
mysqli_close($con);
?>