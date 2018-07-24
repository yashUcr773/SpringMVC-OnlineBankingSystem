<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>Temp</title>

</head>
<body>
	
	<div class="form-group">
		<form:form id="loginForm" modelAttribute="login" action="tempProcess" method="post">
			<table class="table table-hover">
				<tr>
					<td><form:label path="username">Username: </form:label></td>
					<td><form:input path="username" name="username" id="username"/></td>
				</tr>
				<tr>
					<td><form:label path="accountnumber">Account Number: </form:label></td>
					<td><form:input path="accountnumber" name="accountnumber" id="accountnumber" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password:</form:label></td>
					<td><form:password path="password" name="password" id="password"/></td>
				</tr>
				<tr>
					<td><form:label path="displayedcaptcha">Displayed Captcha</form:label></td>
					<td>
						<canvas id="myCanvas" width="200" height="100" style="border:1px solid #d3d3d3;">
							Your browser does not support the HTML5 canvas tag.
						</canvas>
					
					</td>
				</tr>
				<tr>
					<td><form:label path="enteredcaptcha">Captcha:</form:label></td>
					<td><form:input path="enteredcaptcha" name="enteredcaptcha" id="enteredcaptcha"/></td>
				</tr>
				<tr>
					<td colspan="2"><form:button id="login" name="login" class= "btn btn-primary btn-lg btn-block">Login</form:button></td>
				</tr>
			</table>
		</form:form>
	</div>
${captcha}
<script>
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.font = "30px Arial";
var captcha = "${login.displayedcaptcha}";
ctx.fillText(captcha,10,50);
</script>
	
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>