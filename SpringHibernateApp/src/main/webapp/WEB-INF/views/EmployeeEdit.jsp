<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Menu.jsp"%>
	<div class="container">
		<div class="card">

			<div class="card-header bg-info text-white">
				<h3>WELCOME TO EMPLOYEE EDIT PAGE</h3>
			</div>

			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="employee">
					<form:hidden path="empId"/>
					<div class="row">
						<div class="col-4">NAME</div>
						<div class="col-4">
							<form:input path="empName" class="form-control"/>
						</div>
					</div>

					<div class="row">
						<div class="col-4">SALARY</div>
						<div class="col-4">
							<form:input path="empSal" class="form-control"/>
						</div>
					</div>


					<div class="row">
						<div class="col-4">DEPT</div>
						<div class="col-4">
							<form:select path="empDetp" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="DEV">DEV</form:option>
								<form:option value="BA">BA</form:option>
								<form:option value="QA">QA</form:option>
							</form:select>
						</div>
					</div>

					<input type="submit" value="Update" class="btn btn-success"/>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>