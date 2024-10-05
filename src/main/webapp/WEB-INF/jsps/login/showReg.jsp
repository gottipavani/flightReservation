<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h2>New User Registration</h2>
	<form action="saveReg" method="post">
		<table>
			<tr>
				<td>FirstName</td>
				<td><input type="text" name="firstName"></td>
			</tr>

			<tr>
				<td>lastName</td>
				<td><input type="text" name="lastName"></td>
			</tr>

			<tr>
				<td>EmailId</td>
				<td><input type="text" name="email"></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="text" name="password"></td>
			</tr>

			<tr>
				<td><input type="Submit" value="Save"></td>
			</tr>
		</table>
	</form>
	${msg}
</body>
</html>