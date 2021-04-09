<?php

$dbname="danco_contato"; // Indique o nome do banco de dados que será aberto
$usuario="root"; // Indique o nome do usuário que tem acesso
$password=""; // Indique a senha do usuário

if(!(mysql_connect("localhost",$usuario,$password))) {
   echo "Não foi possível estabelecer uma conexão com o gerenciador MySQL. Favor Contactar o Administrador.";

} else {
    //echo "Conectado!!!"."<br>";
}

if (mysql_select_db($dbname)) {
    //echo "DB selecionado!";
}

$grava_nome = $_POST['nome'];
$grava_cidade = $_POST['cidade'];
$grava_cidade = $_POST['email'];
$grava_mensagem = $_POST['mensagem'];

$sql_gravar = mysql_query("INSERT INTO contato (nome, cidade, mensagem) value ('$grava_nome', '$grava_cidade', '$grava_mensagem')");

if($sql_gravar)
{
    echo"<br>";
    echo "Sua mensagem foi enviada com sucesso!"."<br>";
    echo "Obrigado por participar!";
}else
{
    echo "Desculpe, erro ao enviar!";
}
?>

