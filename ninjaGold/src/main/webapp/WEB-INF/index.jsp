<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link rel="stylesheet" type="text/css" href="/style.css">
<script type="text/javascript" src="/main.js"></script>
</head>
<body>
	<div class="mainheader">
		<div class='header'>
			<h2>Your Gold</h2>
			<p><c:out value="${count}"></c:out></p>
		</div>
		<button><a href="/reset">Reset Gold</a></button>
	</div>
	<div class="container">
		<div class="card">
			<h2>Farm</h2>
			<div>
				<p>(earns 10-20 gold)</p>
				<form action='/play' method='post'>
					<input type='hidden' name='game' value='farm'>
					<button>
						Find Gold!
					</button>
				</form>
			</div>
		</div>
		<div class="card">
			<h2>Cave</h2>
			<div>
				<p>(earns 10-20 gold)</p>
				<form action='/play' method='post'>
					<input type='hidden' name= 'game' value='cave'>
					<button>
						Find Gold!
					</button>
				</form>
			</div>
		</div>
		<div class="card">
			<h2>House</h2>
			<div>
				<p>(earns 2-5 gold)</p>
				<form action='/play' method='post'>
					<input type='hidden' name='game' value='house'>
					<button>
					Find Gold!
					</button>
				</form>
			</div>
		</div>
		<div class="card">
			<h2>Quest</h2>
			<div>
				<p>(earns/takes 0-50 gold)</p>
				<form action='/play' method='post'>
					<input type='hidden' name='game' value='quest'>
					<button>
						Find Gold!
					</button>
				</form>
			</div>
		</div>
		<div class="card">
			<h2>Spa</h2>
			<div>
				<p>(takes 5-20 gold)</p>
				<form action='/play' method='post'>
					<input type='hidden' name='game' value='spa'>
					<button>
						Pay Gold!
					</button>
				</form>
			</div>
		</div>
	</div>
	<h3>Activities:</h3>
	<div class="activities">
			<c:forEach var= "part" items= "${activity}">
				<c:if test="${part.indexOf('won') != -1}">					
						<p style="color:green;"><c:out value="${part}"></c:out></p>
				</c:if>
				<c:if test="${part.indexOf('lost') !=-1}">
					<p style="color:red;"><c:out value="${part}"></c:out></p>
				</c:if>
			</c:forEach>
	</div>
</body>
</html>