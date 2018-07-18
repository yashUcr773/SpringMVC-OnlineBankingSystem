<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

<title>All Transactions</title>
</head>

<body>

<div class="jumbotron">
		<div class ="container">
			<table class="table">
			<tr>
			<td><h4><a href="backfromupdate" class="badge badge-dark">Back</a></h4></td>
				<td><H1 >Users</H1></td>
				<td><h4><a href="home.jsp" class="badge badge-dark">Return Home</a></h4></td>
			</tr>
			</table>
		</div>
	</div>
	
	
	
	
	
	
	<div class="container">
        <table class="table table-striped">
            <thead>
            	<tr class="tr tr-success">
					<td><strong>User Name</strong></td>
					<td><strong>First Name</strong></td>
					<td><strong>Last Name</strong></td>
					<td><strong>Email</strong></td>
					<td><strong>Address</strong></td>
					<td><strong>Phone</strong></td>
					<td><strong>Account Number</strong></td>
					<td><strong>Account Type</strong></td> 
				</tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="temp">
                    <tr>
						<td>${temp.username}</td>
						<td>${temp.firstname}</td>
						<td>${temp.lastname}</td>
						<td>${temp.email}</td>
						<td>${temp.address}</td>
						<td>${temp.phone}</td>
						<td>${temp.accountnumber}</td>
						<td>${temp.accounttype}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>