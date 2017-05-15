<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@page import="dao.StudentDAO" %>
<%@page import="beans.Student" %>
<%@page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of all Students</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<body> 
<h2>Student Admissions System</h2>
<h3> List of ALL students </h3>
<table class="table">
			<tr>
				<th>Student ID</th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>

			<c:forEach var="student" items="${Students}">
			<tr>
				<td><c:out value="${student.s_id}" /></td>
				<td><c:out value="${student.f_name}" /></td>
				<td><c:out value="${student.l_name}" /></td>
				
				<td><a href="<c:url value='/students/edit/${student.s_id}' />">Edit</a></td>
				<td><a href="<c:url value='/students/delete/${student.s_id}' />">Delete</a></td>
				<td><a href="<c:url value='/marks/list/${student.s_id}' />">List all marks</a></td>
				
			</tr>
	</c:forEach>

</table>

<div class="list-group">
	<a class="list-group-item" href="<c:url value='/students/add_page' />">Add Student</a>
	<a class="list-group-item" href="<c:url value='/' />">Back to main page</a>
</div>


</body>
</html>