<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home Page</title>
</head>
<body>
	<!-- we can access session attribute instead of cookies -->
	<%
		String uName = null, sessionID = null;
	if (request.getSession().getAttribute("username") == null) {
		response.sendRedirect(request.getContextPath()+"/UserLogin?action=login");
	} else {
		uName = request.getSession().getAttribute("username").toString();
		sessionID = request.getSession().getId();
	}
	%>
	
	Name :<%=uName%><br>
	Session ID :<%=sessionID%><br>
	Welcome User !!!
	<br>
	<form action="<%=request.getContextPath()%>/UserHome" method="post">
	<input type="hidden" name="action" value="destroy">
	<input type="submit" value="logout">
	</form>

</body>
</html>