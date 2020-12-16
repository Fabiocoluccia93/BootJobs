<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background: green;">

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
			<c:forEach items="${requestScope.annunci}" var="annuncio">
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
	<form action="Territorio_controller" method="get">
	<button type="submit" class="btn btn-dark">Inserisci annuncio</button>
	</form>
</body>
</html>