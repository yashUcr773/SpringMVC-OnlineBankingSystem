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
				<td><H1 >Transactions</H1></td>
				<td><h4><a href="home.jsp" class="badge badge-dark">Return Home</a></h4></td>
			</tr>
			</table>
		</div>
	</div>
	
	
	
	
	
	
	<div class="container">
        <table class="table table-striped">
            <thead>
            	<tr class="tr tr-success">
					<td><strong>TransactionID</strong></td>
					<td><strong>Sender</strong></td>
					<td><strong>Receiver</strong></td>
					<td><strong>Amount</strong></td>
					<td><strong>Remark</strong></td>
					<td><strong>Time Stamp</strong></td>
					<td><strong>Date</strong></td> 
				</tr>
            </thead>
            <tbody>
                <c:forEach items="${transaction}" var="temp">
                    <tr>
						<td>${temp.transactionID}</td>
						<td>${temp.sender}</td>
						<td>${temp.recipient}</td>
						<td>${temp.amount}</td>
						<td>${temp.remark}</td>
						<td>${temp.timestamp}</td>
						<td>${temp.date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>