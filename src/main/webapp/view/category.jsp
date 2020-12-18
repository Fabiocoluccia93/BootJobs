<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background: lime">
<h1 style="font:italic; size:5em; color: blue; text-align: center; ">Categorie</h1>


<div align="center">
    <h2>Dynamic Drop Down List Demo</h2>
    <form action="list" method="post">
        <select name="category">
            <c:forEach items="${requestScope.BootJobs}" var="category">
                <option value="${category}"
                    >
                    ${category}
                </option>
            </c:forEach>
        </select>
        <br/><br/>
        <input type="submit" value="Submit" />
    </form>
</div>

</body>
</html>