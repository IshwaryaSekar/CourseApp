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
	padding-right: 120px;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	background-image: url("elearning.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 1400px 800px;
	background-opacity: 0.2;
}

h3 {
	text-align: center;
}

</style>
</head>
<body>
	<div class="topright2">
		<a href="index.jsp">Sign In</a>
	</div>
	<br>
	<%-- <%
			String errorMessage = (String) request.getAttribute("ERROR_MSG");
			if (errorMessage != null) {
				out.println("Error Message:" + errorMessage);
			}
		%>
	 --%>
	<form method="post" action="RegisterServlet">
		<div class="content">

			<h1>Course Management System</h1>
			<br>
			<table>
				<tbody>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name" 
							required></td>
					</tr>
					<tr>
						<td>Phone Number</td>
						<td><input type="tel" name="phoneno"
							pattern="(0/91)?[7-9][0-9]{9}" required></td>
					</tr>
					<tr>
						<td>Date of Birth</td>
						<td><input type="date" name="dob" max="2000-01-01" required></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="email" name="email"
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password"
							pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required></td>
					</tr>
				</tbody>
			</table>
			<p>
				<button type="submit">Submit</button>
			</p>
			<br>
		</div>
	</form>
	<h3>${msg}</h3>
</body>
</html>