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
			<div class="column">
				<div class="row">
					<p>
						<input type="text" id="dni" placeholder="Dni" />
					</p>
					<p>
						<input type="text" id="name" placeholder="Name" />
					</p>
					<p>
						<input type="text" id="surname" placeholder="Surname" />
					</p>
					<p>
						<input type="text" id="email" placeholder="Email" />
					</p>
					
				</div>

				<div class="row">
					<p>
						<h4>${cycle}</h4>
					</p>
					<div>
						<c:forEach var="module" items="${modules}">
							<p><input type="checkbox" name="cycle"> ${module.name }</input></p>
							
						</c:forEach>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>