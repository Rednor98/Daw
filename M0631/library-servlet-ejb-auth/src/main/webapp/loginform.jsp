<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
</head>
<body>
	<jsp:include page="sections/header.jsp" />
	<h3>Please, login in</h3>
 
	<form action="j_security_check" method=post>
		<p>
			<input type="text" name="j_username" size="25" placeholder="Username">
		</p>
		<p>
			<input type="password" name="j_password" size="25"
				placeholder="Password">
		</p>
		<p>
			<input type="submit" value="Submit">
			<input type="reset" value="Reset">
		</p>
	</form>
</body>
</html>