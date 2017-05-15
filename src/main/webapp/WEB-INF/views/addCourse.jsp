<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Student</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<body>

<h2>Student Admissions System</h2>

<h3>Fill out the following to add a course:</h3>
<div>
<form:form method="POST" action="/TestingProject/courses/add" modelAttribute="courses" class="form-horizontal">
	<div class="form-group">
    	<label class="control-label col-sm-2" for="course_name">Course Name:</label>
	    <div class="col-sm-10">
	      	<form:input type="text" id="course_name" path="course_name" />
	    </div>
  	</div>
	
	<div class="form-group"> 
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">Submit</button>
	    </div>
 	</div>
</form:form>
</div>

<div class="list-group">
	<a class="list-group-item" href="<c:url value='/' />">Back to main page</a>
	<a class="list-group-item" href="<c:url value='/students/list' />">List all the Students</a>
</div>


</body>
</html>