<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
    <%@ page import="java.text.SimpleDateFormat" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date</title>
<link rel="stylesheet" type="text/css" href="/css/date.css">
<script type="text/javascript" src="/js/date.js"></script>
</head>
<body>
<p> <%= new SimpleDateFormat("EEEE, MMMM dd, yyyy").format(new Date()) %></p>
</body>
</html>