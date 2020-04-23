<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h2>WELCOME TO EMPLOYEE UPDATE PAGE!</h2>
	<form action="update" method="POST">
		<pre>
		    ID : <input type="text" name="eid" value="${emp.eid}"
				readonly="readonly">
		  NAME : <input type="text" name="ename" value="${emp.ename}">
		SALARY : <input type="text" name="esal" value="${emp.esal}">
		  
		  <input type="submit" value="UPDATE">
		  
		   ${msg}
	</pre>
	</form>

</body>
</html>