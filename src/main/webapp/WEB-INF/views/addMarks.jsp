<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<%@page import="dao.CoursesDAO" %>
<%@page import="beans.Courses" %>
<%@page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Mark</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<body>
<h2>Student Admissions System</h2>
<h4> Add Mark for <c:out value="${Student.f_name}"/> <c:out value="${Student.l_name}"/></h4>

<form:form method="POST" action="/TestingProject/marks/add_mark/${marks.student_id.s_id}" modelAttribute="marks" class="form-horizontal">
	<div class="form-group">
		<div class="form-group">
	    	<label class="control-label col-sm-2" for="s_id">Student ID:</label>
		    <div class="col-sm-10">
		      	<form:input type="text" id="s_id" path="student_id.s_id" readonly="true" />
		    </div>
	  	</div>
	</div>
	<div class="form-group">
		<div class="form-group">
	    	<label class="control-label col-sm-2" for="course_id">Course ID:</label>
		    <div class="col-sm-3">
		      	<spring:bind path="course_id">
        		<form:select  class="form-control" path="course_id">
        		<c:forEach var="course" items="${ Courses }">
       			 	<form:option value="${ course.course_id }"><c:out value="${ course.course_id }" />&nbsp;<c:out value="${ course.course_name }" /></form:option>
       			 </c:forEach>
				</form:select>
				</spring:bind>
		    </div>
	  	</div>
	</div>
	<div class="form-group">
		<div class="form-group">
	    	<label class="control-label col-sm-2" for="mark">Mark:</label>
		    <div class="col-sm-10">
		      	<form:input type="text" id="mark" path="mark" />
		    </div>
	  	</div>
	</div>
 
 
    
	<div class="form-group"> 
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">Submit</button>
	    </div>
 	</div>

</form:form>






<div class="list-group">
	<a class="list-group-item" href="<c:url value='/courses/list' />" >List All Courses</a>
	<a class="list-group-item" href="<c:url value='/' />">Main Page</a>
</div>
<%-- <div>
<form action="marks"  method="post">
	<input type="hidden" name="action" value="add_mark">
	<input readonly type="text" name="s_id" value="${Student.s_id}">
	<label>Choose Course:</label>
	<select name  = "c_id">
		<c:forEach var="var" items="${Courses}">
				<option value = "${var.course_id }" }>
					<c:out value="${var.course_id}"/> &nbsp; &nbsp; &nbsp;<c:out value="${var.course_name}"/>
				</option>			
		</c:forEach>	
	</select>
	</br>
	
	<label>Mark: </label>	
	<input name="mark" type="text"/>
		
	<input class="button" type="submit" value="Submit">
</form>
</div> --%>

</body>
</html>