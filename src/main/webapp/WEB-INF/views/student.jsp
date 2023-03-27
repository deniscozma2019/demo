<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>

</head>
<body>
<table>
<c:forEach items="${allStudents}" var="student">

    <tr>      
        <td>${student.name}</td>
        <td>${student.age}</td>
        <td>${student.group}</td>
        <td>${student.b_day}</td> 
        <td><form action="http://localhost:8080/student?id=${student.id}" method="DELETE"><input type="submit" value="delete" /></form></td>
    </tr>
</c:forEach>
</table>

</body>
</html>
<style type="text/css"> 
	table{
		border-collapse: collapse;
	    margin: 25px 0;
	    font-size: 0.9em;
	    font-family: sans-serif;
	    min-width: 400px;
	    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
	}
</style> 