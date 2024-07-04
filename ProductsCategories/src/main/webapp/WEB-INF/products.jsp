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
<title>Insert title here</title>
<link rel="stylesheet" href="/css/main.css">

</head>
<body>
	<h2>
		<c:out value="${product.name}"></c:out>
	</h2>
	<div>
		<a href="/">Home</a>
	</div>
	<br>
	<hr>
	<br>
	<h3>Categories</h3>
	<c:forEach var="category" items="${categories}">
		<li><c:out value="${category.name} "></c:out></li>
	</c:forEach>
	<br>
	<hr>
	<br>
	<form action="/create/${product.id}" method="post">
		<h4>Add Category:</h4>
		<select name="categoryId" id="categoryId" class="input">
			<c:forEach var="category" items="${remaining}">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select> <input class="input" class="button" type="submit" value="Add" />
	</form>
</body>
</html>