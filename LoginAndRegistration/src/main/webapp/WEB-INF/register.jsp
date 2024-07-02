<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
	<h1>Welcome</h1>
	<h2>Join our growing community</h2>
	<div class="sections">
		<form:form action="/register" method="post" modelAttribute="user">
			<p>
				<form:label path="userName">Username</form:label>

				<form:input path="userName" />
				<form:errors path="userName" class="errors" />
			</p>
			<p>
				<form:label path="email">Email</form:label>

				<form:input path="email" />
				<form:errors path="email" class="errors" />
			</p>
			<p>
				<form:label path="password">Password</form:label>
				<form:input type="password" path="password" />
				<form:errors path="password" />

			</p>
			<p>
				<form:label path="confirm">Confirm Password</form:label>

				<form:input path="confirm" type="password"/>
				<form:errors path="confirm" class="errors" />

			</p>
			<input type="submit" value="Submit" />
		</form:form>

		<form:form action="/login" method="post" modelAttribute="newLogin">
			<p>
				<form:label path="email">Email</form:label>

				<form:input path="email" />
				<form:errors path="email" class="errors" />
			</p>
			<p>
			<p>
				<form:label path="password">Password</form:label>
				<form:input type="password" path="password" />
				<form:errors path="password" />

			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>