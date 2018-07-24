<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<Html>
<Head>
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<title>Add Money</title>
</Head>
<body>
	<div class="jumbotron">
		<div class ="container">
			<table class="table">
			<tr>
				<td rowspan=4><img src="resources/Logo.png"></td>
			</tr>
			<tr>
				<td><h4><a href="backfromupdate" class="badge badge-dark">Back</a></h4></td>
				<td><H1 >Add Money</H1></td>
				<td><h4><a href="logout" class="badge badge-dark">Logout</a></h4></td>
			</tr>
			</table>
			<c:set var = "Error" scope = "session" value = "Internal Error Occured, Try Again Later"/>	
			<core:if test="${message == Error}">
				<div class="font-weight-bold alert alert-danger">
				${message}
				</div>
			</core:if>
			<c:set var = "Success" scope = "session" value = "Amount Added Successfully"/>	
			<core:if test="${message == Success}">
				<div class="font-weight-bold alert alert-success">
				${message}
				</div>
			</core:if>
		</div>
	</div>
	
	<div class="form-group">
		<form:form id="moneyForm" modelAttribute="money" action="addmoneyprocess" method="post">
			<table class="table table-hover">
				<tr>
					<td><form:label path="amount">Enter Amount</form:label></td>
					<td><form:input path="amount" name="amount" id="amount"/></td>
				</tr>
				<tr>
					<td colspan="2"><form:button id="add" name="add" class= "btn btn-primary btn-lg btn-block">Add</form:button></td>
				</tr>
			</table>
		</form:form>
	</div>
	



<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</Html>