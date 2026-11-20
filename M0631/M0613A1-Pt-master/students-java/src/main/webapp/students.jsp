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
					<a href="register?cycle=${cycle.code}" class="btn btn-light">New
						${cycle.code} register</a>
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
					<td>${student.dni }</td>
					<td>${student.name}</td>
					<td>${student.surname}</td>
					<td>${student.email}</td>
					<td>${student.cycle.code}</td>
					<td><c:forEach var="modul" items="${student.modules}">
							<div class="form-check">
								<p>${modul.code}-${modul.name}</p>
							</div>
						</c:forEach></td>
					<td>
						<button type="button" class="btn btn-danger"
							data-bs-toggle="modal"
							data-bs-target="#removeModal${student.dni}">Remove</button>

						<div class="modal fade" id="removeModal${student.dni}"
							tabindex="-1" aria-labelledby="removeModalLabel${student.dni}"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<form action="remove" method="post">
										<input type="hidden" name="dni" value="${student.dni}">

										<div class="modal-header">
											<h1 class="modal-title fs-5"
												id="removeModalLabel${student.dni}">Confirm remove</h1>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">
											Are you sure you wish to delete student with dni = <strong>${student.dni}</strong>
										</div>
										<div class="modal-footer">
											<button type="submit" class="btn btn-danger">Remove</button>
											<button type="button" class="btn btn-secondary"
												data-bs-dismiss="modal">Cancel</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>