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
<title>Edit Course</title>
<link rel="stylesheet" href="/course.css">


</head>
<body>

	<h2>
		<c:out value="${course.name}"></c:out>
	</h2>
	<form:form action="/edit/${course.id}" method="post"
		modelAttribute="course">
		<input type="hidden" name="_method" value="put">

		<p>
			<form:label path="name">Name</form:label>
			<form:input path="name" />
			<form:errors path="name" />
		</p>
		<p>
			<form:label path="day">Day of Week</form:label>
			<form:input path="day" />
			<form:errors path="day" />
		</p>
		<p>
			<form:label path="price">Drop-in price</form:label>
			<form:input type="number" path="price" />
			<form:errors path="price" />
		</p>
		<p>
			<form:label path="time">Time</form:label>
			<form:input path="time" />
			<form:errors path="time" />
		</p>

		<p>
			<form:label path="description">Description</form:label>
			<form:textarea path="description" />
			<form:errors path="description" />
		</p>
		</p>



		<div class="buttons">
			<input type="submit" value="Submit" />
	</form:form>
	<button>
		<a href="/cancel">Cancel</a>
	</button>
	<form action="/classes/${course.id}" method="post">
		<input type="hidden" name="_method" value="delete"> <input
			type="submit" value="Delete" id="delete">
	</form>
	</div>

</body>
</html>