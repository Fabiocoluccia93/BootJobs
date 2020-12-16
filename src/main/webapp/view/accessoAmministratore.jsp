<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>pagina amministrativa</title>
</head>
<body>
<h1>PAGINA AMMINISTRATIVA</h1>
<br> <br>
<hr>

<% String accessoNegato=(String)request.getAttribute("accessoNegatoAmministratore");

	if(accessoNegato!=null){
		out.println(accessoNegato);
		out.println("<br>");
		out.println("<br>");
	}
		
	%>

<form action="AccessoAmministratore"  method="post">
	<input type="hidden" name="param" value="1">
	<input type="text" name="username"><br>
	<input type="password" name="password"><br>
	<button	type="submit">INVIA</button>
	<button type="reset">CANCELLA</button>
</form>
	


</body>
</html>