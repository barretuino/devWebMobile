<?php
$host = "localhost";
$db   = "pjcurso";
$user = "root";
$pass = "admin";
$login = $_POST['login'];
$entrar = $_POST['entrar'];
$senha = MD5($_POST['senha']);
// conecta ao banco de dados
$connect = mysqli_connect($host, $user, $pass) or trigger_error(mysql_error(),E_USER_ERROR);
// seleciona a base de dados em que vamos trabalhar
mysqli_select_db($connect, $db);
  if (isset($entrar)) {

    $verifica = mysqli_query($connect, "SELECT * FROM usuarios WHERE login =
    '$login' AND senha = '$senha'") or die("erro ao selecionar");
      if (mysqli_num_rows($verifica)<=0){
        echo"<script language='javascript' type='text/javascript'>
        alert('Login e/ou senha incorretos');window.location
        .href='login.html';</script>";
        die();
      }else{
        setcookie("login",$login);
        header("Location:index.php");
      }
  }
  mysqli_close($connect);
?>