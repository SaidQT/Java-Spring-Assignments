<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Edit a Burger</h2>


	<form:form action="/burgers" method="post" modelAttribute="burger">
	 <input type="hidden" name="_method" value="put">
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