<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        .root { width: 100%; height: 100vh; display: flex; justify-content: center; align-items: center; font-family: arial, sans-serif; }
        form { display: flex; flex-direction: column; gap: 12px; width: 300px; }
        .error { color: #c00; }
        .success { color: #080; }
    </style>
</head>
<body>
    <div class="root">
        <form method="post" action="${pageContext.request.contextPath}/login">
            <h2>Login</h2>
            <c:if test="${not empty error}">
                <div class="error"><c:out value="${error}"/></div>
            </c:if>
            <c:if test="${param.registered == '1'}">
                <div class="success">Registered successfully. Please log in.</div>
            </c:if>
            <input type="email" name="email" placeholder="Email" value="<c:out value='${email}'/>" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
            <a href="${pageContext.request.contextPath}/register">Create an account</a>
        </form>
    </div>
</body>
</html>
