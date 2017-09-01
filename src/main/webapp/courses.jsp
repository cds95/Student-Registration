<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="StudentFiles.Department"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${department.departmentName}</title>
<link rel="stylesheet" type="text/css" href="css/course.css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<h3>
		<c:out value="${department.departmentName}" />
	</h3>
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
	<div class="information">
		<div class="courseHeading"><h4>Department Information</h4></div>
		<p>
			Department Number: ${department.did} <br> School:
			${department.school} <br>
		<p>
		<div class="courseHeading" ><h5>Courses Offered</h5></div>
		<table>
			<tr>
				<th>Course ID</th>
				<th>Department</th>
				<th>Course Number</th>
				<th>Course Name</th>
				<th>Instructor</th>
				<th>Credits</th>
				<th>Availability</th>
			</tr>
	
			<c:forEach items="${department.courses}" var="course">
				<tr>
					<td>${course.cid}</td>
					<td>${course.department.handle}</td>
					<td>${course.number}</td>
					<td>${course.name}</td>
					<td>${course.instructor}</td>
					<td>${course.credit}</td>
					<td>${course.size()}/ ${course.capacity}</td>
					<td><form action="RegistrationController">
							<input type="submit" value="Register" name="choice" />
							<input type="hidden" name="cid" value="${course.cid}" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>