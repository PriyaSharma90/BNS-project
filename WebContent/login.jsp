<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Login From Here</h1>

	<form action="LoginServlet" method="post">
		<tr>
			<td>User Name :</td>
			<td><input type="text" name="uname"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="upassword" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Login" /></td>
		</tr>
	</form>
</body>
</html>