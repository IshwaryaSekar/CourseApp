<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

.topright2 {
	position: absolute;
	top: 8px;
	right: 16px;
	font-size: 18px;
	padding-right: 150px;
}

h3 {
	text-align: center;
}

body {
	background-color: rgba(201, 76, 76, 0.3);
}
</style>
</head>
<body>
	<div class="topright">
		<a href="index.jsp">LogOut</a>
	</div>
	<form method="post" action="AuthorLoginServlet">
		<div class="content">

			<h1>Course Management System</h1>
			<br>
			<table cellspacing="30">
				<tbody>
					<tr>
						<td>UserName</td>
						<td><input type="email" id="username" name="username"
							required></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" id="password" name="password"
							required></td>
					</tr>
				</tbody>
			</table>
			<p>
				<button type="submit">Sign in</button>
			</p>
			<br>
			<h3>${ERROR}</h3>
		</div>
	</form>

</body>
</html>