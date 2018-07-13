<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
.no-border{
            background: transparent;
            border-top: transparent;
            border-left: transparent;
            border-right: transparent;
            border-bottom: 4px solid;
            font-weight: 200;
            color: white;
            padding-left: 0;
}

</style>
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Details</title>
</head>
<body>
	<div class="jumbotron">
  		<div class="container">
			<div class="page-header">
				<table class="table">
					<tr>
						<td><h4><a href="backfromupdate" class="badge badge-dark">Back</a></h4></td>
  						<td><h1>Update Details</h1></td>
  						<td><h4><a href="logout" class="badge badge-dark">Logout</a></h4></td>
					</tr>
				</table>
			<c:set var = "Success" scope = "session" value = "Details Updated"/>	
			<core:if test="${Message == Success}">
				<div class="font-weight-bold alert alert-success">
				${Message}
				</div>
			</core:if>
			</div>
		</div>
	</div>
	
	
		<form:form id="regForm" modelAttribute="user" action="updateProcess" method="post">
			<table class="table table-hover">
				<tr>
				<td><form:label path="username">User Name</form:label></td>
				<td><form:input path="username" name="username" id="username" readonly="true" class="form-control-plaintext" box-shadow="none"/></td>
				<td><form:label path="accountnumber">Account Number</form:label></td>
				<td><form:input path="accountnumber" name="accountnumber" id="accountnumber" readonly="true"/></td>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" name="password" id="password"/></td>
				</tr>
			</table>
			
				<br><br><br>
				<table class="table table-hover">
				<tr>
					<td><form:label path="firstname">First Name</form:label></td>
					<td><form:input path="firstname" name="firstname" id="firstname"/></td>
				</tr>
				<tr>
					<td><form:label path="lastname">Last Name</form:label></td>
					<td><form:input path="lastname" name="lastname" id="lastname" /></td>
				</tr>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input path="email" name="email" id="email" /></td>
				</tr>
				<tr>
					<td><form:label path="dateofbirth">DateofBirth(DD-MM-YYYY): </form:label></td>
					<td><form:input path="dateofbirth" name="dateofbirth" id="dateofbirth"/></td>
				</tr>
				<tr>
					<td><form:label path="address">Address</form:label></td>
					<td><form:input path="address" name="address" id="address" /></td>
				</tr>
				<tr>
					<td><form:label path="phone">Phone</form:label></td>
					<td><form:input path="phone" name="phone" id="phone" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:button id="update" name="update" class= "btn btn-primary btn-lg btn-block">Update</form:button></td>
				</tr>
			</table>
		</form:form>
	
	
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>