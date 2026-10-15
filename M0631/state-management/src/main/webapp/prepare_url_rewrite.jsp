<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>State Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="sections/header.jsp" />
	<h3>Click continue to send "${field}" as parameter in the url</h3>
	<a href="retrieve_url_rewrite?field=${field}">Continue</a>
</body>
</html>