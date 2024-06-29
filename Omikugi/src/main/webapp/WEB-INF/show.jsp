<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show</title>
<link rel="stylesheet" type="text/css" href="/css/show.css">

</head>
<body>
	<h1>Here is you Omikugi</h1>
	<p>In <c:out value="${random}"></c:out> years, you will live in <c:out value="${city }"></c:out> with <c:out value="${person}"></c:out> as your room mate, <c:out value="${hobby}"></c:out> for a living. The next time you see a <c:out value="${living }"></c:out> you will have a good luck.Also, <c:out value="${message}"></c:out>.</p>
	<a href="/omikugi">Go back</a>
</body>
</html>