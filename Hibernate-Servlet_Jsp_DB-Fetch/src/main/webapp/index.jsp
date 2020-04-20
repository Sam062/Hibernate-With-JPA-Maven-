<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<html>
<body>
	<H2>WELCOME TO EMPLOYEE REGISTER PAGE!</H2>
	<form action="reg" method="POST">
		<pre>
		ID   : <input type="text" name="eid" />
		NAME : <input type="text" name="ename" />
		SAL  : <input type="text" name="esal" />
 			<input type="submit" value="Register" />
		</pre>
	</form>
	${msg}
</body>
</html>
