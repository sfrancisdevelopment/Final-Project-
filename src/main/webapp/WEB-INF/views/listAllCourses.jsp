<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@page import="dao.CoursesDAO" %>
<%@page import="beans.Courses" %>
<%@page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of all Courses</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<body> 
<h2>Student Admissions System</h2>
<h3> List of ALL Courses </h3>
<table class="table">
			<tr>
				<th>Course ID</th>
				<th>Course Name</th>
			</tr>

			<c:forEach var="var" items="${Courses}">
			<tr>
				<td><c:out value="${var.course_id}" /></td>
				<td><c:out value="${var.course_name}" /></td>
				
				<td><a href="<c:url value='/courses/edit/${var.course_id}' />">Edit</a></td>
				<td><a href="<c:url value='/courses/delete/${var.course_id}' />">Delete</a></td>
				
				
			</tr>
	</c:forEach>

</table>

<div class="list-group">
	<a class="list-group-item" href="<c:url value='/courses/add_page' />">Add Course</a>
	<a class="list-group-item" href="<c:url value='/' />">Back to main page</a>
</div>

</body>
</html>