<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<spring:url value="/welcome" var="welcome" htmlEscape="true" />
	<form action="${welcome}" method="post">
		<input id="startJourney" type="submit" value="start">
	</form>
</body>
<script type="text/javascript" src="/Assignment10/scripts/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#startJourney').click();
	});
</script>
</html>