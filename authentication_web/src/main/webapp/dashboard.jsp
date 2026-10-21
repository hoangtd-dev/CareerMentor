<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body style="font-family: arial, sans-serif;">
    <h1>Dashboard</h1>
    <c:choose>
        <c:when test="${not empty sessionScope.user}">
            <p>Welcome, <c:out value="${sessionScope.user.name}"/>!</p>
            <form method="post" action="${pageContext.request.contextPath}/logout">
                <button type="submit">Logout</button>
            </form>
        </c:when>
        <c:otherwise>
            <p>You are not logged in.</p>
            <a href="${pageContext.request.contextPath}/login"><button type="button">Login</button></a>
        </c:otherwise>
    </c:choose>
</body>
</html>
