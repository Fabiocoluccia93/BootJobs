<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME PAGE AMMINISTRATORE</title>
</head>
<body>
<h1 style="font: italic;color: blue; text-align: center;">BENVENUTO, SCEGLI QUALE OPERAZIONE EFFETTUARE</h1>
<hr>
<br>

<a href="AmministratoreController?param=1"> Pagina per eliminare una societa</a>
<br>
<br>
<a href="view/DirectoryFile.jsp">DirectoryFile</a>
<br><br>

<form action="AmministratoreController" method="post">
<input type="hidden" name="param" value="4">	
	<button type="submit" name="logout"> LOGOUT</button>

</form>


</body>
</html>