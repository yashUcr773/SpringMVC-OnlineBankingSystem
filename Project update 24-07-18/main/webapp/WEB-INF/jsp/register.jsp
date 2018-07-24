<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>

<body>
	<div class="jumbotron">
		<div class ="container">
			<table class="table">
						<tr>
				<td rowspan=2><img src="resources/Logo.png"></td>
			</tr>
				<tr>
					<td><H1>Register</H1></td>
					<td><h4><a href="home.jsp" class="badge badge-dark">Return Home</a></h4></td>
				</tr>
			</table>
			
			<c:set var = "Error" scope = "session" value = "Email already exists"/>	
			<core:if test="${ErrorMessage == Error}">
				<div class="font-weight-bold alert alert-danger">
				${ErrorMessage}
				</div>
			</core:if>
			<c:set var = "Error" scope = "session" value = "User Name already exists"/>	
			<core:if test="${ErrorMessage == Error}">
				<div class="font-weight-bold alert alert-danger">
				${ErrorMessage}
				</div>
			</core:if>
		</div>
	</div>
	
	<form:form id="regForm" modelAttribute="user" action="registerProcess" method="post" class="needs-validation">
		<table class="table table-hover">
			<tr>
				<td><form:label path="username">User Name</form:label></td>
				<td><form:input path="username" name="username" id="username" class="form-control" required="true"/></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" name="password" id="password" class="form-control" required="true"/></td>
			</tr>
			<tr>
				<td><form:label path="firstname">FirstName</form:label></td>
				<td><form:input path="firstname" name="firstname" id="firstname" class="form-control" required="true"/></td>
			</tr>
			<tr>
				<td><form:label path="lastname">LastName</form:label></td>
				<td><form:input path="lastname" name="lastname" id="lastname" class="form-control" required="true" /></td>
			</tr>
			<tr>
			<td><form:label path="day">Date of Birth : </form:label></td>
				<td>
					<form:select path="day" required="true">
							<form:option value="1" label="Day"></form:option>
							<form:options items="${day}"/>
						</form:select>

					<form:select path="month">
							<form:option value="Jan" label="Month"></form:option>
							<form:options items="${month}"/>
						</form:select>

					<form:select path="year">
							<form:option value="1900" label="Year"></form:option>
							<form:options items="${year}"/>
						</form:select>
				</td>
			</tr>
			
			
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" name="email" id="email" class="form-control" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" name="address" id="address" class="form-control" required="true"/></td>
			</tr>
			<tr>
				<td><form:label path="phone">Phone</form:label></td>
				<td><form:input path="phone" name="phone" id="phone" class="form-control" required="true"/></td>
			</tr>
			<tr>
				<th>Account Type</th>
					<td>
					<form:select path="accounttype">
							<form:option value="savings" label="Account Type"></form:option>
							<form:options items="${acctype}"/>
						</form:select>
				</td>
				</tr>
			<tr>
				<td colspan=2><form:button id="register" name="register" class= "btn btn-primary btn-lg btn-block">Register</form:button></td>
			</tr>
		</table>

	</form:form>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>