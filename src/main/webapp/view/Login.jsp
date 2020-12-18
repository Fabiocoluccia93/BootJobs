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
<body style="background: lime">
<h1 style="font:italic; size:5em; color: black; text-align: center; ">Login in BootJobs</h1>

<fieldset style="background: lime ; border-color: lime; padding-left: 80px; margin-left: 400px; margin-right: 400px;
margin-top: 10px; ;">

<form action="../../BootJobs/Candidato_controller" method="post">
<p style="font:italic; color: black; font-size: 20px; padding-left: 80px; padding-bottom: 10px "> 
  <input type="email" name="mail" > <b>Mail</b> <br>
  <input type="password" name="password"> <b>Password</b> <br><br>
  <button type="submit" name="iscriviti"  style=" padding: 10px 70px; background: lime; "><b>Login</b></button><br><br>
<p>

<c:if test="${not empty message}">
    <h3>${message}</h3>
	</c:if>
	
<input type="hidden" name="param" value="2">
</form>
 <a href="../../BootJobs/Candidato_controller?param=0">Iscriviti</a> o 
  <a href="../../BootJobs/">Torna alla Homepage</a>
  
 
	
</fieldset>
	
</body>
</html>