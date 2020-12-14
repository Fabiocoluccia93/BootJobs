<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
Hello <b></b>!
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
				<tr>
					<td><%= request.getParameter("nome_annuncio") %></td>
					<td><%= request.getParameter("nome_annuncio") %></td>
					<td><%= request.getParameter("nome_annuncio") %></td>
					<td><%= request.getParameter("nome_annuncio") %></td>
					<td><%= request.getParameter("nome_annuncio") %></td>
					<td><%= request.getParameter("nome_annuncio") %></td>


				</tr>

		</tbody>
	</table>

</body>
</html>