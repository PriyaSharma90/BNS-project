<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Employee Management</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>
</head>
<body>
	<h1>Add Employee</h1>
	<form action="AddServlet" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="epassword" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><select name="country" style="width: 150px">
						<option>India</option>
						<option>USA</option>
						<option>UK</option>
						<option>Other</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Employee" /></td>
			</tr>
		</table>
	</form>

	<br />
	<a href="ViewEmpServlet?page=1">view employees</a>
		
	

</body>
</html>