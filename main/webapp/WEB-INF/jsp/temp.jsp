<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<Html>
<Head>
<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<title>Temp</title>
</Head>
<body>
	<div class="jumbotron">
		<div class ="container">
			<table class="table">
			<tr>
				<td><H1 >Temp</H1></td>
			</tr>
			</table>
		</div>
	</div>
	
	<div class="form-group">
		<form:form id="TempForm" modelAttribute="temp" action="tempProcess" method="post">
			<table class="table table-hover">
				<tr>
					<td><form:label path="username">User Name: </form:label></td>
					<td><form:input path="username" name="username" id="username"/></td>
				</tr>
				<tr>
					<td><form:label path="date">Date(DD-MM-YYYY): </form:label></td>
					<td><form:input path="date" name="date" id="date"/></td>
				</tr>
				<tr>
					<td><form:label path="country">Country : </form:label></td>
					<td>
						<form:select path="country">
							<form:option value="None" label="----Select-----"></form:option>
							<form:options items="${countries}"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><form:button id="Temp" name="Temp" class= "btn btn-primary btn-lg btn-block">Apply</form:button></td>
				</tr>
			</table>
		</form:form>
	</div>
	
	
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</Html>