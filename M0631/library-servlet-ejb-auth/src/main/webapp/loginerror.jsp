<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Error</title>
</head>
<body>
	<jsp:include page="sections/header.jsp" />
	<h3>Invalid user name or password.</h3>
	<c:url var="url" value="/loginform.jsp" />
	<p>
		Please enter a user name or password that is authorized to access this
		application. For this application, this means a user that has been
		created in the
		<code>file</code>
		realm and has been assigned to the <em>group</em> of
		<code>TutorialUser</code>
		. Click here to <a href="${url}">Try Again</a>
	</p>
</body>
</html>