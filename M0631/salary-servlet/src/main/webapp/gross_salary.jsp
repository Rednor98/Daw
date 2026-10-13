<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Salary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="sections/header.jsp" />
	<h3>Salary calculation:</h3>
	<form action="salary" method="post">
		<label for="salary">Gross salary:</label>
		<input id="salary" type="number" name="grossSalary" min="0" />
		<p/>
		<label for="children">Children:</label>
		<input id="children" type="number" name="children" min="0">
		<p/>
		<input type="submit">
	</form>
</body>
</html>