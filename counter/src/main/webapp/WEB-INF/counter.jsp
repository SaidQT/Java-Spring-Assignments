<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>
<p>You have visited <c:out value="${count}"/> times.</p>
<p><a href='/'>Test visit</a></p>
<p><a href='/increment'>Test another visit</a></p>
<button><a href='/reset'>Reset</a></button>
</body>
</html>