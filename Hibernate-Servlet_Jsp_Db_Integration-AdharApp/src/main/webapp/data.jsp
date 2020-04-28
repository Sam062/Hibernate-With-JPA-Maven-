<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>WELCOME TO ADHAR DATA PAGE</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>DOB</th>
			<th>GENDER</th>
			<th>SALARY</th>
			<th>MOBILE</th>
			<th>DEPT</th>
			<th>ADDRESS</th>
			<th colspan="2">LINK</th>
		</tr>
		<c:forEach items="${list}" var="ob">
			<tr>
				<th>${ob.empID}</th>
				<th>${ob.empName}</th>
				<th>${ob.dob}</th>
				<th>${ob.gender}</th>
				<th>${ob.empSal}</th>
				<th>${ob.mobileNo}</th>
				<th>${ob.department}</th>
				<th>${ob.address}</th>
				<th><a href="edit?id=${ob.empID}">UPDATE</a></th>
				<th><a href="delete?id=${ob.empID}">DELETE</a></th>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10" align="center"><a
				href="http://localhost:9697/Hibernate-Servlet_Jsp_Db_Integration-AdharApp/index.jsp">NEW
					REGISTRATION</a></td>
		</tr>
	</table>
	${msg}
</body>
</html>