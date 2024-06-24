<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruit Store</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
	<h1>Fruit Store</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="fruit" items="${fruitsFromMyController}">
				<tr>
					<c:choose>
						<c:when test="${fruit.name.startsWith('G')}">
							<td style="color: orange"><c:out value="${fruit.name}"></c:out></td>
							<td style="color: orange"><c:out value="${fruit.price}"></c:out></td>
						</c:when>
						<c:otherwise>
							<td><c:out value="${fruit.name}"></c:out></td>
							<td><c:out value="${fruit.price}"></c:out></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>