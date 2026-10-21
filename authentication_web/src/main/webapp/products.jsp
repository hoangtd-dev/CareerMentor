<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
		<style>
			.root {
					width: 100%;
					height: 100vh;
					display: flex;
					justify-content: center;
					align-items: center;
			}
			table {
					font-family: arial, sans-serif;
					border-collapse: collapse;
					width: 400px;
			}

			td, th {
					border: 1px solid #dddddd;
					text-align: left;
					padding: 8px;
			}

			tr:nth-child(even) {
					background-color: #dddddd;
			}
		</style>
</head>
<body>
	<div class="root">
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<c:forEach var="product" items="${products}">
				<tr>
					<td>${product.id}</td>
					<td><c:out value="${product.name}"/></td>
					<td>${product.price}</td>
				</tr>
			</c:forEach>
			</table>
	</div>
</body>
</html>