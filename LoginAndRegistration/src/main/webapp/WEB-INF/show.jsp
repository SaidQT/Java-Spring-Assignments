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
<title>${course.name}</title>
</head>
<body>
<h2><c:out value="${course.name}"></c:out> with <c:out value="${course.user.userName}"></c:out></h2>
<h4>Day: <fmt:formatDate value="${course.day}" pattern="EEEE" /></h4>
<h4>Price: $ <c:out value="${course.price}"></c:out></h4>
<p><c:out value="${course.description}"></c:out></p>

<br>
<hr>
</body>
</html>