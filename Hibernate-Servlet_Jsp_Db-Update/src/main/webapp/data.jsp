<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>CUSTOMER DATA PAGE</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>SALARY</th>
			<th>LINK</th>
		</tr>
		<c:forEach items="${list}" var="ob">
			<tr>
				<td>${ob.cid}</td>
				<td>${ob.cname}</td>
				<td>${ob.csal}</td>
				<td><a href="delete?cid=${ob.cid}">DELETE</a></td>
				<td><a href="edit?cid=${ob.cid}">EDIT</a></td>
			</tr>
		</c:forEach>

	</table>
	${msg}

</body>
</html>