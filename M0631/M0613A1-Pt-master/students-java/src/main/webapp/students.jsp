<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="sections/head.jsp" />
</head>
<body>
	<div class="container my-4">
		<jsp:include page="sections/header.jsp" />
		
		<table class="table">
            
            <c:forEach var="cycle" items="${cycles}">
                <tr>
                    <td>${cycle.code}</td> 
                </tr>
            </c:forEach>
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
                    <td>${students.name}</td>
                    <td>${students.surname}</td>
                    <td>${students.email}</td>
                    
                </tr>
            </c:forEach>
		</table>
	</div>
</body>
</html>