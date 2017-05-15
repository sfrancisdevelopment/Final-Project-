<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Student</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<body>

<h2>Student Admissions System</h2>

<h3>Fill out the following to add student:</h3>
<div>
<form:form method="POST" action="/TestingProject/students/add" modelAttribute="student" class="form-horizontal">

    <div class="form-group">
    	<label class="control-label col-sm-2" for="s_id">Student ID:</label>
	    <div class="col-sm-10">
	      	<form:input type="text" id="s_id" path="s_id" />
	    </div>
  	</div>
    
    <div class="form-group">
    	<label class="control-label col-sm-2" for="f_name">First Name:</label>
	    <div class="col-sm-10">
	      	<form:input type="text" id="f_name" path="f_name" />
	    </div>
  	</div>
    
    <div class="form-group">
    	<label class="control-label col-sm-2" for="l_name">Last Name:</label>
	    <div class="col-sm-10">
	      	<form:input type="text" id="l_name" path="l_name" />
	    </div>
  	</div>
    
    <div class="form-group"> 
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">Submit</button>
	    </div>
 	</div>
</form:form>
</div>
<p class="bg-danger"><c:out value="${Error}" /></p>



<div class="list-group">
	<a class="list-group-item" href="<c:url value='/' />">Back to main page</a>
	<a class="list-group-item" href="<c:url value='/students/list' />">List all the Students</a>
</div>

</body>
</html>