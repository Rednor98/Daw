<%-- JSP using JSTL Core Tags and Expression Language (EL) --%>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
 
<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard - JSTL & EL</title>
</head>
<body>
 
    <%-- Defining variables in page scope with c:set --%>
    <c:set var="userRole" value="ADMIN" scope="page" />
    <c:set var="isLoggedIn" value="true" scope="page" />
 
    <h1>User Dashboard</h1>
 
    <%-- 1. Safe output using c:out (XSS protection) --%>
    <p>Current User: <c:out value="${param.username}" default="Anonymous Guest" /></p>
 
    <%-- 2. Simple conditional evaluation with c:if --%>
    <c:if test="${isLoggedIn}">
        <p>Status: <strong>Session Active</strong></p>
    </c:if>
 
    <%-- 3. Multi-condition logic with c:choose, c:when, c:otherwise --%>
    <h3>Access Level</h3>
    <c:choose>
        <c:when test="${userRole == 'ADMIN'}">
            <p>Role: System Administrator (Full privileges)</p>
        </c:when>
        <c:when test="${userRole == 'EDITOR'}">
            <p>Role: Content Editor (Restricted privileges)</p>
        </c:when>
        <c:otherwise>
            <p>Role: Regular User (Read-only)</p>
        </c:otherwise>
    </c:choose>
 
    <%-- 4. Iteration using c:forEach over a numeric range --%>
    <h3>Available Modules</h3>
    <ul>
        <c:forEach var="step" begin="1" end="3" varStatus="status">
            <li>Module #<c:out value="${step}" /> (Iteration: ${status.count})</li>
        </c:forEach>
    </ul>
 
</body>
</html>