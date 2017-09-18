<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="com.nagarro.assignment10.session.Session"%>
<style>
div#welcomeheading h1 {
	position: relative;
	text-align: centre;
	left: 35%;
}

div#login {
	position: relative;
	top: 30px;
	left: 730px;
	font: bold;
	font-family: sans-serif;
	font-size: 25px;
	width: 500px;
	font: bold;
	padding: 0px;
}

div#login a {
	color: white;
	text-decoration: none;
	background-color: #2fa3f9;
	padding: 10px;
}
</style>
<body>
	<div id="welcomeheading">
		<h1>Welcome to Flight Search Portal</h1>
	</div>
	
	<!-- 	check if islogged in is false or true or check a method to see if the user is insesion or not  if not logged in then hide this button-->
	<spring:url value="/login" var="login" htmlEscape="true" />

	<div id="login">
		<a href="${login}">Click here to Login</a>
	</div>
</body>
<script type="text/javascript" src="/Assignment10/scripts/jquery.js"></script>
<script type="text/javascript">
if(<spring:eval expression="T(com.nagarro.assignment10.session.Session).isLoggedIn()" />){
	$("#login").css("display","none");
}
else{
	$("#login").css("display","block");

};
</script>
</html>
