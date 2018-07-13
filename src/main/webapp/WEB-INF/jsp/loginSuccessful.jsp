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
<title>Welcome ${firstname}</title>
</head>

<body>
	<div class="jumbotron">
  		<div class="container">
			<div class="page-header">
				<table class="table">
					<tr>
  						<td><h1>Welcome ${firstname}</h1></td>
  						<td><h4><a href="logout" class="badge badge-dark">Logout</a></h4></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	
	<blockquote class="blockquote">
		<p><a href="update" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Update Details</a></p>
		<p><a href="transactions" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Transactions</a></p>
		<p><a href="pay" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Pay</a></p>
		<p><a href="check" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Check Account Details</a></p>
		<p><a href="addmoney" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Add Money</a></p>
		<p><a href="changepassword" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">ChangePassword</a></p>
		<p><a href="linkaadhaar" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Link AADHAAR</a></p>
		<p><a href="linkpan" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Link Pan</a></p>
		<p><a href="applyforloan" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Apply for Loan</a></p>
		<p><a href="bankifsc" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Bank Details via IFSCode</a></p>
	</blockquote>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>