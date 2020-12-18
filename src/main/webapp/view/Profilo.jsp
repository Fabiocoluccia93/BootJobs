<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
   <script>
function getProvince() {
	

	var ajax = new XMLHttpRequest();
	var regioni = document.getElementById('regione').value;
	
	ajax.open('GET', 'Province_controller?regioni='+regioni, true);

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
	
	ajax.open('GET', 'Comuni_controller?province='+ province, true);

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
<style>
#myDIV {
  display: none;
  width: 100%;
  padding: 0px 0;
  text-align: center;
  background-color: lime;
  margin-top: 0px;
}
 {
        box-sizing: border-box;
    }
    /* Set additional styling options for the columns */
    .column {
    float: left;
    }
 	.foto {
    width: 35%;
    }
    /* Set width length for the left, right and middle columns */
    .left {
    width: 20%;
    }

    .middle {
    width: 20%;
    }
    
    .right {
    width: 20%;
    }

    .row:after {
    content: "";
    display: table;
    clear: both;
    }
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<body style="background: lime">

<h1 style="font:italic; size:5em; color: black; text-align: center; ">Benvenuto ${profilo.nome}</h1>



<fieldset style="background: lime ; border-color: lime; padding-left: 2px; margin-left: 200px; margin-right: 200px;
 margin-top: 10px; "> 
  
	
	
   
  
   
	
 

  <div class="row">
  		<div class="column foto">
  <img src="http://localhost:8080/BootJobs/Candidato_controller?param=6" width="250px" height="250px"><br>
  <a href="http://localhost:8080/BootJobs/Candidato_controller?param=7">Download Curriculum</a>
  </div>
  
  
        <div class="column left">
        <label style="width:200px; display: inline-block;"> ID      </label>
            <label style="width:200px; display: inline-block;"> Nome      </label>
            <label style="width:200px; display: inline-block;"> Cognome   </label>
            <label style="width:200px; display: inline-block;"> Data di nascita </label>  
            <label style="width:200px; display: inline-block;"> Titolo di studio </label>  
            <label style="width:200px; display: inline-block;"> Numero di telefono </label>
            <label style="width:200px; display: inline-block;"> Comune di residenza </label> 
            <label style="width:200px; display: inline-block;"> Mail </label> 
            
        </div>
        <div class="column middle">
        <label style="width:200px; display: inline-block;"> ${profilo.id_candidato  }    </label>
            <label style="width:200px; display: inline-block;" >${profilo.nome} </label>
			<label style="width:200px; display: inline-block;" >${profilo.cognome} </label>
			<label style="width:200px; display: inline-block;"> ${profilo.data_nascita} </label>
			<label style="width:200px; display: inline-block;" >${profilo.titolo_studio} </label>
			<label style="width:200px; display: inline-block;" > ${profilo.numero_telefono}</label>
			<label style="width:200px; display: inline-block;">  ${profilo.comune_candidato} </label>
			<label style="width:200px; display: inline-block;">  ${profilo.mail} </label>
        </div>
        <div class="column right">
             <div id="myDIV">
		  		<form action="Candidato_controller" method="post"> 
		  		<input type="hidden"  name="id" value='${profilo.id_candidato}'><br>
		  		<input type="text"  name="nome" value="<c:out value='${profilo.nome}' />"/><br>
		  		<input type="text" name="cognome" value="<c:out value='${profilo.cognome}' />"/><br>
		  		
		  		<input type="date" name="data_nascita" id="demo" /> <br>
		  		
			  	<select name="titolo_studio">
					
						<option selected="selected" value="${profilo.titolo_studio}">${profilo.titolo_studio} </option>
						
					<c:forEach items="${sessionScope.listaTitolo}" var="titolo">
						<option value="${titolo}">${titolo}</option>
						
						</c:forEach>
				</select><br>
			  	<input type="text" name="numero_telefono" value="<c:out value='${profilo.numero_telefono}' />"/><br>
		  		<select name="tregione" id="regione" onchange="getProvince()">
		  		<option selected="selected" >usa i 3 menu per cambiare comune</option>
			     <c:forEach items="${sessionScope.listaRegioni}" var="regioni">
				 <option id="dRegione" value="${regioni}">${regioni}</option>
			    </c:forEach>
		        </select><br> <select id="province" onchange="getComuni()">
					</select> <br> <select id="comuni" name="lComuni">
					<option selected="selected" value="${profilo.comune_candidato}">${profilo.comune_candidato}</option>
					</select><br>
		  		<input type="text"  name="mail" value="<c:out value='${profilo.mail}' />"/><br>
		  		<input type="hidden"  name="password" value='${profilo.password}'>
		  		<input type="hidden" name="param" value="4">
		  		Premi il tasto per effettuare la modifica<br>
		  		<input type="submit" value="Modifica Profilo">
		  		</form>
		  		<br><br>
		  		<form action="Candidato_controller" method="post" enctype="multipart/form-data"> 
		  		Seleziona la foto da caricare<input type="file" name="file2" id="file2" />
		  		<input type="hidden" name="id" value='${profilo.id_candidato}'>
		  		<input type="hidden" name="nome" value='${profilo.nome}'>
		  		<input type="hidden" name="cognome" value='${profilo.cognome}'>
		  		<input type="hidden" name="data_nascita" value='${profilo.data_nascita}'>
		  		<input type="hidden" name="titolo_studio" value='${profilo.titolo_studio}'>
		  		<input type="hidden" name="numero_telefono" value='${profilo.numero_telefono}'>
		  		<input type="hidden" name="comune" value='${profilo.comune_candidato}'>
		  		<input type="hidden" name="mail" value= '${profilo.mail}'>
		  		<input type="hidden" name="param" value="8"> <br>
		  		Premi il tasto per effettuare la modifica<br>
		  		<input type="submit" value="Modifica Foto">
		  		</form>
		  		<br><br>
		  		<form action="Candidato_controller" method="post" enctype="multipart/form-data"> 
		  		Seleziona il curriculum da caricare<input type="file" name="file3" id="file3" /> 
		  		<input type="hidden" name="id" value='${profilo.id_candidato}'>
		  		<input type="hidden" name="nome" value='${profilo.nome}'>
		  		<input type="hidden" name="cognome" value='${profilo.cognome}'>
		  		<input type="hidden" name="data_nascita" value='${profilo.data_nascita}'>
		  		<input type="hidden" name="titolo_studio" value='${profilo.titolo_studio}'>
		  		<input type="hidden" name="numero_telefono" value='${profilo.numero_telefono}'>
		  		<input type="hidden" name="comune" value='${profilo.comune_candidato}'>
		  		<input type="hidden" name="mail" value= '${profilo.mail}'>
		  		<input type="hidden" name="param" value="9"> <br>
		  		Premi il tasto per effettuare la modifica<br>
		  		<input type="submit" value="Modifica Curriculum">
		  		</form>
  </div>
        </div>
    </div>
  
  
 
 	
   
  
   
   <c:if test="${not empty message}">
    <h1>${message}</h1>
	</c:if>
	
	
	

 </fieldset>
 
 <fieldset style="background: lime ; border-color: lime; padding-left: 2px; margin-left: 200px; margin-right: 200px;
 margin-top: 0px; "> 
 <div class="row">
 <div class="column foto"></div>
<div class="column left">
  <form action="Candidato_controller" method="post">
    <input type="hidden" name="ide" value='${profilo.id_candidato}'>
    <input type="hidden" name="param" value="3">
	<input type="submit" value="Elimina Profilo">
	</form>
	</div>
	
	
	<div class="column middle">
   <button onclick="myFunction()">modifica</button>
   </div>
   <div class="column right">
   <a href="../BootJobs">Homepage</a>
   </div>
   </div>
  </fieldset>
     <script>
function myFunction()
{
  var x = document.getElementById("myDIV");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
<%--   <%=(String)session.getAttribute("data1") %> --%>
<%-- <%=request.getAttribute("data1").toString()%>"  --%>
  document.getElementById("demo").value = '${sessionScope.data1}';
  var xhr = new XMLHttpRequest();
  xhr.open('GET', 'Candidato_controller?param=10', true);
  xhr.send();
}
</script>
</body>
</html>