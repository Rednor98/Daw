<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>State Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="sections/header.jsp" />
	<h3>Click continue to send "${field}" as hidden parameter in form</h3>
	<form action="retrieve_hidden_field" method="post">
		<input type="hidden" name="field" value="${field}">
		<input type="submit" value="Continue">
	</form>
</body>
</html>