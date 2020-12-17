<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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



</script>
</head>
<body style="background: green;">
	<form action="ModificaAnnuncio_controller" method="get">
	
		<input type="hidden" value="<%= session.getAttribute("idAnnuncio") %>" name="id">
		Nome annuncio<input type='text' id='nAnnuncio' name='nAnnuncio' /> <br>
		Descrizione<input type='text' id='descrizione' name='descrizione' /><br>
		<select name="tStudio">
		<option>Titolo di studio</option>
			<c:forEach items="${sessionScope.listaTitolo}" var="titolo">
				<option value="${titolo}">${titolo}</option>
			</c:forEach>
		</select><br>
		<select name="tContratti">
		<option>Tipo contratto </option>
			<c:forEach items="${sessionScope.listaContratti}" var="contratti">
				<option value="${contratti}">${contratti}</option>
			</c:forEach>
		</select><br> 
		Stipendio<input type="text" id="stipendio" name="stipendio"><br>
		Data<input type="date" id='data' name='data' value="14/01/2017"><br>
		<select name="tregione" id="regione" onchange="getProvince()">
		<option>Regioni </option>
			<c:forEach items="${sessionScope.listaRegioni1}" var="regioni">
				<option id="dRegione" value="${regioni}">${regioni}</option>
			</c:forEach>
		</select><br> <select id="province" onchange="getComuni()">
		</select> <br> <select id="comuni" name="lComuni">
		</select><br>


		<button type="submit" value="Invia">Invia</button>
	</form>
</body>
</html>