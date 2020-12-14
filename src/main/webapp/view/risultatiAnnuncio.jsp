<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1">
		<thead>
			<tr>
				<th>Nome Annuncio</th>
				<th>Descrizione</th>
				<th>Titolo di Studio</th>
				<th>Tipo_contratto</th>
				<th>Stipendio</th>
				<th>Data pubblicazione</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach items="${requestScope.annunci}" var="annuncio">
				<tr>
					<td><a href="view/dettagliAnnuncio.jsp?nome_annuncio=${annuncio.nome_annuncio}">${annuncio.nome_annuncio}</a></td>
					<td>${annuncio.descrizione}</td>
					<td>${annuncio.titolo_di_studio}</td>
					<td>${annuncio.tipo_contratto}</td>
					<td>${annuncio.stipendio}</td>
					<td>${annuncio.data_pubblicazione}</td> 	
				</tr>
				</c:forEach>



		</tbody>
	</table>

</body>
</html>