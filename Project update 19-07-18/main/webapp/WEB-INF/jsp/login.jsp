<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<style>
.jumbotron
{
	padding-top :10%;
	padding-bottom :10%;
	padding-left :10%;
	padding-right :10%;
}


</style>

<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>

</head>
<body>

	<div class="jumbotron">
		<div class ="container">
			<table class="table">
						<tr>
				<td rowspan=2><img src="resources/Logo.png"></td>
			</tr>
			<tr>
				<td><H1 >Login</H1></td>
				<td><h4><a href="home.jsp" class="badge badge-dark">Return Home</a></h4></td>
			</tr>
			</table>
			<c:set var = "updated" scope = "session" value = "Username or Password is Incorrect!!"/>	
			<core:if test="${message == updated}">
				<div class="font-weight-bold alert alert-danger">
				${message}
				</div>
			</core:if>
		</div>
	</div>
	
	<div class="form-group">
		<form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post">
			<table class="table table-hover">
				<tr>
					<td><form:label path="username">Username: </form:label></td>
					<td><form:input path="username" name="username" id="username"/></td>
				</tr>
				<tr>
					<td><form:label path="accountnumber">Account Number: </form:label></td>
					<td><form:input path="accountnumber" name="accountnumber" id="accountnumber" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password:</form:label></td>
					<td><form:password path="password" name="password" id="password"/></td>
				</tr>
				<tr>
					<td colspan="2"><form:button id="login" name="login" class= "btn btn-primary btn-lg btn-block">Login</form:button></td>
				</tr>
			</table>
		</form:form>
	</div>


	
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>