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
<body>

	<form action="Annuncio_controller" method="get">

		Nome annuncio<input type='text' id='nAnnuncio' name='nAnnuncio' /> <br>
		Descrizione<input type='text' id='descrizione' name='descrizione' /><br>
		Titolo di studio<input type='text' id='tStudio' name='tStudio' /><br>
		Tipo contratto<input type='text' id='tContratto' name='tContratto' /><br>
		<select name="tContratti">
			<c:forEach items="${sessionScope.listaContratti}" var="contratti">
				<option  value="${contratti}">${contratti}</option>
			</c:forEach>
		</select><br> 
		Stipendio<input type="text" id="stipendio" name="stipendio"><br>
		Data<input type="date" id='data' name='data' value="14/01/2017"><br>
		<select name="tregione" id="regione" onchange="getProvince()">
			<c:forEach items="${sessionScope.listaRegioni}" var="regioni">
				<option id="dRegione"  value="${regioni}">${regioni}</option>
			</c:forEach>
		</select><br> 
		
		<select id="province" onchange="getComuni()">

		</select> <br>
		<select id="comuni" name="lComuni">
			
		</select>


		<button type="submit" value="Invia">Invia</button>

	</form>

	<a href="view/modifica.jsp">Modifica evento</a>
</body>
</html>