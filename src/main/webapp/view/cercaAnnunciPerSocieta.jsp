<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cerca annunci di una societa</title>
</head>
<body>

<h1>Inserisci nome della societa per visualizzare annunci relativi</h1>
<br>
<br>
<a href="AmministratoreController?param=3">Torna indietro</a>
<br>
<br>

<br>
<br>


<form action="AmministratoreController" method="post">
<input type="hidden" name="param" value="2">
	<label >Partita iva</label>
	<input type="text" name="pIva">
	<button type="submit">CANCELLA</button>
</form>

<hr>
<br>


//tabella degli annunci con le relative societa
<table border = "2">
	<tr>
		<td><b>Partita iva</b></td>
		<td><b>Societa</b></td>
		<td><b>E-mail</b></td>
		<td><b>Nome</b></td>
		<td><b>Cognome</b></td>
		<td><b>Numero Telefonico</b></td>
	</tr>

</body>
</html>