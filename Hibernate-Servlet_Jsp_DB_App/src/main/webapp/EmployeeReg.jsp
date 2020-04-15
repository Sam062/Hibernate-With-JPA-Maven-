<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<body>
	<form action="reg" method="POST">
		<pre>
		EMPLOYEE_ID   : <input type="text" name="eid">
		EMPLOYEE_NAME : <input type="text" name="ename">
		EMPLOYEE_SAL  : <input type="text" name="esal">
		<input type="submit" value="register">
	</pre>
	</form>
	${msg}
</body>
</html>