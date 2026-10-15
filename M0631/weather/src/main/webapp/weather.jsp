<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.xml" prefix="x"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<%@taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<%@ page import="cat.institutmarianao.weatherJSP.SSLUtils"%>
<%
SSLUtils.disableCertificateValidation();
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<jsp:useBean id="today" class="java.util.Date" scope="page" />
<fmt:formatDate var="date" value="${today}" pattern="yyyy-MM-dd" />


<c:import var="citizenWeather"
	url="https://www.aemet.es/es/api-eltiempo/prediccion/${date}/PB/8/6908" />
<x:parse var="doc" xml="${citizenWeather}" />
<div class="container">
	<body>
		<header>
			<h1>Weather</h1>
		</header>
		<h3>Forecast for Barcelona province</h3>
		<h4><fmt:formatDate value="${today}" dateStyle="full" /></h4>
		<p>
			<x:out select="$doc/root/prediccion/txt_prediccion" />
		</p>
		<table class="table table-striped">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Min.temp</th>
				<th>Max.temp</th>
			</tr>
			<x:forEach var="citizen" select="$doc/root/prediccion/ciudad">

				<tr>
					<td><x:out select="id" /></td>
					<td><x:out select="nombre" /></td>
					<td><x:out select="minima" />°</td>
					<td><x:out select="maxima" />°</td>

				</tr>

			</x:forEach>

		</table>
</div>
</body>
</html>