<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cancella la societa</title>
</head>
<body>
<h1>Inserisci partita iva della societa da eliminare :</h1>
<br>
<br>
<a href="AmministratoreController?param=3">Torna indietro</a>
<br>
<br>

<br>
<br>


<form action="AmministratoreController" method="post">
<input type="hidden" name="param" value="1">
	<label >partita iva societa : </label>
	<input type="text" name="partitaIva">
	<button type="submit">ELIMINA</button>
</form>

<hr>
<br>
<% String eliminazioneOk = (String) request.getAttribute("eliminazioneEffettuata");
	String eliminazioneNo = (String) request.getAttribute("eliminazioneFallita");

	if(eliminazioneOk!=null){
	
		out.println(eliminazioneOk);
	
	}

	if (eliminazioneNo!=null){
	
		out.println(eliminazioneNo);
	
	}
%>


<br><br>

<table border = "2">
	<tr>
		<td><b>Partita iva</b></td>
		<td><b>Societa</b></td>
		<td><b>E-mail</b></td>
		<td><b>Nome</b></td>
		<td><b>Cognome</b></td>
		<td><b>Numero Telefonico</b></td>
	</tr>
	
	
	<c:forEach items="${requestScope.tutteSocieta}" var="s">
		<tr>
			<td><c:out value="${s.partitaIva}">${s.partitaIva }</c:out></td>
			<td><c:out value="${s.nomeAzienda}">${s.nomeAzienda }</c:out></td>
			<td><c:out value="${s.mail}">${s.mail }</c:out></td>
			<td><c:out value="${s.nome}">${s.nome }</c:out></td>
			<td><c:out value="${s.cognome}">${s.cognome }</c:out></td>
			<td><c:out value="${s.telefono}">${s.telefono }</c:out></td>
		</tr>
	</c:forEach>
	
	
</table>


</body>
</html>