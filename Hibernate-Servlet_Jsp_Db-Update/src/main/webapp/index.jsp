<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>WELCOME TO CUSTOMER REGISTER PAGE !</h2>
	<form action="reg" method="POST">
		<pre>
		ID   :<input type="text" name="cid">
		NAME :<input type="text" name="cname">
		SAL  :<input type="text" name="csal">
		 <input type="submit" value="Register">
		 ${msg}
	</pre>
	</form>
</body>
</html>