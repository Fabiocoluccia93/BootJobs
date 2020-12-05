<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Societa</title>
</head>
<body style="background: lime">
<h1 style="font:italic; size:5em; color:blue; text-align: center;">Pagina dedicata alle società</h1>
<hr>
<br>
<a href="IndexController?param=1"> Torna indietro</a>

<fieldset style=" border-color:red; margin-left: 200px; margin-right: 200px; margin-top: 100px; ">
		
	<form action="SocietaController" method="post">
	<input type="hidden" name="param" value="2">
	
		<label name="mail" >Mail società</label>
		<input type="email" name="mail">

		<br><br>
		
		<label name="password">Password</label>
		<input type="password" name="password">
	
		<br><br>
		
		<label name="pIva">Partiva Iva Società</label>
		<input type="text" name="pIva">
		<br><br>
		
		
		<label name="nome">Nome titolare</label>
		<input type="text" name="nomeTitolare">
		<br><br>
		
		<label name="cognome">Cognome titolare</label>
		<input type="text" name="cognomeTitolare">
		<br><br>
		
	
		<label name="nomeAzienda">Nome Azienda</label>
		<input type="text" name="nomeAzienda">
		<br><br>
		
		<label name="telefonoContatto">Contatto Telefonico</label>
		<input type="text" name="contattoTelefonico">
	
		<br><br>
		
		<label name="comuneSocieta">Comune della societa</label>
		<input type="text" name="comuneSocieta">
		
		<br><br>
		<button type="submit" value="Invia">Iscrizione</button>
		<br><br>
		<button type="reset" value="Reset">Reset</button>	
	
	
	</form>	

</fieldset>


</body>
</html>