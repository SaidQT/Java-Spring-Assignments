<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
</head>
<body>
	<h2>Edit Travel</h2>
	<a href="/expenses">Go back</a>


	<form:form action="/expenses/edit/edits/${expense.id}" method="post" modelAttribute="expense">
		<input type="hidden" name="_method" value="put">

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