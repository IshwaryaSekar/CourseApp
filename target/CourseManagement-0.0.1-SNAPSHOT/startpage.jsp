<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Management System</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-image: url("elearning.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 1400px 800px;
	background-opacity: 0.2;
}

h1 {
	text-align: center;
	background-color: white;
}

.navbar {
	overflow: hidden;
	background-color: #333;
}

.navbar a {
	float: left;
	font-size: 16px;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: red;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.topright {
	position: absolute;
	top: 8px;
	right: 16px;
	font-size: 18px;
}

.topright1 {
	position: absolute;
	top: 8px;
	right: 16px;
	font-size: 18px;
	padding-right: 70px;
}

div.c {
	position: absolute;
	left: 150px;
	width: 200px;
	height: 120px;
	border: 3px solid green;
}

img {
	float: right;
}

p {
	color: black;
}
</style>
</head>
<body>
	<h1>Course Management System</h1>
	<div class="topright">
		<a href="index.jsp">LogOut</a>
	</div>
	<div class="navbar">
		<a href="#">About Us</a> <a href="UserDepartmentServlet">Department</a>
	</div>

	<p>A course management system (CMS) is a collection of software
		tools providing an online environment for course interactions. A CMS
		typically includes a variety of online tools and environments.An area
		for instructor to upload courses with course name and also the status
		about the course.An area for instructor to upload videos with course
		name.An area for instructor can see the feedback given by the user. An
		area for trainee/employee can register the courses.An area for
		trainee/employee can see the videos. An area for trainee/employee can
		give the feedback to the instructor.</p>
	<p>
		<img src="learning.jpg" alt="not found" align="right" width="650"
			height="400">
	</p>
	<div class="b">
		<p>Uses:</p>
		<p>Store All Your Course Information In One Place</p>
		<p>Integrate With Your Website</p>
		<p>Schedule Resources And Instructors</p>
	</div>
	
</body>
</html>