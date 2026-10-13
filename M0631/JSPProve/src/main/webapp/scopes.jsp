<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<html>
<head>
<title>Variable scopes examples</title>
</head>
<body>
	<header>
		<h1>Variable scopes</h1>
		<p>An app by Institut Marianao</p>
	</header>
	<c:set var="test" value="Page"
		scope="page" />
	<c:set var="test" value="Request"
		scope="request" />

	<c:set var="test" value="Session"
		scope="session" />

	<c:set var="test" value="Application"
		scope="application" />

	<table style="padding: 10px; marging: 10px;">
		<tr>
			<th>Scope</th>
			<th>Value</th>
		</tr>
		<tr>
			<td><b>Not specified:</b></td>
			<td><c:out value="${test}" /></td>
		</tr>
		<tr>
			<td><b>Page scope:</b></td>
			<td><c:out value="${pageScope.test}" /></td>
		</tr>
		<tr>
			<td><b>Request scope:</b></td>
			<td><c:out value="${requestScope.test}" /></td>
		</tr>
		<tr>
			<td><b>Session scope:</b></td>
			<td><c:out value="${sessionScope.test}" /></td>
		</tr>
		<tr>
			<td><b>Application scope:</b></td>
			<td><c:out value="${applicationScope.test}" /></td>
		</tr>
	</table>
	<p>If scope is not specified, it is searched in the following order: page, request, session, application.</p>
</body>
</html>
