<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="../ModificaAnnuncio_controller" method="get">
	
		Nome evento da modificare<input type='text' id='annuncioEsitente' name='annuncioEsistente' /><br>
		Nome annuncio<input type='text' id='nAnnuncio' name='nAnnuncio'/><br>
		Descrizione<input type='text' id='descrizione' name='descrizione'/><br>
		Titolo di studio<input type='text' id='tStudio' name='tStudio'/><br>
		Tipo contratto<input type='text' id='tContratto' name='tContratto'/><br>
		Stipendio<input type="text" id="stipendio" name="stipendio"/><br>
		Data<input type="date" id='data' name='data' value="14/01/2017"/><br>
		<select name="regione">
			<c:forEach items="${sessionScope.listaRegioni}" var="regioni">
				<option value="${regioni}">${regioni}</option>
			</c:forEach>
		</select><br>

		<button type="submit" value="Invia">Invia</button>
	</form>
</body>
</html>