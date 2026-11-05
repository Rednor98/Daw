<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="sections/head.jsp" />
</head>
<body class="m-4">
	<div class="container">
		<jsp:include page="sections/header.jsp" />
	</div>
	<form action="j_security_check" method="post">
		<div class="container g-2 mb-4">
			<div class="row justify-content-center overflow-hidden">
				<div class="col-sm-9 col-md-7 col-lg-5 col-xl-4">

					<div class="card">
						<div class="card-header bg-secondary-subtle">
							<h5 class="card-title mb-0">Please, enter your credentials</h5>
						</div>

						<div class="card-body">

							<div class="input-group py-1">
								<span class="input-group-text"> <i
									class="bi bi-person-fill"></i>
								</span> <input class="form-control" placeholder="Username"
									name="j_username" type="text">
							</div>

							<div class="input-group py-1">
								<span class="input-group-text"> <i class="bi bi-key-fill"></i>
								</span> <input class="form-control" placeholder="Password"
									name="j_password" type="password">
							</div>
						</div>
						<div class="card-footer bg-secondary-subtle">
							<input class="btn btn-light btn-outline-secondary col-12"
								type="submit" value="Login">
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>