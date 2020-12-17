<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<title>File Upload</title>
<!--         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
        <script>
function getProvince() {
	

	var ajax = new XMLHttpRequest();
	var regioni = document.getElementById('regione').value;
	
	ajax.open('GET', '../Province_Controller?regioni='+regioni, true);

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
	
	ajax.open('GET', '../Comuni_Controller?province='+ province, true);

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
<body>
<body style="background: lime">

<h1 style="font:italic; size:5em; color: black; text-align: center; ">Iscriviti a BootJobs${profilo.nome}</h1>
<fieldset style="background: lime ; border-color: lime; padding-left: 2px; margin-left: 200px; margin-right: 200px;
 margin-top: 10px; "> 
  

<form action="../../BootJobs/Candidato_controller" method="POST" enctype="multipart/form-data" >
<input type="email" name="mail">Mail<br>
<input type="password" name="password">Password <br>	
<input type="text" name="nome">Nome<br>
<input type="text" name="cognome">Cognome<br>
<input type="text" name="titolo_studio">Titolo di Studio<br>
<input type="text"  name="numero_telefono">Numero di Telefono<br>

<select name="tregione" id="regione" onchange="getProvince()">
			<c:forEach items="${sessionScope.listaRegioni}" var="regioni">
				<option id="dRegione" value="${regioni}">${regioni}</option>
			</c:forEach>
		</select><br> <select id="province" onchange="getComuni()">

		</select> <br> <select id="comuni" name="lComuni">

		</select><br>
		
<input type="date" name="data_nascita">Data di nascita<br>
Seleziona la foto da caricare      <input type="file" name="file" id="file" /> <br/>
Seleziona il curriculum da caricare      <input type="file" name="file1" id="file1" /> <br/>
<!-- seleziona il curriculum da caricare:<input type="file" name="docname"><br> -->
<input type="hidden" name="param" value="1"><br>
<button type="submit" name="iscriviti" >Iscriviti</button>
</form>
 <c:if test="${not empty message}">
    <h1>${message}</h1>
    <a href="../BootJobs">Homepage</a>
	</c:if>
</fieldset>



</body>
</html>