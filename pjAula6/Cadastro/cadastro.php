<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Cadastro de Contatos</title>
</head>

<body>
<?php 
// RECEBENDO OS DADOS PREENCHIDOS DO FORMUL�RIO !
$nome	= $_POST ["nome"];	//atribui��o do campo "nome" vindo do formul�rio para variavel	
$email	= $_POST ["email"];	//atribui��o do campo "email" vindo do formul�rio para variavel
$ddd	= $_POST ["ddd"];	//atribui��o do campo "ddd" vindo do formul�rio para variavel
$tel	= $_POST ["telefone"];	//atribui��o do campo "telefone" vindo do formul�rio para variavel
$endereco	= $_POST ["endereco"];	//atribui��o do campo "endereco" vindo do formul�rio para variavel
$cidade	= $_POST ["cidade"];	//atribui��o do campo "cidade" vindo do formul�rio para variavel
$estado	= $_POST ["estado"];	//atribui��o do campo "estado" vindo do formul�rio para variavel
$bairro = $_POST ["bairro"];	//atribui��o do campo "bairro" vindo do formul�rio para variavel
$pais	= $_POST ["pais"];	//atribui��o do campo "pais" vindo do formul�rio para variavel
$login	= $_POST ["login"];	//atribui��o do campo "login" vindo do formul�rio para variavel
$senha	= $_POST ["senha"];	//atribui��o do campo "senha" vindo do formul�rio para variavel
$news	= $_POST ["news"];	//atribui��o do campo "news" vindo do formul�rio para variavel
$sexo	= $_POST ["sexo"];	//atribui��o do campo "sexo" vindo do formul�rio para variavel
//Gravando no banco de dados !
// Defini��es de host, database, usu�rio e senha
$host = "localhost";
$db   = "pjcurso";
$user = "root";
$pass = "admin";
//conectando com o localhost - mysql
$conexao = mysqli_connect($host, $user, $pass);
if (!$conexao)
	die ("Erro de conex�o com localhost, o seguinte erro ocorreu -> ".mysql_error());
//conectando com a tabela do banco de dados
$banco = mysqli_select_db($conexao, $db);
if (!$banco)
	die ("Erro de conex�o com banco de dados, o seguinte erro ocorreu -> ".mysql_error());


$query = "INSERT INTO `clientes` ( `nome` , `email` , `sexo` , `ddd` , `telefone` , `endere�o` , `cidade` , `estado` , `bairro` , `pa�s` , `login` , `senha` , `news` , `id` ) 
VALUES ('$nome', '$email', '$sexo', '$ddd', '$tel', '$endereco', '$cidade', '$estado', '$bairro', '$pais', '$login', '$senha', '$news', '123')";

$resultado = mysqli_query($conexao, $query);

echo "Seu cadastro foi realizado com sucesso!<br>Agradecemos a aten&ccedil;&atilde;o.";
?> 
</body>
</html>
