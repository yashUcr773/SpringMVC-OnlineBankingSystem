<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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

<title>Locate Branch</title>

</head>
<body>

	<div class="jumbotron">
		<div class ="container">
			<table class="table">
						<tr>
				<td rowspan=2><img src="resources/Logo.png"></td>
			</tr>
			<tr>
				<td><H1 >Locate Branch</H1></td>
				<td><h4><a href="home.jsp" class="badge badge-dark">Return Home</a></h4></td>
			</tr>
			</table>
		</div>
	</div>
	
	<div class="form-group">
		<form:form id="locateForm" modelAttribute="locate" action="locateProcess" method="post">
			<table class="table table-hover">
				<tr>
					<td><form:label path="city">City : </form:label></td>
					<td><form:input path="city" name="city" id="city"/></td>
				</tr>
				<tr>
					<td><form:label path="state">State: </form:label></td>
					<td><form:input path="state" name="state" id="state" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:button id="Locate" name="Locate" class= "btn btn-primary btn-lg btn-block">Locate</form:button></td>
				</tr>
			</table>
		</form:form>
	</div>


	
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>