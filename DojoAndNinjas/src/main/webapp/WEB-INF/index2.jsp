<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta charset="ISO-8859-1">
<title>New Dojo</title>
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/dojos/create" method="post" modelAttribute="dojo">
		<p>
			<form:label path="name">Name</form:label>
			<form:input path="name" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>