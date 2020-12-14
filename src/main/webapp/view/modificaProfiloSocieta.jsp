<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="societa" class="com.bootjobs.model.Societa" scope="session"></jsp:useBean>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home page societa</title>
</head>
<body style="background: lime;">
<h1 style="font: italic; color: blue; text-align: center;"><b>MODIFICA IL PROFILO DELLA TUA SOCIETA</b></h1>
<hr>
<br>

clicca<a href="SocietaController?param=3"> qui</a> per tornare indietro senza effettuare modifiche
<br><br>

<%	
	String passwordNO = (String)request.getAttribute("passwordErrata");
	
	if(passwordNO!=null){
		out.println(passwordNO);
		out.println("<br>"+"<br>");
	}


%>


<fieldset style=" border-color:red; margin-left: 200px; margin-right: 200px; margin-top: 100px; ">
		
	<form action="SocietaController" method="post">
	<input type="hidden" name="param" value="4">
	
		<label name="pIva">Partiva Iva Società : </label>
		<c:out value="${societa.partitaIva}">${societa.partitaIva }</c:out>
		<br><br>
		
		
		<label name="mail" >Mail società : </label>
		<c:out value="${societa.mail}">${societa.mail }</c:out>
		<br><br>
		
		<label name="nomeAzienda">Nome Azienda : </label>
		<c:out value="${societa.nomeAzienda}">${societa.nomeAzienda }</c:out>
		<br><br>
		
		<label name="comuneSocieta">Comune della societa : </label>
		<c:out value="${societa.nomeAzienda}">${societa.nomeAzienda }</c:out>
		
		<br><br>
		
		<label name="password"> Vecchia Password</label>
		<input type="password" name="vecchiaPassword">
	
		<br><br>
		
		<label name="password"> Nuova Password</label>
		<input type="password" name="nuovaPassword">
	
		<br><br>
		
		
		
		<label name="nome">Nome titolare</label>
		<input type="text" name="nomeTitolare">
		<br><br>
		
		<label name="cognome">Cognome titolare</label>
		<input type="text" name="cognomeTitolare">
		<br><br>
		
	
		
		<label name="telefonoContatto">Contatto Telefonico</label>
		<input type="text" name="contattoTelefonico">
	
		<br><br>
		
		<button type="submit" value="Invia">Conferma Modifiche</button>
		<br><br>
		<button type="reset" value="Reset">Reset</button>	
	
	
	</form>	

</fieldset>


</body>
</html>