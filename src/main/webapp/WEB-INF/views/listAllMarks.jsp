<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@page import="dao.*" %>
<%@page import="beans.*" %>
<%@page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List all Marks</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<body> 
<h2>Student Admissions System</h2>
<h3> List of Marks for <c:out value="${Student.f_name}" /></h3>


<table class="table">
			<tr>
				<th>Student ID</th>
				<th>Course ID</th>
				<th>Course Name</th>
				<th>Mark</th>
			</tr>
			<c:forEach var="var" items="${Marks}">
				<tr>
					<td><c:out value="${var.student_id.s_id}" /></td>
					<td><c:out value="${var.course_id.course_id}" /></td>
					<td><c:out value ="${var.course_id.course_name }" /></td>
					<td><c:out value="${var.mark}" /></td>
					<td><a href="<c:url value='/marks/edit/${var.id}' />">Edit</a></td>
					<td><a href="<c:url value='/marks/delete/${var.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
			
		
</table>

<p id="errormsg"> <c:out value="${errormsg}" /> </p>

<div class="list-group">
	<a class="list-group-item" href="<c:url value='/marks/add_page/${Student.s_id}' />">Add marks</a>
	<a class="list-group-item" href="<c:url value='/' />">Back to main page</a>
</div>

</body>
</html>