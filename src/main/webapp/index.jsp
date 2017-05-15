<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>

<h2>Student Admissions System</h2>

<h3>Please choose an option:</h3>

<div class="list-group">
	<a class="list-group-item" href="<c:url value='/students/add_page' />">Add Student</a>
	<a class="list-group-item" href="<c:url value='/students/list' />">List all the Students</a>
	<a class="list-group-item" href="<c:url value='/courses/add_page' />">Add Course</a>
	<a class="list-group-item" href="<c:url value='/courses/list' />">List all the Courses</a>
</div>

</body>
</html>