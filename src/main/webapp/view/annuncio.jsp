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
<body style="background: lime">

	<form action="Annuncio_controller" method="get">
		
		
		<input type='text' id='nAnnuncio' name='nAnnuncio' />Nome annuncio <br>
		<input type='text' id='descrizione' name='descrizione' />Descrizione<br>
		<select name="tStudio">
		<option>Titolo di studio</option>
			<c:forEach items="${sessionScope.listaTitolo}" var="titolo">
				<option value="${titolo}">${titolo}</option>
			</c:forEach>
		</select><br>
		<select name="tContratti">
		<option>Tipo contratto</option>
			<c:forEach items="${sessionScope.listaContratti}" var="contratti">
				<option value="${contratti}">${contratti}</option>
			</c:forEach>
		</select><br> 
	<%-- <select name="categoria" id="idCategoria" onchange="getSottocategoria()">
		<option>Categoria</option>
			<c:forEach items="${sessionScope.}" var="cat">
				<option id="dRegione" value="${cat}">${cat}</option>
			</c:forEach>
		</select><br> --%>
	<%--<select name="sottoCategoria" id="idSoCategoria">
		<option>Sottocategoria</option>
			
		</select><br> --%>
		<input type="text" id="stipendio" name="stipendio">Stipendio<br>
		<input type="date" id='data' name='data' value="14/01/2017">Data<br>
		<select name="tregione" id="regione" onchange="getProvince()">
		<option>Regione</option>
			<c:forEach items="${sessionScope.listaRegioni}" var="regioni">
				<option id="dRegione" value="${regioni}">${regioni}</option>
			</c:forEach>
		</select><br> <select id="province" onchange="getComuni()">
		</select> <br> <select id="comuni" name="lComuni">
		</select><br>


		<button type="submit" value="Invia">Invia</button>

	</form>

</body>
</html>