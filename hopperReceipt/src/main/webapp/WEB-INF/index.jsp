<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hopper's Reciept</title>
</head>
<body>
	<h1>Customer name: <c:out value="${name}"/></h1>
	<h3>Item name: <c:out value="${itemName}"/></h3>
	<h3>Item name: <c:out value="${price}"/></h3>
	<h3>Item name: <c:out value="${description}"/></h3>
	<h3>Item name: <c:out value="${vendor}"/></h3>
	
</body>
</html>