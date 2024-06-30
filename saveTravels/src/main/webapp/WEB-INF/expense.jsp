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
<title>Expense Tracking</title>
</head>
<body>
	<h1>Expense Tracker</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Expense Name</th>
				<th scope="col">Vendor</th>
				<th scope="col">Amount</th>
				<th scope="col">Actions
				<th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${expenses}">

				<tr>
					<td scope="row"><c:out value="${expense.name}"></c:out></td>
					<td><c:out value="${expense.vendor}"></c:out></td>
					<td><c:out value="${expense.amount}"></c:out></td>
					<td><a href=/expenses/edit/${expense.id}>Edit</a></td>
					<td><form action="/expenses/delete/${expense.id}" method="post">
							<input type="hidden" name="_method" value="delete"> <input
								type="submit" value="Delete">
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Add a Expense</h2>


	<form:form action="/expenses/new" method="post"
		modelAttribute="expense">
		<p>
			<form:label path="name">Name</form:label>

			<form:input path="name" />
			<form:errors path="name" class="errors" />
		</p>
		<p>
			<form:label path="vendor">Vendor</form:label>

			<form:input path="vendor" />
			<form:errors path="vendor" class="errors" />
		</p>
		<p>
			<form:label path="amount">Amount</form:label>
			<form:input type="number" step="any" path="amount" />
			<form:errors path="amount" class="errors" />

		</p>
		<p>
			<form:label path="description">Description</form:label>

			<form:textarea path="description" />
			<form:errors path="description" class="errors" />

		</p>
		<input type="submit" value="Submit" />
	</form:form>


</body>
</html>