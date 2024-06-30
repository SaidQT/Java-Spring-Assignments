<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta charset="ISO-8859-1">
<title>Burger Store</title>
</head>
<body>
	<h1>Burger Tracker</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Restaurant Name</th>
				<th scope="col">Rating (out of 5)</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="burger" items="${burgers}">

				<tr>
					<td scope="row"><c:out value="${burger.name}"></c:out></td>
					<td><c:out value="${burger.restaurantName}"></c:out></td>
					<td><c:out value="${burger.rating}"></c:out></td>
					<td><a href="/edit/${burger.id}">Edit</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Add a Burger</h2>


	<form:form action="/burgers" method="post" modelAttribute="burger">
		<p>
			<form:label path="name">Name</form:label>

			<form:input path="name" />
			<form:errors path="name" class="errors" />
		</p>
		<p>
			<form:label path="restaurantName">Restaurant Name</form:label>

			<form:input path="restaurantName" />
			<form:errors path="restaurantName" class="errors" />
		</p>
		<p>
			<form:label path="rating">Rating</form:label>
			<form:input type="number" path="rating" />
			<form:errors path="rating" class="errors" />

		</p>
		<p>
			<form:label path="notes">Notes</form:label>

			<form:textarea path="notes" />
			<form:errors path="notes" class="errors" />

		</p>
		<input type="submit" value="Submit" />
	</form:form>


</body>
</html>