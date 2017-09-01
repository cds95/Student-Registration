<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="StudentFiles.Student"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/welcome.css" />
<title>Welcome</title>
</head>
<body>
	<h3>${student.fname} ${student.lname}</h3>
	<div class="upper">	
		<h4>Menu</h4>
		<nav> 
			<a href="http://localhost:8080/StudentDBSystem/Success.jsp">Student Information</a><br>
			<a href="http://localhost:8080/StudentDBSystem/courseCatalog.jsp">Browse Classes</a><br>
			<a href="http://localhost:8080/StudentDBSystem/registration.jsp?">Registration</a><br>
			<a href="http://localhost:8080/StudentDBSystem/courseCatalog.jsp">Update Student Information</a><br>
			<a href="http://localhost:8080/StudentDBSystem/">Logout</a>
		</nav>
	</div>
	<div class="info">
		<table>
			<tr>
				<th>Student Number</th>
				<td>${student.sid}</td>
			</tr>
			<tr>
				<th>Year</th>
				<td>${student.year}</td>
			</tr>
			<tr>
				<th>Major</th>
				<td>${student.major}</td>
			<tr>
			<tr>
				<th>Cumulative GPA</th>
				<td>${student.gpa}</td>
			</tr>
	</table>
	</div>

	<h4>Current Classes</h4>
	<table>
		<tr>
			<th>Course ID</th>
			<th>Department</th>
			<th>Course Number</th>
			<th>Course Name</th>
			<th>Instructor</th>
			<th>Credits</th>
		</tr>

		<c:forEach items="${student.course}" var="course">
			<tr>
				<td>${course.cid}</td>
				<td>${course.department.handle}</td>
				<td>${course.number}</td>
				<td>${course.name}</td>
				<td>${course.instructor}</td>
				<td>${course.credit}</td>
			</tr>
		</c:forEach>
	</table>
	Registered Credits: ${student.registeredCredits()}

</body>
</html>