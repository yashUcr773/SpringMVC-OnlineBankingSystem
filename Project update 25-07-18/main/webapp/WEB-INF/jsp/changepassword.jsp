<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<Html>
<Head>
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<title>Change Password</title>
</Head>
<body>
	<div class="jumbotron">
		<div class ="container">
			<table class="table">
			<tr>
				<td rowspan=3><img src="resources/Logo.png"></td>
			</tr>
			<tr>
				<td><h4><a href="backfromupdate" class="badge badge-dark">Back</a></h4></td>
				<td><H1 >Change Password</H1></td>
				<td><h4><a href="logout" class="badge badge-dark">Logout</a></h4></td>
			<td><h4><a href="home" class="badge badge-dark">Return Home</a></h4></td>
			</tr>
			</table>
			<c:set var = "Error" scope = "session" value = "Passwords Do not Match"/>	
			<core:if test="${message == Error}">
				<div class="font-weight-bold alert alert-danger">
				${message}
				</div>
			</core:if>
		</div>
	</div>
	
	<div class="form-group">
		<form:form id="passwordForm" modelAttribute="password" action="changepasswordprocess" method="post">
			<table class="table table-hover">
				<tr>
					<td><form:label path="current">Enter Current Password</form:label></td>
					<td><form:password path="current" name="current" id="current"/></td>
				</tr>
				<tr>
					<td><form:label path="newpass">Enter New Password</form:label></td>
					<td><form:password path="newpass" name="newpass" id="newpass"/></td>
				</tr>
				<tr>
					<td><form:label path="repeat">Repeat New Password</form:label></td>
					<td><form:password path="repeat" name="repeat" id="repeat"/></td>
				</tr>
				<tr>
					<td colspan="2"><form:button id="change" name="change" class= "btn btn-primary btn-lg btn-block">Change Password</form:button></td>
				</tr>
			</table>
		</form:form>
	</div>
	



<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</Html>