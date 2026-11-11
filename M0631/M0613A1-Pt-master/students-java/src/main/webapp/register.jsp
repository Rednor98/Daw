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

		<div class="modal fade" id="confirmLogout" tabindex="-1"
			aria-labelledby="confirmLogoutLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="confirmLogoutLabel">Confirm
							logout</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<p>Are you sure you wish to logout?</p>
					</div>
					<div class="modal-footer">

						<a class="btn btn-danger" href="/students-java/logout">Logout</a>
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>


		<c:if test="${not empty errors}">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
				<c:forEach items="${errors}" var="error">
					<p class="mb-1">
						<strong>${error.propertyPath}:</strong> ${error.message}
					</p>
				</c:forEach>
			</div>
		</c:if>

		<h1>New ${cycle} register</h1>
		<div class="container my-4">
			<form action="register" method="POST">
				<div class="row g-3">
					<div class="col-md-6 col-lg-5">
						<div class="input-group mb-3">
							<div class="input-group mb-3">
								<span class="input-group-text"><i
									class="bi bi-card-heading"></i></span> <input type="text" id="dni"
									name="dni" placeholder="Dni" value="${student.dni }" />
							</div>
						</div>
						<div class="input-group mb-3">
							<div class="input-group mb-3">
								<span class="input-group-text"><i class="bi bi-person"></i></span>
								<input type="text" name="name" id="name" placeholder="Name"
									value="${student.name }" />
							</div>
						</div>
						<div class="input-group mb-3">
							<div class="input-group mb-3">
								<span class="input-group-text"><i
									class="bi bi-person-fill"></i></span> <input type="text" id="surname"
									name="surname" placeholder="Surname"
									value="${student.surname }" />
							</div>
						</div>
						<div class="input-group mb-3">
							<div class="input-group mb-3">
								<span class="input-group-text"><i class="bi bi-envelope"></i></span>
								<input type="text" name="email" id="email" placeholder="Email"
									value="${student.email }" />
							</div>
						</div>

						<a href="students" class="btn btn-secondary">Cancel</a>
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>

					<div class="col-md-6 col-lg-7">
						<div class="input-group mb-3">
							<span class="input-group-text"><i
								class="bi bi-mortarboard"></i></span> <input id="cycle" type="text"
								class="form-control" name="cycle" value="${cycle }" readonly>
						</div>

						<div class="input-group mb-3">
							<span class="input-group-text"><i class="bi bi-list-task"></i></span>
							<div class="scroll form-control">
								<c:forEach var="module" items="${modules}">
									<c:set var="checked" value="" />
									<c:forEach var="selected" items="${student.modules}">
										<c:if test="${selected.code == module.code}">
											<c:set var="checked" value="checked" />
										</c:if>
									</c:forEach>

									<div class="form-check">
										<input type="checkbox" name="moduleCode"
											value="${module.code}" ${checked}>
										${module.code}-${module.name}
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>