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
<table border="1">
  <thead>
    <tr>
      <th>First Name</th>
      <th>Middle Name</th>
      <th>Last Name</th>
    </tr>
  </thead>
  <tbody>
     <c:forEach items="${requestScope.annunci}" var="name">
       <tr>
         <td>${name.firstName}</td>
         <td>${name.middleName}</td>
         <td>${name.lastName}</td>
       </tr>
     </c:forEach>
  </tbody>
</table>
</body>
</html>