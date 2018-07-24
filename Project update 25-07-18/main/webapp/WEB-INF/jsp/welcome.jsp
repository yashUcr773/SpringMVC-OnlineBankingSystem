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
<title>Welcome</title>
</head>

<body>
<div class="jumbotron">
		<div class ="container">
			<table class="table">
						<tr>
				<td rowspan=3><img src="resources/Logo.png"></td>
			</tr>
			<tr>
			<td><h4><a href="backfromupdate" class="badge badge-dark">My Profile</a></h4></td>
				<td><H1 >Welcome <small>${firstname}</small></H1></td>
				<td><h4><a href="logout" class="badge badge-dark">Logout</a></h4></td>
				<td><h4><a href="home" class="badge badge-dark">Return Home</a></h4></td>

			</tr>
			</table>
		</div>
	</div>
	<blockquote class="blockquote">
		<h3>
	  		Your Generated Account Number is
	  		<small class="text-muted">${accountnumber}</small>
		</h3>
		<p class="lead">
	  	Please note it down and store it at a safe place.
		</p>
		<a href="generatepdf3" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Save to Pdf</a>
	</blockquote>
	
</body>
</html>