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
		<h1>New ${cycle} register</h1>
		<div class="container my-4">
			<form action="register" method="post">
				<c:if test="${not empty errors}">
					<c:forEach items="${errors}" var="error">
						<p style="color: red">
							<c:out value="${error.message}" escapeXml="false" />
						</p>
					</c:forEach>
				</c:if>
				<div class="row">
					<div class="col-sm">
						<p>
						<label for="dni">DNI:</label> <input type="text" id="dni"
							placeholder="Dni" value="${sessionScope.student.dni }" />
						</p>
						<p>
						<label for="name">Name:</label> <input type="text" id="name"
							placeholder="Name" value="${sessionScope.student.name }" />
						</p>
						<p>
						<label for="surname">Surname:</label> <input type="text"
							id="surname" placeholder="Surname" value="${sessionScope.student.surname }" />
						</p>
						<p>
						<label for="email">Email:</label> 
						<input type="text" id="email" placeholder="Email" value="${sessionScope.student.email }" />
						</p>

						<a href="students" class="btn btn-secondary">Cancel</a> <a
							href="students" class="btn btn-primary">Submit</a>
					</div>

					<div class="col-sm">
						<h4>${cycle}</h4>
						<div>
							<c:forEach var="module" items="${modules}">
								<p>
									<input type="checkbox" name="modules"> ${module.name }
								</p>
							</c:forEach>
						</div>

					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>