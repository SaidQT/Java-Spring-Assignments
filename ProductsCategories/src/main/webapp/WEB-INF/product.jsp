
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
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
<title>New Product</title>
<link rel="stylesheet" href="/css/product.css">

</head>
<body>
	<h2>New Product</h2>
	<div>
		<a href="/">Home</a>
	</div>
	<hr>
	<form:form action="/createproduct" method="post" modelAttribute="product">
		<p>
			<form:label path="name">Name</form:label>

			<form:input path="name" />
			<form:errors path="name" class="errors" />
		</p>
		<p>
			<form:label path="description">Description</form:label>

			<form:textarea path="description" />
			<form:errors path="description" class="errors" />
		</p>
		<p>
			<form:label path="price">Price</form:label>
			<form:input type="number" path="price" />
			<form:errors path="price" />

		</p>
		<br>
		<hr>
		
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>