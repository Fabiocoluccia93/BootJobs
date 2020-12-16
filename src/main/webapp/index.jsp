<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BOOTJOBS</title>
</head>

<body>
<a href="view/Login.jsp">Area Utente</a>
<!-- <a href="view/uploadfoto.jsp">prova carica foto<a> -->
<!-- <a href="view/oracleuload.jsp">prova carica foto oracle<a> -->
<!-- <a href="view/destinazione.jsp"> prova carica foto con destinazione<a> -->
<a href="view/destinazionecontroller.jsp">destinazione foto<a>
<!-- <a href="view/visualizzaimmagine.jsp">prova visualizzazione immagini<a> -->
<a href="view/invioCandidatura.jsp">prova invio candidatura<a>
<a href="view/annuncio.jsp">annuncio<a>

<body style="background: lime">
<h1 style="font:italic; size:5em; color: blue; text-align: center; ">Benvenuto in BootJobs</h1>
<hr>


<p align="right">
<a  href="">iscrizione utente</a>

<a  href="">per le società</a>
</p>


<fieldset style="background: white; border-color: red; padding-left: 200px; margin-left: 50px; margin-right: 50px;
margin-top: 100px; ;">
		
		<form action="" method="post">
				<input type="text" name="offerte">
				<button type="submit" value="Ricercaofferta">Ricerca offerte</button> 
		</form>
		<form action="" method="post">
				<input type="text" name="luogo">
				<button type="submit" value="Ricercaluogo">Ricerca per luogo</button> 
		</form>

</fieldset>




</body>
</html>