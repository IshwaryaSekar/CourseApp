<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

h1 {
	text-align: center;
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

.content {
	max-width: 500px;
	max-length: 300px;
	margin: auto;
	background: white;
	padding-top: 100px;
	padding-right: 30px;
	padding-bottom: 50px;
	padding-left: 80px;
	text-align: center;
}

table, th, td {
	border: 1px solid black;
	text-align: center;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	background-image: url("elearning.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 1400px 800px;
	background-opacity: 0.2;
}
}
</style>
</head>
<body>
	<h1>Course Management System</h1>
	<div class="navbar">
		<div class="topright">
			<a href="authorlogin.jsp">LogOut</a>
		</div>

	</div>
	<div class="navbar">
		<a href="startpage.jsp">About Us</a> <a href="#">Department</a>
	</div>
	<div class="content">
		<form action="EnrollServlet" method="post">
			<table>

				<thead>
					<tr>
						<th>Course Name</th>
						<th>Where U Will Learn</th>
						<th>Requirements</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="description" items="${DESCRIPTION}">
						<tr>
							<td>${description.name}</td>
							<td>${description.where_you_will_learn}</td>
							<td>${description.requirements}</td>
						</tr>
						<button type="submit" name="coursename"
								value="${description.name}">Enroll</button>


					</c:forEach>
				</tbody>
				<tr>
			</table>

		</form>
	</div>
</body>
</html>