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
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/welcome.css">

<title>Welcome</title>
</head>
<body>
	<div class="header">
		<h1>
			Namaste,
			<c:out value="${user.userName }"></c:out>
		</h1>
		<p>
			<a href="/logout">logout</a>
		</p>
	</div>
	<br>
	<br>
	<p>Course Schedule</p>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Class Name</th>
				<th scope="col">Instructor</th>
				<th scope="col">Weekday</th>
				<th scope="col">Price</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="course" items="${courses}">

				<tr>
				<c:if test="${course.user == user}">
					<td scope="row"><a href="classes/${course.id}"><c:out value="${course.name}"></a></c:out><button class="edit"><a href="classes/${course.id}/edit">Edit</a></button></td>
				</c:if>
				<c:if test="${course.user != user}">
					<td scope="row"><a href="classes/${course.id}"><c:out value="${course.name}"></c:out></a></td>
				</c:if>
					<td><c:out value="${course.user.userName}"></c:out></td>
					<td><fmt:formatDate value="${course.day}" pattern="EE" />
					
					<td> $ <c:out value="${course.price}"></c:out></td>
					
					</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	
	<button class="create"><a href="/classes/new">+ new course</a></button>
</body>
</html>