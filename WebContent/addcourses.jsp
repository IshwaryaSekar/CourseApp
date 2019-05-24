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
	background: none;
	padding-top: 100px;
	padding-right: 30px;
	padding-bottom: 50px;
	padding-left: 80px;
	text-align: center;
	table-align: center;
}

body {
	background-color: rgba(201, 76, 76, 0.3);
}

h3 {
	text-align: center;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script>
	$(document).ready(
			function() {

				$.ajax({
					url : 'CoursesServlet',
					type : 'post',
					data : {
						departmentAction : "bindDepartment"
					},
					success : function(data) {
						var deptList = JSON.parse(data);
						for (var i = 0; i < deptList.length; i++) {
							$('#departmentList').append(
									"<option value="+deptList[i]+">"
											+ deptList[i] + "</option>")
						}
					}

				})
			});
</script>
</head>
<body>
	<h1>Course Management System</h1>
	<form action="AddCoursesServlet" method="post">
		
		<div class="topright">
			<a href="authorlogin.jsp">LogOut</a>
		</div>
		<div class="navbar">
			<div class="dropdown">
				<button class="dropbtn">
					Department <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="addDepartment.jsp">Add Department</a> <a
						href="ViewDepartmentsServlet">View Department</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">
					Courses <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="#">Add Courses</a> <a href="ViewCoursesServlet">View
						Courses </a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">
					Materials <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="addmaterials.jsp">Add Videos</a> <a
						href="ViewVideosServlet">View Videos</a>

				</div>
			</div>
		</div>

		<div class="content">
			<table>
				<tbody>
					<tr>
						<td>Course Name</td>
						<td><input type="text" name="name" pattern="[A-Za-z]{4,20}"
							required></td>
					</tr>
					<tr>
						<td>Start Date:</td>
						<td><input type="date" name="start_date" min="2019-05-04"  max="2019-05-23"
							required></td>
					</tr>
					<tr>
						<td>End Date:</td>
						<td><input type="date" name="end_date"  min="2019-07-02" max="2019-11-20"
							required></td>
					</tr>

					<tr>
						<td>Department Name</td>
						<td><select name="departmentName" id="departmentList"
							required>
						</select></td>
					</tr>
					<tr>
						<td>Author Name</td>
						<td><select name="authorName" required>
								<option value="amritha">Amritha</option>
								<option value="anu">Anu</option>
						</select></td>
					</tr>
					<tr>
						<p><td>What you will learn</td>
						<td><textarea rows="6" cols="20" name="learn" pattern="[A-Za-z- ]{4,200}" required></textarea></td></p>
					</tr>
					<tr>
						<td>Requirements</td>
					<td><textarea rows="6" cols="20" name="requirements" pattern="[A-Za-z- ]{4,200}" required></textarea></td></p>
						
					</tr>
				</tbody>
			</table>
			<p>
				<button type="submit" value="addCourses">Add</button>
			</p>
		</div>
		<h3>${msg}</h3>


	</form>
</body>
</html>