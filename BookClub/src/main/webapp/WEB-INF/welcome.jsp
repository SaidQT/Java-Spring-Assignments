<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="part2">
		<h1>
			Welcome
			<c:out value="${user}"></c:out>
		</h1>
		<div class="link">
			 <a href="/books/new">Add a Book to
				my Shelf</a>
				<a href="/logout">Logout</a>
		</div>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Title</th>
				<th scope="col">Author</th>
				<th scope="col">Posted By</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${books}">

				<tr>
					<td scope="row"><c:out value="${book.id}"></c:out></td>
					<td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
					<td><c:out value="${book.author}"></c:out></td>
					<td><c:out value="${book.user.userName}"></c:out></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>