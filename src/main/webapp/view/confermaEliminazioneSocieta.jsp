<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONFERMA SCELTA</title>
</head>
<body style="background: lime;">
<h1 style="font: italic;color: blue; text-align: center; size: 5em;"><b>ATTENZIONE!!</b></h1>
<h1 style="font: italic;color: blue; text-align: center;">se confermi questa scelta non potrai tornare indietro!</h1>
<hr><br><br><br>
<a href="SocietaController?param=3">clicca qui per annullare</a>
<br><br>

<!-- <form action="SocietaController" method="post"> -->
<!-- <input type="hidden" name="param" value="3"> -->
<!-- 	<button type="submit" name="cancella">ELIMINA PROFILO</button> -->
<!-- </form> -->

<form action="SocietaController" method="post">
<input type="hidden" name="param" value="3">
	<button type="submit" name="cancella">ELIMINA PROFILO</button>
</form>



</body>
</html>