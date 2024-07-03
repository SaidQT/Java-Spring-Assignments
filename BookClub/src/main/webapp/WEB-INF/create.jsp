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
<link rel="stylesheet" type="text/css" href="/form.css">

<title>New Book</title>
</head>
<body>
	<a href="/books">Back to shelves</a>
	<form:form action="/createbook" method="post" modelAttribute="book">
		<p>
			<form:label path="title">Title</form:label>

			<form:input path="title" />
			<form:errors path="title" class="errors" />
		</p>
		<p>
			<form:label path="author">Author</form:label>

			<form:input path="author" />
			<form:errors path="author" class="errors" />
		</p>
		<p>
			<form:label path="myThoughts">My Thoughts</form:label>
			<form:textarea path="myThoughts" />
			<form:errors path="myThoughts" />

		</p>

		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>