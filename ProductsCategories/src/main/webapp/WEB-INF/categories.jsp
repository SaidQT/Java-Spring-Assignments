<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categories</title>
<link rel="stylesheet" href="/css/main.css">

</head>
<body>
	<h2>
		<c:out value="${category.name}"></c:out>
	</h2>
	<div>
		<a href="/">Home</a>
	</div>
	<br>
	<hr>
	<br>
	<h3>Products</h3>
	<c:forEach var="product" items="${products}">
		<li><c:out value="${product.name} "></c:out></li>
	</c:forEach>
	<br>
	<hr>
	<br>
	<form action="/create/category/${category.id}" method="post">
		<h4>Add Product:</h4>
		<select name="productId" id="productId" class="input">
			<c:forEach var="product" items="${remaining}">
				<option value="${product.id}">${product.name}</option>
			</c:forEach>
		</select> <input class="input" class="button" type="submit" value="Add" />
	</form>
</body>
</html>