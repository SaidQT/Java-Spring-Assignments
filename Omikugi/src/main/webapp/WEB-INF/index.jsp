<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikugi</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
	<h1>Select an Omikugi</h1>
	<form action="/play" method='post'>
		<p>Pick any number between 5 and 25</p>
		<input type="number" name="random" min=5 max=25> <br> <br>
		<p>Enter the name of any city</p>
		<input type="text" name="city">
		<p>Enter the name of any real person</p>
		<input type="text" name="person">
		<p>Enter professional endeavor or hobby</p>
		<input type="text" name="hobby">
		<p>Enter any type of living thing</p>
		<input type="text" name="living">
		<p>Say something nice to someone</p>
		<textarea  name="message" rows="6" cols="40"></textarea>
		<p>Send and show a friend</p>
		<button>Send</button>

	</form>
</body>
</html>