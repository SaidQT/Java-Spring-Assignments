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
<title>LogIn And Registration</title>
<link rel="stylesheet" href="/style.css">
</head>
<body>
	<h1>Course Platform- Instructors</h1>
	<div class="cotainer">
		<div class="registration">

			<h2>Registration:</h2>

			<form:form action="/register" method="post" modelAttribute="newUser">

				<div>
					<form:label path="userName">User Name</form:label>
					<form:input path="userName" />
				</div>
				<div>
					<form:label path="email">Email</form:label>
					<form:input path="email" />
				</div>
				<div>
					<form:label path="password">Password</form:label>
					<form:input type="password" path="password" />
				</div>
				<div>
					<form:label path="confirm">Confirm Password</form:label>
					<form:input type="password" path="confirm" />
				</div>
				<input type="submit" value="Register">


			<p>	<form:errors path="userName" /></p>
			<p>	<form:errors path="email" /></p>
			<p>	<form:errors path="password" /></p>
			<p>	<form:errors path="confirm" /></p>

			</form:form>

		</div>
		<div class="login">

			<h2>Login:</h2>
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<div>
					<form:label path="email">Email</form:label>
					<form:input path="email" />
				</div>
				<div>
					<form:label path="password">Password</form:label>
					<form:input type="password" path="password" />
				</div>
				
				<p>	<form:errors path="email" /></p>
				<p>	<form:errors path="password" /></p>
				<input type="submit" value="Login">
			</form:form>
		</div>
	</div>
</body>
</html>