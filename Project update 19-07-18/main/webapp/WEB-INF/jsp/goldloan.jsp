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

<title>Gold loan</title>

</head>
<body>

	<div class="jumbotron">
		<div class ="container">
			<table class="table">
			<tr>
				<td rowspan=4><img src="resources/Logo.png"></td>
			</tr>			
			<tr>
				<td><h4><a href="applyforloan" class="badge badge-dark">Back</a></h4></td>
				<td><H1 >Gold Loan</H1></td>
				<td><h4><a href="logout" class="badge badge-dark">Logout</a></h4></td>
				<td><h4><a href="myprofile" class="badge badge-dark">My Profile</a></h4></td>
			</tr>
			</table>
			<c:set var = "yes" scope = "session" value = "Please accept the Terms of Service"/>	
			<core:if test="${message == yes}">
				<div class="font-weight-bold alert alert-danger">
				${message}
				</div>
			</core:if>
			<c:set var = "no" scope = "session" value = "Loan Sanction Process Started"/>	
			<core:if test="${message == no}">
				<div class="font-weight-bold alert alert-success">
				${message}
				</div>
			</core:if>
		</div>
	</div>	
	<div class="form-group">
		<form:form id="homeloanform" modelAttribute="loan" action="goldloanProcess" method="post">
			<table class="table table-hover">
				<tr>
					<td><form:label path="principle">Amount(is Rs.): </form:label></td>
					<td><form:input path="principle" name="principle" id="principle"/></td>
				</tr>
				<tr>
					<td><form:label path="rate">Rate(in %): </form:label></td>
					<td><form:input path="rate" name="rate" id="rate" /></td>
				</tr>
				<tr>
					<td><form:label path="tenure">Duration(in Yrs.):</form:label></td>
					<td><form:input path="tenure" name="tenure" id="tenure"/></td>
				</tr>
			<c:set var = "no" scope = "session" value = "Loan Sanction Process Started"/>	
			<core:if test="${message == no}">
				<tr>
					<td><form:label path="emi">Calculated EMI(in Rs.) :</form:label></td>
					<td><form:input path="emi" name="emi" id="emi" readonly="true"/></td>
				</tr>
			</core:if>
				<tr>
				<td></td>
					<td><form:checkbox path="tos" value="true"/>    I agree with the  <a href="loantos" class="alert-link">Terms of Service</a></td>
				</tr>
				<tr>
					<td colspan="2"><form:button id="apply" name="apply" class= "btn btn-primary btn-lg btn-block">Apply</form:button></td>
				</tr>
			</table>
		</form:form>
	</div>


	
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>