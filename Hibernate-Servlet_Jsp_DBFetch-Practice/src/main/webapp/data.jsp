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
	<h2>ALL STUDENT DATA</h2>
	<table border="2">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>FEE</th>
		</tr>
		<c:forEach items="${list}" var="ob">
			<tr>
				<td>${ob.sid}</td>
				<td>${ob.sname}</td>
				<td>${ob.sfee}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>