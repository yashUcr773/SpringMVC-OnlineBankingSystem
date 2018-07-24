<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

<title>All Users</title>
</head>

<body>

<div class="jumbotron">
		<div class ="container">
			<table class="table">
				<tr>
					<td rowspan=3><img src="resources/Logo.png"></td>
				</tr>
				<tr>
					<td><h4><a href="backfromupdate" class="badge badge-dark">Back</a></h4></td>
					<td><H1 >Users</H1></td>
					<td><h4><a href="home.jsp" class="badge badge-dark">Return Home</a></h4></td>
				</tr>
			</table>
			<c:set var = "disabled" scope = "session" value = "true"/>	
			<core:if test="${disable == disabled}">
				<div class="font-weight-bold alert alert-success">
				${msg}
				</div>
			</core:if>
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
					<td><strong>Disabled</strong></td> 
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
						<td>${temp.disabled}</td>	
						
						
						
						
						
						
						
						
						
						<td>
						<c:set var = "type" scope = "session" value = "user"/>	
						<core:if test="${temp.accounttype == type}">
							<form id="disable user" action="disableuser" method="post">
							<input type="hidden" id="accountnumber" name="accountnumber" value="${temp.accountnumber}" >
							<input type="submit" value="Disable" class= "btn btn-primary btn-lg btn-block">
							</form>
						</core:if>
						</td>
						<c:set var = "type2" scope = "session" value = "Admin"/>	
						<core:if test="${temp.accounttype == type2}">
						<td></td>
						</core:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>