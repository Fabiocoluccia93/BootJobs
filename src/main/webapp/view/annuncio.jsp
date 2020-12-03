<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="GestioneEventiSocieta" method="post">

		<br>inserire Evento<br>
		<br> seleziona il nome dell'evento: <input type='text'
			id='nomeEvento' name='nomeEvento' /> <br>
		Descrizione<input type='text' id='descrizione' name='descrizione' /> 
		<br>Tipologia <select name="tipologia">
			<option>tipo</option>
			<c:forEach items="${requestScope.tipo }" var="tipi">
				<option value="${tipi.tipologia }"
					${tipi.tipologia == tipologia ? 'selected = "selected"':'' }>${tipi.tipologia }</option>
			</c:forEach>
		</select> <br>
<!-- 		da qui prendo la data e me la porta su GestioniEventi societa sotto forma di String -->
		Data<input type="date" id='data' name='data' value="14/01/2017"> <br>
		<input type="hidden" name="param0" value="0"> <select
			name="comune">
			<option>comune</option>
			<c:forEach items="${requestScope.listaComuni}" var="eventi2">
				<option value="${eventi2.comune}"
					${eventi2.comune == comune? 'selected="selected"':''}>${eventi2.comune}
				</option>
			</c:forEach>
		</select>
		<button type="submit" value="Invia">Invia</button>
		<button type="reset" value="Cancella">Cancella</button>

	</form>
	<form action="ProvinciaEventi" method="post">
		<input type="hidden" name="param0" value="0"> <select
			name="regione">
			<option>regione</option>
			<c:forEach items="${sessionScope.regioni}" var="eventi">
				<option value="${eventi.regione}"
					${eventi.regione == regione ? 'selected="selected"':''}>${eventi.regione}
				</option>
			</c:forEach>
		</select>
		<button type="submit" value="Invia">Invia</button>
	</form>
</body>
</html>