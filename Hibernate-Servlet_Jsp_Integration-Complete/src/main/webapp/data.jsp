<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<h2>WELCOME TO EMPLOYEE DATA PAGE</h2>
	<table border="1">
		<tr>
			<th>EMP ID</th>
			<th>NAME</th>
			<th>SALARY</th>
			<th>Operations</th>
		</tr>
		<c:forEach items="${listOfEmployees}" var="emp">
			<tr>
				<td>${emp.eid}</td>
				<td>${emp.ename}</td>
				<td>${emp.esal}</td>
				<td><a href="del?eid=${emp.eid}">DELETE</a>
				<a href="edit?eid=${emp.eid}">UPDATE</a></td>
			</tr>
		</c:forEach>
	</table>
	${msg}
</body>
</html>