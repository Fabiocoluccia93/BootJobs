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
	
	ajax.open('GET', 'Province_controller', true);
	
	ajax.onload = function() {
		
	if(this.status == 200) {
		

	document.getElementById('province').innerHTML = this.responseText;
			
		} else if (this.status == 400) {
			
			document.getElementeById('province').innerHTML = "risorsa non trovata!";
		}
	}
	
	ajax.send();
}

function test(){

	var ajax = new XMLHttpRequest();
	
	ajax.open('GET', 'Province_controller', true);
	
	ajax.onload = function() {
		if(this.status == 200) {
			
			var tregioni = document.getElementById('dRegione');
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
		Stipendio<input type="text" id="stipendio" name="stipendio"><br>
		Data<input type="date" id='data' name='data' value="14/01/2017"><br>
		<select name="regione" >
			<c:forEach items="${sessionScope.listaRegioni}" var="regioni">
				<option id="dRegione" onclick="test()" value="${regioni}">${regioni}</option>
			</c:forEach>
		</select><br> 

		<select id="province">

		</select>


		<button type="submit" value="Invia">Invia</button>

	</form>

	<a href="view/modifica.jsp">Modifica evento</a>
</body>
</html>