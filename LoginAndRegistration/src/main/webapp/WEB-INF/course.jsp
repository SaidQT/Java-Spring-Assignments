<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Course</title>
<link rel="stylesheet" href="/course.css">
</head>
<body>
	<h1>Create a Course</h1>
	<form:form action="/classes/new" method="post" modelAttribute="course">

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


		<div class="buttons">
			<input type="submit" value="Submit" />
	</form:form>
	<button>
		<a href="/cancel">Cancel</a>
	</button>
	</div>
</body>
</html>