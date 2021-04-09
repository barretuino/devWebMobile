<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Cadastro de Contatos</title>
</head>

<body>
<?php 
// RECEBENDO OS DADOS PREENCHIDOS DO FORMULÁRIO !
$nome	= $_POST ["nome"];	//atribuição do campo "nome" vindo do formulário para variavel	
$email	= $_POST ["email"];	//atribuição do campo "email" vindo do formulário para variavel
$ddd	= $_POST ["ddd"];	//atribuição do campo "ddd" vindo do formulário para variavel
$tel	= $_POST ["telefone"];	//atribuição do campo "telefone" vindo do formulário para variavel
$endereco	= $_POST ["endereco"];	//atribuição do campo "endereco" vindo do formulário para variavel
$cidade	= $_POST ["cidade"];	//atribuição do campo "cidade" vindo do formulário para variavel
$estado	= $_POST ["estado"];	//atribuição do campo "estado" vindo do formulário para variavel
$bairro = $_POST ["bairro"];	//atribuição do campo "bairro" vindo do formulário para variavel
$pais	= $_POST ["pais"];	//atribuição do campo "pais" vindo do formulário para variavel
$login	= $_POST ["login"];	//atribuição do campo "login" vindo do formulário para variavel
$senha	= $_POST ["senha"];	//atribuição do campo "senha" vindo do formulário para variavel
$news	= $_POST ["news"];	//atribuição do campo "news" vindo do formulário para variavel
$sexo	= $_POST ["sexo"];	//atribuição do campo "sexo" vindo do formulário para variavel
//Gravando no banco de dados !
// Definições de host, database, usuário e senha
$host = "localhost";
$db   = "pjcurso";
$user = "root";
$pass = "admin";
//conectando com o localhost - mysql
$conexao = mysqli_connect($host, $user, $pass);
if (!$conexao)
	die ("Erro de conexão com localhost, o seguinte erro ocorreu -> ".mysql_error());
//conectando com a tabela do banco de dados
$banco = mysqli_select_db($conexao, $db);
if (!$banco)
	die ("Erro de conexão com banco de dados, o seguinte erro ocorreu -> ".mysql_error());


$query = "INSERT INTO `clientes` ( `nome` , `email` , `sexo` , `ddd` , `telefone` , `endereço` , `cidade` , `estado` , `bairro` , `país` , `login` , `senha` , `news` , `id` ) 
VALUES ('$nome', '$email', '$sexo', '$ddd', '$tel', '$endereco', '$cidade', '$estado', '$bairro', '$pais', '$login', '$senha', '$news', '123')";

$resultado = mysqli_query($conexao, $query);

echo "Seu cadastro foi realizado com sucesso!<br>Agradecemos a aten&ccedil;&atilde;o.";
?> 
</body>
</html>
