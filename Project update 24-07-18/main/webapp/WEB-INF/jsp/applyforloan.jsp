<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

<style>

h4	{
	line-height: 1.4;
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loans</title>
</head>

<body>
	<div class="jumbotron">
  		<div class="container">
			<div class="page-header">
				<table class="table">
					<tr>
						<td rowspan=3><img src="resources/Logo.png"></td>
					</tr>
					<tr>
						<td><h4><a href="backfromupdate" class="badge badge-dark">Back</a></h4></td>
  						<td><h1>Loans</h1></td>
  						<td><h4><a href="logout" class="badge badge-dark">Logout</a></h4></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<table class="table table-striped table-hover">
		<tr>
			<td style="text-align:right"><a href="homeloan" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Home Loan</a></td>
			<td><a href="carloan" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Car Loan</a></td>
		</tr>
		<tr>
			<td style="text-align:right"><a href="goldloan" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Gold Loan</a></td>
			<td><a href="personalloan" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Personal Loan</a></td>
		</tr>
		<tr>
			<td colspan=2 style="padding-left:41%"><a href="emicalculator" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Emi Calculator</a></td>
		</tr>
	</table>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>