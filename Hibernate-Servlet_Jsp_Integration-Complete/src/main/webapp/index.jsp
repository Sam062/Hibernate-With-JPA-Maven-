<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<body>
	<h1>WELCOME TO EMPLOYEE REGISTER PAGE</h1>
	<form action="add" method="post">
		<pre>
			   ID  : <input type="text" name="eid" inputmode="numeric">
			  NAME : <input type="text" name="ename">
			SALARY : <input type="text" name="esal" inputmode="numeric">
			 
			         <input type="submit" value="Register">
			 
			 ${msg}
       </pre>
	</form>
</body>
</html>