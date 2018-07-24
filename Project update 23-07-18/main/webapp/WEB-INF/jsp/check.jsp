<Html>
<Head>
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<title>Account Details</title>
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
				<td><H1 >Account Details</H1></td>
				<td><h4><a href="logout" class="badge badge-dark">Logout</a></h4></td>
				<td><h4><a href="myprofile" class="badge badge-dark">My Profile</a></h4></td>
			</tr>
			</table>
		</div>
	</div>
	<blockquote class="blockquote">
		
		<table class="table table-hover table-bordered">
			<tr>
			<td>Account Number</td>
			<td>${accountnumber}</td>
			</tr>
			<tr>
			<td>Account Type</td>
			<td>${accounttype}</td>
			</tr>
						<tr>
			<td>Account Balance</td>
			<td>Rs. ${accountbalance}</td>
			</tr>
			<tr>
			<td>Date Opened(Date)</td>
			<td>${accountopendate}</td>
			</tr>
			<tr>
			<td>Date Opened(Timestamp)</td>
			<td>${accountopentimestamp}</td>
		</table>
		
	
	</blockquote>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</Html>