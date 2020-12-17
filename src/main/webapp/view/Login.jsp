<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<form action="../Candidato_controller" method="post">
<p style="font:italic; color: black; font-size: 20px; padding-left: 80px; padding-bottom: 10px "> 
  <input type="email" name="mail" > <b>Mail</b> <br>
  <input type="password" name="password"> <b>Password</b> <br><br>
  <button type="submit" name="iscriviti"  style=" padding: 10px 70px; background: lime; "><b>Login</b></button><br><br>
<p>

<input type="hidden" name="param" value="2">
</form>
 <a href="../Candidato_controller?param=0">Iscriviti</a> o 
  <a href="../">Torna alla Homepage</a>



</fieldset>
</body>
</html>