<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>State Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="sections/header.jsp" />
	<h3>We have "${cookie.field.value}" in a cookie</h3>
	<form action="retrieve_cookie" method="post">
		<input type="submit" value="Continue">
	</form>
</body>
</html>