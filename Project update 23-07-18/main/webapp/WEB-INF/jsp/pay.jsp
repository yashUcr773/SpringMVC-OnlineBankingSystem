<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<title>Payment</title>
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
					<td><H1 >Payment</H1></td>
					<td><h4><a href="logout" class="badge badge-dark">Logout</a></h4></td>
					<td><h4><a href="myprofile" class="badge badge-dark">My Profile</a></h4></td>
				</tr>
			</table>
		</div>
	</div>
	
	

	
	
	<form:form id="payForm" modelAttribute="pay" action="payProcess" method="post">
			<table class="table table-hover">
				<tr>
				<td></td>
				<td></td>
				<th colspan=2><h3><strong>Direct Account Transfer</strong></h3></th>
				<td></td>
				<td></td>
				</tr>
				<tr>
				<td><form:label path="sender">Sender's Account Number</form:label></td>
				<td><form:input path="sender" name="sender" id="sender" readonly="true" class="form-control-plaintext" box-shadow="none"/></td>
				<td><form:label path="date">Date</form:label></td>
				<td><form:input path="date" name="date" id="date" readonly="true"/></td>
				<td><form:label path="timestamp">Time Stamp</form:label></td>
				<td><form:input path="timestamp" name="timestamp" id="timestamp" readonly="true"/></td>
				</tr>
			</table>
			
				<br><br><br>
				<table class="table table-hover">
				<tr>
					<td><form:label path="recipient">Recipient's Account Number</form:label></td>
					<td><form:input path="recipient" name="recipient" id="recipient"/></td>
				</tr>
				<tr>
					<td><form:label path="amount">Amount</form:label></td>
					<td><form:input path="amount" name="amount" id="amount" /></td>
				</tr>
				<tr>
					<td><form:label path="remark">Remark</form:label></td>
					<td><form:textarea path="remark" name="remark" id="remark" /></td>
				</tr>
				<tr>
					<td colspan="2"><form:button id="pay" name="pay" class= "btn btn-primary btn-lg btn-block">Pay</form:button></td>
				</tr>
			</table>
		</form:form>
		
		
		
			<h3 style="text-align:center"><strong>NEFT / RTGS Charges, Timings, Limits</strong></h3>
	
	<table class="table table-border">
		<tr>
			<th>Transaction Timings</th>
			<th>NEFT</th>
			<th>RTGS</th>
		</tr>
		<tr>
			<td>Monday to Saturday <br>(Except 2nd and 4th Saturday)</td>
			<td>8:00 AM to 6:30 PM</td>
			<td>8:00 AM to 4:30 PM</td>
		</tr>
		<tr><td></td><td></td><td></td></tr>
		<tr>
			<th>Transaction Limits</th>
			<th>NEFT</th>
			<th>RTGS</th>
		</tr>
		<tr>
			<td>Minimum</td>
			<td>Re 1.</td>
			<td>Rs. 2 lakhs.</td>
		</tr>
		<tr>
			<td>Maximum</td>
			<td>Rs. 10 lakhs.</td>
			<td>Rs. 10 lakhs.</td>
		</tr>
		<tr><td></td><td></td><td></td></tr>
		<tr>
			<th>Transaction Charges</th>
			<th>NEFT</th>
			<th>RTGS</th>
		</tr>
		<tr>
			<td>Amounts upto Rs 10,000</td>
			<td>Rs 2.50 + Applicable GST</td>
			<td>Not Applicable</td>
		</tr>
		<tr>
			<td>Amounts above Rs 10,000 and upto Rs 1 lakh</td>
			<td>Rs 5 + Applicable GST</td>
			<td>Not Applicable</td>
		</tr>		
		<tr>
			<td>Amounts above Rs 1 lakh and upto Rs 2 lakh</td>
			<td>Rs 15 + Applicable GST</td>
			<td>Not Applicable</td>
		</tr>		
		<tr>
			<td>Amounts above Rs 2 lakh and upto Rs 5 lakh<br>(Incl. Rs 2 lakh for RTGS)</td>
			<td>Rs 25 + Applicable GST</td>
			<td>Rs 25 + Applicable GST</td>
		</tr>		
		<tr>
			<td>Amounts above Rs 5 lakh and upto Rs 10 lakh</td>
			<td>Rs 25 + Applicable GST</td>
			<td>Rs 50 + Applicable GST</td>
		</tr>
		<tr style="margin-left:50px; margin-right:50px" >	
			<td colspan=3 style="margin-left:50px; margin-right:50px"><p><a href="payvianeftrtgs" class="btn btn-primary btn-lg btn-block active" role="button" aria-pressed="true">Pay via NEFT/RTGS</a></p></td>
		</tr>
	</table>
		
		
		
		
		
		
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>