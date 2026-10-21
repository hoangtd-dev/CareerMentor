<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <style>
        .root { width: 100%; height: 100vh; display: flex; justify-content: center; align-items: center; font-family: arial, sans-serif; }
        form { display: flex; flex-direction: column; gap: 12px; width: 300px; }
        .error { color: #c00; }
    </style>
</head>
<body>
    <div class="root">
        <form method="post" action="${pageContext.request.contextPath}/register">
            <h2>Register</h2>
            <c:if test="${not empty error}">
                <div class="error"><c:out value="${error}"/></div>
            </c:if>
            <input type="text" name="name" placeholder="Name" value="<c:out value='${name}'/>" required>
            <input type="email" name="email" placeholder="Email" value="<c:out value='${email}'/>" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="password" name="confirmPassword" placeholder="Confirm password" required>
            <button type="submit">Register</button>
            <a href="${pageContext.request.contextPath}/login">Back to login</a>
        </form>
    </div>
</body>
</html>
