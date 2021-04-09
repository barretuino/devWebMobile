<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SOBRE</title>
</head>
<?php
include "css.php";
?>
<body>

<div id="fundo_paginas">
	
	<div id="geral_paginas">
		
		
<?php
include "menu.php";
?>
		
		
	 	<div id="conteudo">
	    	<div id="titulo_pagina">
				<p>Contato</p>
			</div><!--titulo_pagina-->
	  	
			<form id="form1" name="form1" method="post" action="">
		  <table width="327" border="0">
            <tr>
              <th width="80" scope="row"><div align="left">Nome</div></th>
              <td width="237"><label>
                <input name="nome" type="text" id="form" size="35" maxlength="100" />
              </label></td>
            </tr>
            <tr>
              <th scope="row"><div align="left">Email</div></th>
              <td><label>
                <input name="email" type="text" id="form" size="35" />
              </label></td>
            </tr>
            <tr>
              <th scope="row"><div align="left">Cidade</div></th>
              <td><label>
                <input name="cidade" type="text" id="form" size="35" />
              </label></td>
            </tr>
            <tr>
              <th scope="row"><div align="left">Mensagem</div></th>
              <td><label>
                <textarea name="mensagem" cols="40" rows="6" id="form"></textarea>
              </label></td>
            </tr>
            <tr>
              <th scope="row">&nbsp;</th>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <th scope="row">&nbsp;</th>
              <td><label>
                <input type="submit" name="Submit" value="   Enviar   " />
              </label></td>
            </tr>
          </table>
        </form>		
	<center>
        <?php
        include "conexao/conexao.php";
        ?>
	</center>
		</div><!--conteudo-->
	  
	  <div style="clear:both">
	
	</div><!-- geral_paginas -->
	
</div><!--fundo_paginas-->

</body>
</html>
