<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>State Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="sections/header.jsp" />
	<h3>Enter something here</h3>
	<form action="prepare_state_management" method="post">
		<label for="field">Enter something here:</label>
		<input id="field" type="text" name="field" />
		<p />
		Select state management method: <br>
		<input id="url_rewrite" type="radio" name="prepare_method"
			value="prepare_url_rewrite" checked="checked">
		<label for="url_rewrite">Url parameter</label><br>
		<input id="hidden_field" type="radio" name="prepare_method"
			value="prepare_hidden_field">
		<label for="hidden_field">Form hidden field parameter</label><br>
		<input id="cookie" type="radio" name="prepare_method"
			value="prepare_cookie">
		<label for="cookie">Cookie parameter</label><br>
		<input id="session" type="radio" name="prepare_method"
			value="prepare_session">
		<label for="session">Session parameter</label><br>
		<input type="submit">
	</form>
</body>
</html>