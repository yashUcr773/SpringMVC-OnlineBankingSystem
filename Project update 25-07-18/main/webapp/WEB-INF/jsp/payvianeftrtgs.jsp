<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<title>NEFT / RTGS</title>
</head>

<body>
	<div class="jumbotron">
		<div class ="container">
			<table class="table">
						<tr>
				<td rowspan=4><img src="resources/Logo.png"></td>
			</tr>
				<tr>
					<td><h4><a href="backfromupdate" class="badge badge-dark">Back</a></h4></td>
					<td><H1 >NEFT / RTGS</H1></td>
					<td><h4><a href="logout" class="badge badge-dark">Logout</a></h4></td>
					<td><h4><a href="home" class="badge badge-dark">Return Home</a></h4></td>

				</tr>
			</table>
		</div>
	</div>

	<form:form id="payForm" modelAttribute="neft" action="payvianeftrtgsProcess" method="post" class="needs-validation">
	
		<table class="table table-hover">
			<tr>
				<td><form:label path="date">Date</form:label></td>
				<td><form:input path="date" name="date" id="date" readonly="true"/></td>
				<td><form:label path="timestamp">Time Stamp</form:label></td>
				<td><form:input path="timestamp" name="timestamp" id="timestamp" readonly="true"/></td>
			</tr>
		</table>
			
			<table class="table table-hover">
			<tr>
				<th colspan="2"><h3 style="text-align:center"><strong>Sender's Details</strong></h3></th>
			</tr>
			
			<tr>
				<td><form:label path="sendernumber">Sender's Account Number : </form:label></td>
				<td><form:input path="sendernumber" name="sendernumber" id="sendernumber" readonly="true" class="form-control-plaintext" box-shadow="none"/></td>
			</tr>
			
			<tr>
				<td><form:label path="sendername">Sender's Name : </form:label></td>
				<td><form:input path="sendername" name="sendername" id="sendername" readonly="true" class="form-control-plaintext" box-shadow="none"/></td>
			</tr>
			
			<tr>
				<td><form:label path="senderphone">Sender's Phone Number : </form:label></td>
				<td><form:input path="senderphone" name="senderphone" id="senderphone" readonly="true" class="form-control-plaintext" box-shadow="none"/></td>
			</tr>
			</table>
			
			
				<table class="table table-hover">
				<tr>
					<th colspan=3><h3 style="text-align:center"><strong>Reciever's Details</strong></h3></th>
				</tr>
				<tr>
					<td><form:label path="recipientnumber">Recipient's Account Number</form:label></td>
					<td colspan=2><form:input path="recipientnumber" name="recipientnumber" id="recipientnumber" required="true"/></td>
				</tr>
				<tr>
					<td><form:label path="recipientname">Recipient's Name</form:label></td>
					<td colspan=2><form:input path="recipientname" name="recipientname" id="recipientnumber" required="true"/></td>
				</tr>
				<tr>
					<td><form:label path="amount">Amount</form:label></td>
					<td colspan=2><form:input path="amount" name="amount" id="amount" required="true"/></td>
				</tr>
				<tr>
					<td><form:label path="recieverifsc">Recieving bank IFSC</form:label></td>
					<td><form:input path="recieverifsc" name="recieverifsc" id="recieverifsc" required="true"/></td>
					<td><form:button id="validate" name="validate" value = "validate" class= "btn btn-primary btn-lg btn-block">ValidateIFSC</form:button></td>
				</tr>
				<tr>
					<td><form:label path="remark">Purpose</form:label></td>
					<td colspan=2><form:textarea path="remark" name="remark" id="remark"/></td>
				</tr>
				
				
			<c:set var = "show" scope = "session" value = "show"/>	
			<core:if test="${message == show}">
			<div class="container">
        		<table class="table table-striped table-bordered">
            		<thead>
            			<tr class="tr tr-success">
							<td><strong>Name</strong></td>
							<td><strong>Code</strong></td>
							<td><strong>Address</strong></td>
							<td><strong>Contact</strong></td>
							<td><strong>Branch</strong></td>
							<td><strong>City</strong></td>
							<td><strong>District</strong></td>
						</tr>
	            	</thead>
	            	<tbody>
	                <c:forEach items="${ifsc}" var="temp">
	                    <tr>
							<td>${temp.name}</td>
							<td>${temp.address}</td>
							<td>${temp.code}</td>
							<td>${temp.contact}</td>	
							<td>${temp.branch}</td>
							<td>${temp.city}</td>
							<td>${temp.district}</td>
	                    </tr>
	                </c:forEach>
	            	</tbody>
	        	</table>
    		</div>
			</core:if>			
				
			
			<c:set var = "show" scope = "session" value = "Please Enter a valid IFSC"/>	
			<core:if test="${message == show}">
			<tr>
					<td colspan=3><div class="font-weight-bold alert alert-danger">
				${message}
				</div></td>
			</tr>
			</core:if>		
				

				<tr>
					<td colspan="3"><form:button id="pay" name="pay" value = "pay" class= "btn btn-primary btn-lg btn-block">Pay</form:button></td>
				</tr>
			</table>
		</form:form>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>