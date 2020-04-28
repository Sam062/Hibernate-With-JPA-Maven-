<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<body>
	<h2>WELCOME TO ADHAR REGISTRATION PAGE</h2>
	<form action="reg" method="post">
		<table>
			<tr>
				<td>NAME</td>
				<td><input type="text" name="ename" required="required"></td>
			</tr>
			<tr>
				<td>DOB</td>
				<td><input type="date" name="dob" required="required"></td>
			</tr>
			<tr>
				<td>GENDER</td>
				<td><input type="radio" name="gen" value="MALE">M <input
					type="radio" name="gen" value="FEMALE">F <input
					type="radio" name="gen" value="OTHER">OTHER</td>
			</tr>
			<tr>
				<td>SALARY</td>
				<td><input type="text" name="esal" required="required"></td>
			</tr>
			<tr>
				<td>MOBILE</td>
				<td><input type="text" name="mob" required="required"></td>
			</tr>
			<tr>
				<td>DEPT</td>
				<td><input type="text" name="dept" required="required"></td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td><textarea rows="2" cols="15" name="addr"
						required="required"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
	<a href="http://localhost:9697/Hibernate-Servlet_Jsp_Db_Integration-AdharApp/data">GetAllData</a>
	${msg}
</body>
</html>