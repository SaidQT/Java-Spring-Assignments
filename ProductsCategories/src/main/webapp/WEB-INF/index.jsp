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
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<h2>Home Page</h2>
	<br>
	<br>
	<a href="/products/new">New Product</a>
	<a href="/category/add">New Category</a>
	<br>
	<hr>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Products</th>
				<th scope="col">Categories</th>
			</tr>
		</thead>
		<tbody>


			<tr>
				<td>
					<ul>
						<c:forEach var="product" items="${products}">
							<li><a href="/products/${product.id}"><c:out value="${product.name}" /></a></li>
						</c:forEach>
					</ul>
				</td>
			
				<td>
					<ul>
						<c:forEach var="category" items="${categories}">
							<li><a href="/category/${category.id }"><c:out value="${category.name}" /></a></li>
						</c:forEach>
					</ul>
				</td>
			</tr>


		</tbody>
	</table>
</body>
</html>