<?php
$host = "localhost";
$db   = "pjcurso";
$user = "root";
$pass = "admin";
$login = $_POST['login']; //o que é enviado ao servidor
$senha = $_POST['senha']; //MD5($_POST['senha']);
// conecta ao banco de dados
$connect = mysqli_connect($host, $user, $pass) or trigger_error(mysql_error(),E_USER_ERROR);
// seleciona a base de dados em que vamos trabalhar
mysqli_select_db($connect, $db);
$query_select = "SELECT login FROM usuarios WHERE login = '$login'";
$select = mysqli_query($connect, $query_select);
$array = mysqli_fetch_array($select);
$logarray = $array['login'];
  if($login == "" || $login == null){
    echo"<script language='javascript' type='text/javascript'>
    alert('O campo login deve ser preenchido');window.location.href='
    cadastro.html';</script>";

    }else{
      if($logarray == $login){

		echo"<script language='javascript' type='text/javascript'>
          alert('Este login já existe!');window.location.
          href='login.html'</script>";
		die();
      }else{
        $query = "INSERT INTO usuarios (login,senha) VALUES ('$login','$senha')";
        $insert = mysqli_query($connect, $query);

        if($insert){
          echo"<script language='javascript' type='text/javascript'>
          alert('Usuário cadastrado com sucesso!');window.location.
          href='login.html'</script>";
        }else{
          echo"<script language='javascript' type='text/javascript'>
          alert('Não foi possível cadastrar esse usuário');window.location
          .href='cadastro.html'</script>";
        }
      }
    }
	mysqli_close($connect);
?>