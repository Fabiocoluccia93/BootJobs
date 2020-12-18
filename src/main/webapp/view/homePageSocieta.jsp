<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="societa" class="com.bootjobs.model.Societa" scope="session"></jsp:useBean>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home page societa</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">

<script>
function getProvince() {
	

	var ajax = new XMLHttpRequest();
	var regioni = document.getElementById('regione').value;
	
	ajax.open('GET', 'Province_controller?regioni='+ regioni, true);
	
	ajax.onload = function() {
		
	if(this.status == 200) {
		
	document.getElementById('province').innerHTML = this.responseText;
			
		} else if (this.status == 400) {
			
			document.getElementeById('province').innerHTML = "risorsa non trovata!";
		}
	}
	
	ajax.send();
}

function getComuni(){

	var ajax = new XMLHttpRequest();
	var province = document.getElementById('province').value;
	
	ajax.open('GET', 'Comuni_controller?province='+ province, true);
	
	ajax.onload = function() {
		
	if(this.status == 200) {
		

	document.getElementById('comuni').innerHTML = this.responseText;
			
		} else if (this.status == 400) {
			
			document.getElementeById('comuni').innerHTML = "risorsa non trovata!";
		}
	}
	
	ajax.send();
}

function getSottocategoria(){

	var ajax = new XMLHttpRequest();
	var cat = document.getElementById('idCategoria').value;
	
	ajax.open('GET', 'Categoria_controller?cat='+ cat, true);
	
	ajax.onload = function() {
		
	if(this.status == 200) {
		

	document.getElementById('idSoCategoria').innerHTML = this.responseText;
			
		} else if (this.status == 400) {
			
			document.getElementeById('idSoCategoria').innerHTML = "risorsa non trovata!";
		}
	}
	
	ajax.send();
}




</script>
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


<table border="2" class="table">
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


<table border="1" class="table">
		<thead>
			<tr>
				<th scope="col">Nome Annuncio</th>
				<th scope="col">Descrizione</th>
				<th scope="col">Tipo_contratto</th>
				<th scope="col">Data pubblicazione</th>
				<th scope="col">Comune</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sessionScope.annunci}" var="annuncio">
				<tr>
					<td scope="row" ><a style="color: red;"
						href="view/dettagliAnnuncioSocieta.jsp?nome_annuncio=${annuncio.nome_annuncio}
						&descrizione=${annuncio.descrizione}
						&comune=${annuncio.comune}
						&id=${annuncio.id}
						&titolo=${annuncio.titolo_di_studio}
						&tipo=${annuncio.tipo_contratto}
						&stipendio=${annuncio.stipendio}
						&data=${annuncio.data_pubblicazione}">${annuncio.nome_annuncio}</a></td>
						
					<td>${annuncio.descrizione}</td>
					<td>${annuncio.tipo_contratto}</td>
					<td>${annuncio.data_pubblicazione}</td>
					<td>${annuncio.comune}</td>
					
				</tr>
			</c:forEach>
</tbody>
</table>
<br><br>
<a href="SocietaController?param=1">Modifica profilo</a>
<br><br>
<a href="Territorio_controller">Inserisci annuncio</a>
<br><br>
<a href="SocietaController?param=2" style="color: red;">Elimina profilo della societa</a>	
	
	



</body>
</html>