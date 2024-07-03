<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Book information</title>
<link rel="stylesheet" type="text/css" href="/book.css">
</head>
<body>
	<div class="part2">
		<h1>
			<c:out value="${book.title }"></c:out>
		</h1>
		<div class="link">
			<a href="/books">Back to the shelves</a>
		</div>
	</div>
	<h3>
		<c:if test="${flag == true }">
			<span class="red">You</span>
		</c:if>
		<c:if test="${flag == false  }">
			<span class="red"><c:out value="${book.user.userName} "></c:out></span>
		</c:if>
		read <span class="purple"><c:out value="${book.title}"></c:out></span>
		by <span class="green"><c:out value="${book.author }"></c:out></span>
	</h3>
	<h4>
		Here are
		<c:if test="${flag == true }">
			<span class="red">your thoughts:</span>
		</c:if>
		<c:if test="${flag == false  }">
			<span class="red"><c:out value="${book.user.userName} "></c:out>'s
				thoughts:</span>
		</c:if>


	</h4>
	<br>
	<hr>
	<p>
		<c:out value="${book.myThoughts }"></c:out>

	</p>
	<br>
	<hr>
	<div class="buttons">
		<c:if test="${flag == true }">
			<button>
				<a href="/books/${book.id}/edit">Edit</a>
			</button>
			<form action="/books/${book.id}" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					type="submit" value="Delete">
			</form>
		</c:if>
	</div>
</body>
</html>