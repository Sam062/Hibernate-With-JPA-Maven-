<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome To Edit Page</h2>
	<form action="update" method="POST">
		<pre>
		    ID :<input type="text" name="cid" value="${cob.cid}"
				readonly="readonly">
		  NAME :<input type="text" name="cname" value="${cob.cname}">
		SALARY :<input type="text" name="csal" value="${cob.csal}">
		  <input type="submit" value="UPDATE">
	</pre>
	</form>
</body>
</html>