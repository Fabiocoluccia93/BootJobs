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
<h1 style="font: italic; color: blue; text-align: center;"><b>HOME PAGE DELLA SOCIETA</b></h1>
<hr>
<br>

<a href="IndexController?param=4"> Torna alla HOME PAGE</a>

<br><br>

<%	String modificaOk= (String)request.getAttribute("modificaOK");

	if(modificaOk!=null){
		out.println(modificaOk);
		out.println("<br>"+"<br>");
	}

%>


<table border="2" >
	<tr>
		<td><b>Partita iva</b></td>
		<td><b>Societa</b></td>
		<td><b>E-mail</b></td>
		<td><b>Nome</b></td>
		<td><b>Cognome</b></td>
		<td><b>Numero Telefonico</b></td>
		<td><b>password</b></td>
		
	</tr>

		<tr>
			<td><c:out value="${societa.partitaIva}">${societa.partitaIva }</c:out></td>
			<td><c:out value="${societa.nomeAzienda}">${societa.nomeAzienda }</c:out></td>
			<td><c:out value="${societa.mail}">${societa.mail }</c:out></td>
			<td><c:out value="${societa.nome}">${societa.nome }</c:out></td>
			<td><c:out value="${societa.cognome}">${societa.cognome }</c:out></td>
			<td><c:out value="${societa.telefono}">${societa.telefono }</c:out></td>
			<td><c:out value="${societa.password}">${societa.password }</c:out></td>
		</tr>
</table>	


<br><br>
<a href="SocietaController?param=1">Modifica profilo</a>
<br><br>
<a href="SocietaController?param=2" style="color: red;">Elimina profilo della societa</a>	
	
	



</body>
</html>