<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Link Aadhaar</title>
</head>

<body>
	<div class="jumbotron">
  		<div class="container">
			<div class="page-header">
				<table class="table">
					<tr>
						<td><h4><a href="backfromupdate" class="badge badge-dark">Back</a></h4></td>
  						<td><h1>Link Aadhaar</h1></td>
  						<td><h4><a href="logout" class="badge badge-dark">Logout</a></h4></td>
					</tr>
				</table>
			
			<c:set var = "updated" scope = "session" value = "Aadhaar Already Linked"/>	
			<core:if test="${alreadyupdated == updated}">
				<div class="font-weight-bold alert alert-info">
				${alreadyupdated}
				</div>
			</core:if>	
			<c:set var = "update" scope = "session" value = "Updated Successfully"/>	
			<core:if test="${Message == update}">
				<div class="font-weight-bold alert alert-success">
				${Message}
				</div>
			</core:if>
			<c:set var = "noUpdate" scope = "session" value = "Not Valid Aadhaar"/>	
			<core:if test="${Message == noUpdate}">
				<div class="font-weight-bold alert alert-Danger">
				${Message}
				</div>
			</core:if>
			</div>
		</div>
	</div>
	


	
	<form:form id="aadhaarForm" modelAttribute="UIDAI" action="linkAadhaarProcess" method="post" class="needs-validation">
		<table class="table table-striped">
			<tr>
				<th><form:label path="accountnumber">Account number</form:label></th>
				<td><form:input path="accountnumber" name="accountnumber" id="accountnumber" class="form-control" required="true" readonly="true"/></td>
			</tr>
			<core:if test="${UIDAI.pan != null}">
			<tr>
				<th><form:label path="pan">Pan Number</form:label></th>
				<td><form:input path="pan" name="pan" id="pan" class="form-control" required="true" readonly="true"/></td>
			</tr>
			</core:if>
			<tr>
				<th><form:label path="aadhaar">Aadhaar number(12 - digit)</form:label></th>
				<core:if test="${UIDAI.aadhaar == null}">
					<td><form:input path="aadhaar" name="aadhaar" id="aadhaar" class="form-control" required="true"/></td>
				</core:if>
				<core:if test="${UIDAI.aadhaar != null}">
					<td><form:input path="aadhaar" name="aadhaar" id="aadhaar" class="form-control" required="true" readonly="true"/></td>
				</core:if>
    		</tr>
			<tr>
				<td colspan=2><form:button id="link" name="link" class= "btn btn-primary btn-lg btn-block">Link</form:button></td>
	</table>
	</form:form>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>