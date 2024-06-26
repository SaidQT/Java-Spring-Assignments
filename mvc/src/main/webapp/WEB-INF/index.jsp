<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Language</th>
      <th scope="col">Pages</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${books}">
    <tr>
      <td><c:out value="${book.id}"></c:out></td>
      <td><a href=/books/${book.id}><c:out value="${book.title}"></c:out></a></td>
      <td><c:out value="${book.language}"></c:out></td>
      <td><c:out value="${book.numberOfPages}"></c:out></td>
    </tr>
   </c:forEach>
  </tbody>
</table>
</body>
</html>