<?php
// Definições de host, database, usuário e senha
$host = "localhost"; //servidor
$db   = "pjcurso";
$user = "root"; 
$pass = "admin";
// Conecta ao banco de dados
$con = mysqli_connect($host, $user, $pass) or trigger_error(mysql_error(),E_USER_ERROR);
// Seleciona a base de dados em que vamos trabalhar
mysqli_select_db($con, $db);
// Checagem da conexão
if (!$con) {
      die("Conexão falhou: " . mysqli_connect_error());
} 
echo "<H1><font color=green>Conectado com sucesso!</font></H1>";
?>