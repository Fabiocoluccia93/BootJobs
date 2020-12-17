<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BOOTJOBS</title>
</head>
<<<<<<< HEAD
<body style="background: lime">
<h1 style="font:italic; size:5em; color: blue; text-align: center; ">Benvenuto in BootJobs</h1>
<hr>


<p align="right">
<a  href="">iscrizione utente</a>
 | 
<a  href="IndexController?param=1">per le società</a>
</p>

<% String eliminazione=(String)request.getAttribute("cancellazione");
	String iscrizione=(String)request.getAttribute("iscrizioneOk");

	if(eliminazione!=null){
		out.println(eliminazione);
	}
	if(iscrizione!=null){
		out.println(iscrizione);
	}

%>

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



=======
<body>
	<form action="Ricerca_controller" method="post">
	<input type="hidden" name="param" value="1">
 	<input type="text" name="nomeAnnuncio" id="nomeAnnuncio">
 	<button type="submit">Cerca</button>
	
	</form>
>>>>>>> branch 'Test_fornaro_turrini' of https://github.com/Fabiocoluccia93/BootJobs.git
</body>
</html>