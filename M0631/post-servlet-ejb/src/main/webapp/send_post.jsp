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
	<h3>Write a message:</h3>
	<form action="post" method="post">
		<c:if test="${not empty errors}">
			<c:forEach items="${errors}" var="error">
				<p style="color: red">
					<c:out value="${error.message}" escapeXml="false" />
				</p>
			</c:forEach>
		</c:if>
		<table>
			<tr>
				<td><label for="email">E-mail:</label></td>
				<td><input id="email" type="text" name="email" value="${postBean.email}"
						style="width: stretch" /></td>
			</tr>
			<tr>
				<td><label for="age">Age:</label></td>
				<td><input id="age" type="number" name="age" min="0" max="120" value="${postBean.age}"
						style="width: stretch"></td>
			</tr>
			<tr>
				<td><label for="message">Message:</label></td>
				<td><textarea id="message" name="message" cols="40" rows="15">${postBean.message}</textarea></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right"><input type="submit"
						value="Send" /></td>
		</table>

	</form>
</body>
</html>
