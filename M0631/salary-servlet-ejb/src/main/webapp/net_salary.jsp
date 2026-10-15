<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Salary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="sections/header.jsp" />
	<h3>Form data entered:</h3>
	<p>
		Gross salary:
		<fmt:formatNumber value="${grossSalary}" type="currency"
			currencyCode="EUR" />
	</p>
	<p>Children: ${children}</p>
	<h3>Net salary calculation:</h3>
	<p>
		You have a tax withholding of
		<fmt:formatNumber value="${withholding}" type="percent" />
	</p>
	<p>
		Your net salary is
		<fmt:formatNumber value="${netSalary}" type="currency"
			currencyCode="EUR" />
	</p>
	<a href="gross_salary.jsp"> Go back </a>
</body>
</html>
