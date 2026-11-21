<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<header class="mb-4 p-5 bg-secondary-subtle bg-gradient rounded">
	<p class="display-1">
		<strong>Students</strong>
	</p>
	<h3>By Institut Marianao</h3>
</header>
<nav
	class="navbar navbar-expand-lg sticky-top mb-4 bg-secondary-subtle bg-gradient rounded">
	<div class="container-fluid">
		<c:choose>
			<c:when test="${not empty pageContext.request.userPrincipal}">
				<span class="navbar-text text-dark">
					<i class="bi bi-person-fill"></i>
					<small><c:out value="${pageContext.request.userPrincipal.name}"/></small>
				</span>
				<button type="button" class="btn btn-link btn-sm text-decoration-none ms-auto"
					data-bs-toggle="modal" data-bs-target="#confirmLogout">
					<i class="bi bi-box-arrow-right"></i> Logout
				</button>
			</c:when>
			<c:otherwise>
				<span class="navbar-brand">&nbsp;</span>
			</c:otherwise>
		</c:choose>
	</div>
</nav>

<c:if test="${not empty pageContext.request.userPrincipal}">
	<div class="modal fade" id="confirmLogout" tabindex="-1"
		aria-labelledby="confirmLogoutLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="confirmLogoutLabel">Confirm logout</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p>Are you sure you wish to logout?</p>
				</div>
				<div class="modal-footer">
					<a class="btn btn-danger"
						href="${pageContext.request.contextPath}/logout">Logout</a>
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</c:if>
