<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function getCategory() {
	

	var ajax = new XMLHttpRequest();
	var category = document.getElementById('id_category').value;
	
	ajax.open('GET', 'Category_controller?category='+ category , true);
	
	ajax.onload = function() {
		
	if(this.status == 200) {
		
	document.getElementById('id_subcategory').innerHTML = this.responseText;
			
		} else if (this.status == 400) {
			
			document.getElementeById('id_subcategory').innerHTML = "risorsa non trovata!";
		}
	}
	
	ajax.send();
}
</script>  
</head>
<body style="background: lime">
<h1 style="font:italic; size:5em; color: blue; text-align: center; ">Categorie</h1>


<div align="center">
    <h2>Dynamic Drop Down List Demo</h2>
    <form action="list" method="post">
        <select name="category" id="id_category" onchange="getCategory">
            <c:forEach items="${requestScope.BootJobs}" var="category">
                <option value="${category}"
                    >
                    ${category}
                </option>
            </c:forEach>
        </select>
<select name="subcategory" id="id_subcategory">
</select>
        <br/><br/>
        <input type="submit" value="Submit" />
    </form>
</div>

</body>
</html>