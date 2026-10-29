<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="sections/head.jsp" />
</head>
<body>
	<div class="container my-4">
		<jsp:include page="sections/header.jsp" />

		<table class="table">
			<div class="container my-4">
				<c:forEach var="cycle" items="${cycles}">
					<a href="register?cycle=${cycle.code}" class="btn btn-light">New ${cycle.code} register</a>
				</c:forEach>
			</div>
		</table>
		<h2>Students</h2>
		<table class="table" border="1">
			<tr>
				<td>Dni</td>
				<td>Name</td>
				<td>Surname</td>
				<td>Email</td>
				<td>Cycle</td>
				<td>Modules</td>
				<td>Actions</td>
			</tr>
			<c:forEach var="student" items="${students}">
				<tr>
					<td>${students.dni }</td>
					<td>${students.name}</td>
					<td>${students.surname}</td>
					<td>${students.email}</td>
					<td>${students.cycle}</td>
					<td><c:forEach var="modul" items="${students.modules}">
							<td>${modul.code}- ${modul.name}</td>
						</c:forEach></td>
					<td><input type="button" value="Remove"></input></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>