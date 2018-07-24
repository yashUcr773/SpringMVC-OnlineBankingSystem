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

<title>Login</title>

</head>
<body>
	<div class="jumbotron">
		<div class ="container">
			<table class="table">
						<tr>
				<td rowspan=2><img src="resources/Logo.png"></td>
			</tr>
			<tr>
				<td><H1 >Login</H1></td>
				<td><h4><a href="home.jsp" class="badge badge-dark">Return Home</a></h4></td>
			</tr>
			</table>
			<c:set var = "updated" scope = "session" value = "Username or Password is Incorrect!!"/>	
			<core:if test="${message == updated}">
				<div class="font-weight-bold alert alert-danger">
				${message}
				</div>
			</core:if>
			<c:set var = "updated" scope = "session" value = "Captcha Doesn't Match"/>	
			<core:if test="${message == updated}">
				<div class="font-weight-bold alert alert-danger">
				${message}
				</div>
			</core:if>
			<c:set var = "disabled" scope = "session" value = "You have been disabled. Contact Bank for furthur details."/>	
			<core:if test="${message == disabled}">
				<div class="font-weight-bold alert alert-danger">
				${message}
				</div>
			</core:if>
		</div>
	</div>
	
	<div class="form-group">
		<form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post">
			<table class="table table-hover">
				<tr>
					<td><form:label path="username">Username: </form:label></td>
					<td colspan=2><form:input path="username" name="username" id="username"/></td>
				</tr>
				<tr>
					<td><form:label path="accountnumber">Account Number: </form:label></td>
					<td colspan=2><form:input path="accountnumber" name="accountnumber" id="accountnumber" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password:</form:label></td>
					<td colspan=2><form:password path="password" name="password" id="password"/></td>
				</tr>
				
				
				
				
				<tr>
					<td><form:label path="displayedcaptcha" name="displayedcaptcha" id="displayedcaptcha" value="displayedcaptcha">Displayed Captcha</form:label></td>
										<td>
						<canvas id="myCanvas" width="200" height="100" style="border:1px solid #d3d3d3;">
							Your browser does not support the HTML5 canvas tag.
						</canvas>
						<form:hidden path="displayedcaptcha" value="${login.displayedcaptcha}"/>
					</td>
					<td>
					<form:button id="refresh" name="refresh" value = "refresh" class= "btn btn-primary btn-lg btn-block">Re-Captcha</form:button>
					</td>
				</tr>
				
				
				
				
				
				<tr>
					<td><form:label path="enteredcaptcha">Captcha:</form:label></td>
					<td colspan=2><form:input path="enteredcaptcha" name="enteredcaptcha" id="enteredcaptcha"/></td>
				</tr>
				<tr>
					<td colspan=3><form:button id="login" name="login" value="login" class= "btn btn-primary btn-lg btn-block">Login</form:button></td>
				</tr>
			</table>
		</form:form>
	</div>

<img id="scream" src="resources/asphalt.jpg" alt="The Scream" width="0" height="0">
<script>
document.getElementById("displayedcaptcha").value = "${login.displayedcaptcha}";
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");


var img = document.getElementById("scream");
ctx.drawImage(img,0,0);  



ctx.moveTo(0, 0);
ctx.lineTo(200,25);
ctx.stroke();
ctx.moveTo(0, 0);
ctx.lineTo(200,75);
ctx.stroke();
ctx.moveTo(0, 0);
ctx.lineTo(200,100);
ctx.stroke();
ctx.moveTo(0, 0);
ctx.lineTo(150,100);
ctx.stroke();
ctx.moveTo(0, 0);
ctx.lineTo(50,100);
ctx.stroke();
ctx.moveTo(0, 0);
ctx.lineTo(0,100);
ctx.stroke();



ctx.font = "30px Arial";
var captcha = "${login.displayedcaptcha}";
ctx.fillText(captcha,10,50);
</script>
	
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>