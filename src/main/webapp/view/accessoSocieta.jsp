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

<a href="index.jsp"> Torna alla HOMEPAGE</a>
<br>

<fieldset style=" border-color:red; margin-left: 200px; margin-right: 200px; margin-top: 100px; ">
		
	<form action="SocietaController" method="post">
	<input type="hidden"  name="param" value="1">
	
		<label name="mail" >Mail società</label>
		<input type="email" name="mail">
		<button type="submit" value ="Invia">ACCEDI</button>
		
		<br>
		
		<label name="password">Password</label>
		<input type="password" name="password">
		<button type="reset" value="cancella">RESET</button>
	
	
	
	</form>	

</fieldset>

<p style="font: oblique; font-size: medium; color: black; text-align: center;">Se sei una nuova società clicca <a href="IndexController?param=2">qui!</a></p>

</body>
</html>