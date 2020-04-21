<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>WELCOME TO EMPLOYEE REG PAGE!</h2>
	<form action="reg" method="post">
		<pre>
			ID   : <input type="text" name="eid">
			NAME : <input type="text" name="ename">
			SAL  : <input type="text" name="esal">
			  <input type="submit" value="Register"><br>
			  <b>
			${msg}
			  </b>
		</pre>
	</form>
</body>
</html>