<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/catalog.css" />
<title>Department List</title>
</head>
<body>
	<div id="header"><h3>Department List</h3></div>
	<div id="classes">
		<div class="upper" >
			<h4>Menu</h4>
			<nav> 
				<a href="http://localhost:8080/StudentDBSystem/Success.jsp">Student Information</a><br>
				<a href="http://localhost:8080/StudentDBSystem/courseCatalog.jsp">Browse Classes</a><br>
				<a href="http://localhost:8080/StudentDBSystem/registration.jsp?">Registration</a><br>
				<a href="http://localhost:8080/StudentDBSystem/courseCatalog.jsp">Update Student Information</a><br>
				<a href="http://localhost:8080/StudentDBSystem/">Logout</a>
			</nav>
		</div>
		<div class="department">
			<div class="departments"><h4>School of Engineering</h4></div>	
			<ul>
				<li> <a href="http://localhost:8080/StudentDBSystem/BrowseCourseController?department=Industrial+Engineering"> Industrial Engineering (IND E)</a></li>
				<li> <a href="http://localhost:8080/StudentDBSystem/BrowseCourseController?department=Mechanical+Engineering"> Mechanical Engineering (ME)</a></li>
				<li> <a href="http://localhost:8080/StudentDBSystem/BrowseCourseController?department=Chemical+Engineering"> Chemical Engineering (CHEM E)</a></li>
				<li> <a href="http://localhost:8080/StudentDBSystem/BrowseCourseController?department=Computer+Science+Engineering"> Computer Science Engineering (CSE)</a></li>
			</ul>
			<div class="departments"><h4>School of Arts and Sciences</h4></div>
			<ul>
				<li> <a href="http://localhost:8080/StudentDBSystem/BrowseCourseController?department=Mathematics"> Mathematics (MATH)</a></li>
				<li> <a href="http://localhost:8080/StudentDBSystem/BrowseCourseController?department=Economics"> Economics (ECON)</a></li>
				<li> <a href="http://localhost:8080/StudentDBSystem/BrowseCourseController?department=Physics"> Physics (PHYS)</a></li>
				<li> <a href="http://localhost:8080/StudentDBSystem/BrowseCourseController?department=Chemistry"> Chemistry (CHEM)</a></li>
			</ul>
			<div class="departments"><h4>School of Business</h4></div>
			<ul>
				<li> <a href="http://localhost:8080/StudentDBSystem/BrowseCourseController?department=Finance">Finance (FIN)</a></li>
				<li> <a href="http://localhost:8080/StudentDBSystem/BrowseCourseController?department=Management">Management (MGMT)</a></li>
			</ul>
		</div>
	</div>
</body>
</html>