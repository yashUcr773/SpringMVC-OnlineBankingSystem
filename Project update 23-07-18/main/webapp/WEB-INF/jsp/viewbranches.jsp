<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
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

<title>Branches</title>


</head>

<body>

<div class="jumbotron">
		<div class ="container">
		
			<table class="table">
						<tr>
				<td rowspan=3><img src="resources/Logo.png"></td>
			</tr>
			<tr>
				<c:set var = "temp" scope = "session" value = "true"/>	
				<core:if test="${ShowAll == temp}">
					<td><h4><a href="backfromupdate" class="badge badge-dark">Back</a></h4></td>
				</core:if>
				<td><H1 >Branches</H1></td>
				<td><h4><a href="home.jsp" class="badge badge-dark">Return Home</a></h4></td>
			</tr>
			</table>
		</div>
	</div>
	
	
	
	
	
	
        <table class="table table-striped table-bordered tablesorter" id="myTable" style="">
            <thead>
            	<tr>
					<td><strong>Name</strong></td>
					<td><strong>Address</strong></td>
					<td><strong>Code</strong></td>	
					<td><strong>Contact</strong></td>
					<c:set var = "show" scope = "session" value = "true"/>	
					<core:if test="${ShowAll == show}">
						<td><strong>Branch</strong></td>
						<td><strong>City</strong></td>
						<td><strong>District</strong></td>
					</core:if>
				</tr>
            </thead>
            <tbody>
                <c:forEach items="${ifsc}" var="temp">
                    <tr>
						<td>${temp.name}</td>
						<td>${temp.address}</td>
						<td>${temp.code}</td>
						<td>${temp.contact}</td>
					<c:set var = "show" scope = "session" value = "true"/>	
					<core:if test="${ShowAll == show}">
							<td>${temp.branch}</td>
							<td>${temp.city}</td>
							<td>${temp.district}</td>
						</core:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>