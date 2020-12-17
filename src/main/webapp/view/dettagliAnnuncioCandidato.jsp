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
<form action="../CandidaturaController" method="post">
<input type="hidden" value="<%= request.getParameter("id") %>" name="annuncio">
<input type="hidden" value="<%= request.getParameter("idS") %>" name="societa">
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
					<td><%= request.getParameter("nome_annuncio") %></td>
					<td><%= request.getParameter("descrizione") %></td>
					<td><%= request.getParameter("titolo") %></td>
					<td><%= request.getParameter("tipo") %></td>
					<td></td>
					<td></td>
					<td><%= request.getParameter("stipendio") %></td>
					<td><%= request.getParameter("data") %></td>
					<td><%= request.getParameter("comune") %></td>
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