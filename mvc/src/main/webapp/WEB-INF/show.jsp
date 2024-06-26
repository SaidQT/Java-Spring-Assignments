<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>
	<h1><c:out value= "${title}"></c:out></h1>
	<p>Description: <c:out value="${desc}"></c:out></p>
	<p>Number of pages: <c:out value="${number}"></c:out></p>
	<p>Language: <c:out value="${lang}"></c:out></p>
</body>
</html>