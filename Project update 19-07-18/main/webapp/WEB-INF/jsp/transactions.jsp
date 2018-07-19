<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="webjars/tablesorter/2.15.5/css/theme.blue.css" rel="stylesheet" type="text/css">
<link href="webjars/tablesorter/2.15.5/css/theme.bootstrap.css" rel="stylesheet" type="text/css">
<link href="webjars/tablesorter/2.15.5/css/theme.bootstrap_2.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script> 
<script type="text/javascript" src="webjars/tablesorter/2.15.5/js/jquery.tablesorter.min.js"></script>
<script type="text/javascript" src="webjars/tablesorter/2.15.5/js/jquery.tablesorter.widgets-filter-formatter.min.js"></script>
<script type="text/javascript" src="webjars/tablesorter/2.15.5/js/jquery.tablesorter.widgets.min.js"></script>
<script>
$(document).ready(function() { 
    $("#myTable")
    .tablesorter({
        headers: { 0: { sorter: false }, 1: { sorter: false }, 6: { sorter: false }},
        sortList: [[2, 0], [0, 0]],
        widthFixed: true,
        widgets: ['zebra']})
    .tablesorterPager({container: $("#pager")}); 
}); 
</script>
<style>
.tablesorter th:after,
.tablesorter thead {
  cursor: pointer;
}
.tablesorter th:after {
  content: ' ';
  position: relative;
  left: 10px;
  border: 7px solid transparent;
}
.tablesorter th:not(.headerSortUp):after {
  top: 10px;
  border-top-color: silver;
}
.tablesorter th.headerSortUp:after {
  bottom: 15px;
  border-bottom-color: silver;
}
.headerSortDown,
.headerSortUp {
  opacity: 0.8;
}

</style>
<title>Your Transactions</title>
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
				<td><H1 >Transactions</H1></td>
				<td><h4><a href="home.jsp" class="badge badge-dark">Return Home</a></h4></td>
			</tr>
			</table>
		</div>
	</div>
	
	
	<table class="table table-striped" style="font-align:center">
		<tr>
			<td style="text-align: right"><a href="generatepdf" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Generate Pdf</a></td>
			<td><a href="exporttoexcel" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Export to Excel</a></td>
		</tr>
	
	</table>
	
	
	
	
	<div class="container">
        <table class="table table-striped tablesorter" id="myTable">
            <thead>
            	<tr class="tr tr-success">
					<th><strong>TransactionID</strong></th>
					<th><strong>Sender</strong></th>
					<th><strong>Receiver</strong></th>
					<th><strong>Amount</strong></th>
					<th><strong>Remark</strong></th>
					<th><strong>Time Stamp</strong></th>
					<th><strong>Date</strong></th> 
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