<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
      <%@ page import="java.text.SimpleDateFormat" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Time</title>
<link rel="stylesheet" type="text/css" href="/css/time.css">
<script type="text/javascript" src="/js/time.js"></script>
</head>
<body>
<p><%= new SimpleDateFormat("h:mm a").format(new Date()) %></p>

</body>
</html>