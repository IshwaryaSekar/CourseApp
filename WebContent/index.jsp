<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Management System</title>
<style>
.content {
	max-width: 500px;
	max-length: 300px;
	margin: auto;
	padding-top: 100px;
	padding-right: 30px;
	padding-bottom: 50px;
	padding-left: 80px;
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

.topright {
	top: 8px;
	font-size: 18px;
	font-color: white;
	padding-left: 650px;
	font-color: white;
	top: 8px;
	right: 16px;
}

.topright2 {
	position: absolute;
	top: 8px;
	right: 16px;
	font-size: 18px;
	padding-left: 150px;
	font-color: white;
	top: 8px;
	right: 16px;
}
</style>
</head>
<body>
	 <div class="topright2">
		<a href="register.jsp" style="position: relative;z-index: 10000;" >Sign Up</a>
	</div>
	 <div class="topright2">
		<a href="authorlogin.jsp" style="margin-right: 80px;" >Author</a>
	</div>
	 <form action="LoginServlet" method="post">
		<div class="content">
			<h1>Course Management System</h1>
			<table cellspacing="20">
				<tbody>
					<tr>
						<td>UserName</td>
						<td><input type="text" name="name" required> </t>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" required></td>
					</tr>
				</tbody>
			</table>
			<p>
				<button type="submit">Sign in</button>
			</p>
			<br>
		</div>
	</form>
	<h3>${msg}</h3>
</body>
</html>
