<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<body>
	<h2>WELCOME TO EMPLOYEE EDIT PAGE</h2>
	<form action="update" method="POST">
		<table>
			<tr>
				<td>AdharId</td>
				<td><input type="text" name="eid" required="required"
					readonly="readonly" value="${ob.empID}"></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><input type="text" name="ename" required="required"
					value="${ob.empName}"></td>
			</tr>
			<tr>
				<td>DOB</td>
				<td><input type="date" name="dob" required="required"
					value="${ob.dob}"></td>
			</tr>
			<tr>
				<td>GENDER</td>
				<td><input type="radio" name="gen" value="MALE">M <input
					type="radio" name="gen" value="FEMALE">F <input
					type="radio" name="gen" value="OTHER" required="required">OTHER</td>
			</tr>
			<tr>
				<td>SALARY</td>
				<td><input type="text" name="esal" required="required"
					value="${ob.empSal}"></td>
			</tr>
			<tr>
				<td>MOBILE</td>
				<td><input type="text" name="mob" required="required"
					value="${ob.mobileNo}"></td>
			</tr>
			<tr>
				<td>DEPT</td>
				<td><input type="text" name="dept" required="required"
					value="${ob.department}"></td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td><textarea rows="2" cols="15" name="addr"
						required="required"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update"></td>
			</tr>
			<tr>
				<td><a
					href="http://localhost:9697/Hibernate-Servlet_Jsp_Db_Integration-AdharApp/data">CANCLE
						UPDATE</a></td>
			</tr>
		</table>
	</form>
</body>
</html>