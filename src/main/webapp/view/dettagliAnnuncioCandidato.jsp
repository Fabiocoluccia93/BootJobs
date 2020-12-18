<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<jsp:useBean id="annuncio" class="com.bootjobs.model.Annuncio" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body style="background: lime">
<form action="../../BootJobs/CandidaturaController" method="post">
<input type="hidden" value="${annuncio.id}" name="annuncio">
<input type="hidden" value="${annuncio.id_societa_annuncio}" name="societa">
<table border="1" class="table">
		<thead>
			<tr>
				<th scope="col">Nome Annuncio</th>
				<th scope="col">Descrizione</th>
				<th scope="col">Titolo di Studio</th>
				<th scope="col">Tipo_contratto</th>
				<th scope="col">Categoria</th>
				<th scope="col">Sottocategoria</th>
				<th scope="col">Stipendio</th>
				<th scope="col">Data pubblicazione</th>
				<th scope="col">Comune</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
				<tr>
				
					<td><c:out value="${annuncio.nome_annuncio}"></c:out></td>
					<td><c:out value="${annuncio.titolo_di_studio}"></c:out></td>
					<td><c:out value="${annuncio.tipo_contratto}"></c:out></td>
					<td><c:out value="${annuncio.descrizione}"></c:out></td>
					<td></td>
					<td></td>
					<td><c:out value="${annuncio.stipendio}"></c:out></td>
					<td><c:out value="${annuncio.data_pubblicazione}"></c:out></td>
					<td><c:out value="${annuncio.comune}"></c:out></td>
					<td><button type="submit" class="btn btn-dark">Candidati</button>
					
				</tr>

		</tbody>
	</table>
	
  <c:if test="${not empty message}">
    <h1>${message}</h1>
	</c:if>
	
</form>
</body>
</html>