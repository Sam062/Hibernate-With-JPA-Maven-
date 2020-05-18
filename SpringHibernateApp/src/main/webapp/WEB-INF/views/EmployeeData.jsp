<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Menu.jsp"%>
	<div class="container">
		<div class="card">

			<div class="card-header bg-info text-white">
				<H3>WELCOME TO EMPLOYEE DATA PAGE</H3>
			</div>

			<div class="card-body">

				<table class="table">
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>SALARY</th>
						<th>DEPT</th>
						<th colspan="2">OPERATION</th>
					</tr>
					<c:forEach items="${list}" var="ob">
						<tr>
							<td>${ob.empId}</td>
							<td>${ob.empName}</td>
							<td>${ob.empSal}</td>
							<td>${ob.empDetp}</td>
							<td><a href="remove?id=${ob.empId}" class="btn btn-danger">DELETE</a></td>
							<td><a href="edit?id=${ob.empId}" class="btn btn-success">EDIT</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

	</div>
</body>
</html>



