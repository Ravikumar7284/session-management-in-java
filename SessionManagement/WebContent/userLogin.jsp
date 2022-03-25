<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Page</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/UserLogin" method="post">
		userName : <input type="text" name="username"> <br> <br>
		passWord : <input type="password" name="password"> <br> <br>
		<input type="hidden" name="action" value="loginsubmit">
		<input type="submit" value="submit">
	</form>
</body>
</html>