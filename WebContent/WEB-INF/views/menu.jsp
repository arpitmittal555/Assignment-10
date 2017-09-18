<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<style>
div#menu {
	background-color: #efefef;
	border-radius: 10px;
	padding: 0;
	padding: 40px;
	font: bold;
	font-family: sans-serif;
	height: 650px;
}

div#menu ul {
	padding: 10px;
}

div#menu a {
	text-decoration: none;
	color: #0579cf;
}
</style>
<div id="menu">
	<ul style="list-style: none; line-height: 28px;">

		<spring:url value="/welcome" var="welcome" htmlEscape="true" />
		<a href="${welcome}">Home</a>
		<br>

		<spring:url value="/flightSearch" var="flightSeacrh" htmlEscape="true" />
		<a href="${flightSeacrh}">Flight Search</a>
		<br>
		
		<div id="upload">
			<spring:url value="/upload" var="upload" htmlEscape="true" />
			<a href="${upload}">Upload New Data</a>
		</div>
		
		<br>
		<br>
		<br>
		<br>
		
		<div id="logout">
			<spring:url value="/logout" var="logout" htmlEscape="true" />
			<a href="${logout}">LOGOUT</a>
		</div>

	</ul>
</div>
<script type="text/javascript" src="/Assignment10/scripts/jquery.js"></script>
<script type="text/javascript">
if(<spring:eval expression="T(com.nagarro.assignment10.session.Session).isLoggedIn()" />){
	$("#logout").css("display","block");
}
else{
	$("#logout").css("display","none");
};

if(<spring:eval expression="T(com.nagarro.assignment10.session.Session).isAdmin()" />){
	$("#upload").css("display","block");
}
else{
	$("#upload").css("display","none");
}
</script>