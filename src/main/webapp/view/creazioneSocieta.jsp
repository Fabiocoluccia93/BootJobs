<%@page import="javax.print.DocFlavor.STRING"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Societa</title>
<script>
function getProvince() {
	

	var ajax = new XMLHttpRequest();
	var regioni = document.getElementById('regione').value;
	
	ajax.open('GET', '../Province_controller?regioni='+ regioni, true);
	
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
	
	ajax.open('GET', '../Comuni_controller?province='+ province, true);
	
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
<body style="background: lime">
<h1 style="font:italic; size:5em; color:blue; text-align: center;">Pagina dedicata alle società</h1>
<hr>
<br>
<a href="../IndexController?param=1"> Torna indietro</a>
<br>
<a href="../IndexController?param=3"">Torna alla HOMEPAGE</a>


<br><br>

<% String esistente=(String)session.getAttribute("societaEsistente");
	String campiVuoti=(String)session.getAttribute("campiVuoti");
	String errorePIVa=(String)session.getAttribute("partitaIvaErrata");

	if(esistente!=null){
		out.println(esistente);
	}

	else if(campiVuoti!=null){
		out.println(campiVuoti);
	}

	else if(errorePIVa!=null){
		out.println(errorePIVa);
	}
	
	session.removeAttribute("societaEsistente");
	session.removeAttribute("campiVuoti");
	session.removeAttribute("partitaIvaErrata");

%>

<fieldset style=" border-color:red; margin-left: 200px; margin-right: 200px; margin-top: 100px; ">
		
	<form action="../SocietaController" method="post">
	<input type="hidden" name="param" value="2">
	
		<label name="mail" >Mail società</label>
		<input type="email" name="mail">

		<br><br>
		
		<label name="password">Password</label>
		<input type="password" name="password">
	
		<br><br>
		
		<label name="pIva">Partiva Iva Società</label>
		<input type="text" name="pIva">
		<br><br>
		
		
		<label name="nome">Nome titolare</label>
		<input type="text" name="nomeTitolare">
		<br><br>
		
		<label name="cognome">Cognome titolare</label>
		<input type="text" name="cognomeTitolare">
		<br><br>
		
	
		<label name="nomeAzienda">Nome Azienda</label>
		<input type="text" name="nomeAzienda">
		<br><br>
		
		<label name="telefonoContatto">Contatto Telefonico</label>
		<input type="text" name="contattoTelefonico">
	
		<br><br>
		
		<label name="comuneSocieta">Comune della societa</label>
		
		<select name="tregione" id="regione" onchange="getProvince()">
			<option>Regione</option>
			<c:forEach items="${sessionScope.listaRegioni}" var="regioni">
				<option id="dRegione" value="${regioni}">${regioni}</option>
			</c:forEach>
			
		</select>
		<br> 
		
		<select id="province" onchange="getComuni()"></select>
		<br> 
		
		<select id="comuni" name="lComuni"></select>
		<br>
			
		
		<br><br>
		<button type="submit" value="Invia">Iscrizione</button>
		<br><br>
		<button type="reset" value="Reset">Reset</button>	
	
	
	</form>	

</fieldset>


</body>
</html>