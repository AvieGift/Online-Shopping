<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/signup">
		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="First Name" value="${firstName}" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="Last Name" value="${lastName}" /></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="text" name="Email Address" value="${Email}" /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="text" name="Password" value="${Password}" /></td>
			</tr>

			<tr>
				<td>Confirm Password</td>
				<td><input type="text" name="Confirm Password" value="${confirmPassword}" /></td>
			</tr>

		</table>
	</form>
</body>
</html>