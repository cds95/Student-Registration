<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="StudentFiles.Student"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="css/registration.css" />
</head>
<body>
	<h3>Registration</h3>	
	<h4>Registered Classes</h4> 
	<div class="upper">	
		<h4>Menu</h4>
		<nav> 
			<a href="http://localhost:8080/StudentDBSystem/Success.jsp">Student Information</a> <br>
			<a href="http://localhost:8080/StudentDBSystem/courseCatalog.jsp">Browse Classes</a> <br>
			<a href="http://localhost:8080/StudentDBSystem/registration.jsp?">Registration</a> <br>
			<a href="" >Update Student Information</a><br>
			<a href="http://localhost:8080/StudentDBSystem/">Logout</a>
		</nav>
	</div>
	<div id="courses">
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
	</div>
	
	<span id="credits" > Registered Credits: ${student.registeredCredits()} </span>
	
	<div class="edits" >
		<h4>Register Below</h4>
		<form action="RegistrationController">
			Course ID <input type="text" name="cid" /> 
			<input type="submit" value="Register" name="choice" />
		</form>

		<h4>Remove Class</h4>
		<form action="RegistrationController">
			Course ID <input type="text" name="cid" /> 
			<input type="submit" value="Remove" name="choice" />
			<input type="hidden" name="remove" />
		</form>
	</div>
	
	<div id="search">
		<form class="search" method="get" action="BrowseCourseController" >
			Browse Class By Department <input type="text" name="department" placeholder="Search..." />
		</form>
	</div>
	

</body>
</html>