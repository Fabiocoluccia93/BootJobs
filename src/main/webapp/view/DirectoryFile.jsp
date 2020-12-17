<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
            <form action="../../BootJobs/Amministratore_controller" method="get">
            Destinazione foto:
            <input type="text" value="" name="directoryimmagini"/>
            
          	<input type="hidden" name="param" value="0">
          	<input type="submit" value="upload" name="upload" id="upload">
            
            </form>
            
            <form action="../../BootJobs/Amministratore_controller" method="get">
             Destinazione curriculum:
            <input type="text" value="" name="directorydocumenti"/>
          
            <input type="hidden" name="param" value="1">
            <input type="submit" value="upload" name="upload" id="upload">
             </form>
             
              <a href="../../BootJobs">Homepage<a>
              
   <c:if test="${not empty message}">
    <h1>${message}</h1>
	</c:if>
</body>
</html>