<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>Post</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="sections/header.jsp" />
	<h3>Message sent:</h3>

	<table>
		<tr>
			<td><label for="email">E-mail:</label></td>
			<td>${postBean.email}</td>
		</tr>
		<tr>
			<td><label for="age">Age:</label></td>
			<td>${postBean.age}</td>
		</tr>
		<tr>
			<td><label for="message">Message:</label></td>
			<td>${postBean.message}</td>
		</tr>
		<tr>
			<td colspan="2"><a href="post"> Go back </a></td>
	</table>

</body>
</html>
