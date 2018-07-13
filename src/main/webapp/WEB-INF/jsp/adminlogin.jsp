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
	
	
	<table class ="table table-hover tble-striped">
		<tr>
			<td><a href="update" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Update Details</a></td>
			<td><a href="allusers" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">View All Users</a></td>
		</tr>
		<tr>
			<td><a href="transactions" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Transactions</a></td>
			<td><a href="alltransactions" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">View All Transactions</a></td>
		</tr>
		<tr>
			<td><a href="pay" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Pay</a></td>
			<td><a href="allaccounts" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">View All Accounts</a></td>
		</tr>
		<tr>
			<td colspan=2><a href="check" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Check Account Details</a></td>
		</tr>
		<tr>	
			<td colspan=2><a href="addmoney" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Add Money</a></td>
		</tr>
		<tr>
			<td colspan=2><a href="changepassword" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">ChangePassword</a></td>
		</tr>
	</table>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>