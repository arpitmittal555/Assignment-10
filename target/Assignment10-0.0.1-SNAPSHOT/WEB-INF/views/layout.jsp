<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" /></title>
</head>
<style>
html {
	padding: 0px;
}
</style>
<body>
	<div class="container">
		<!-- Header -->
		<tiles:insertAttribute name="header" />
		<!-- Menu Page -->
		<div class="span-5  border"
			style="height: 650px; float: left; margin: 10px 0 10px 0;">
			<tiles:insertAttribute name="menu" />
		</div>
		<!-- Body Page -->
		<div class="span-19 last"
			style="min-height: 720px; margin: 10px 0 10px 0;">
			<tiles:insertAttribute name="body" />
		</div>
		<!-- Footer Page -->
		<div class="span-19 last" style="margin: 0px; padding: 0px;">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>